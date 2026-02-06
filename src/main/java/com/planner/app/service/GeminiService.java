package com.planner.app.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.planner.app.dto.TripRequestDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class GeminiService {
    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url:https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent}")
    private String apiUrl;

    @Value("classpath:prompts/proposals.txt")
    private Resource promptResource;

    private String promptTemplate;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GeminiService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void init() throws IOException {
        this.promptTemplate = promptResource.getContentAsString(StandardCharsets.UTF_8);
    }

    // Generate 3 travel proposals based on TripRequestDTO
    public JsonNode generateTravelProposals(TripRequestDTO request) {
        String prompt = buildPrompt(request);
        String geminiResponse = callGeminiApi(prompt);
        return parseToJson(geminiResponse);
    }

    private String buildPrompt(TripRequestDTO request) {
        String departDate = request.getStartDate() != null
                ? request.getStartDate().format(DateTimeFormatter.ofPattern("dd/MM/yy"))
                : "flexible";

        String preferences = request.getPreferences() != null && !request.getPreferences().isEmpty()
                ? String.join(", ", request.getPreferences())
                : "general";

        String departureCity = request.getDepartureCity() != null
                ? request.getDepartureCity()
                : "any";

        return promptTemplate
                .replace("{budget}", String.format("%.2f", request.getBudget()))
                .replace("{duration}", String.valueOf(request.getDuration()))
                .replace("{departureCity}", departureCity)
                .replace("{departDate}", departDate)
                .replace("{preferences}", preferences);
    }

    private String callGeminiApi(String prompt) {
        String url = apiUrl + "?key=" + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(Map.of("text", prompt)))
                ),
                "generationConfig", Map.of(
                        "responseMimeType", "application/json",
                        "temperature", 0.7
                )
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class
        );
        return extractTextFromResponse(response.getBody());
    }

    private String extractTextFromResponse(String responseBody) {
        try {
            JsonNode root = objectMapper.readTree(responseBody);
            return root.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Gemini response: " + e.getMessage(), e);
        }
    }

    private JsonNode parseToJson(String geminiText) {
        try {
            String cleaned = geminiText
                    .replaceAll("```json\\s*", "")
                    .replaceAll("```\\s*", "")
                    .trim();

            return objectMapper.readTree(cleaned);
        } catch (Exception e) {
            return objectMapper.createObjectNode()
                    .put("rawResponse", geminiText)
                    .put("parseError", e.getMessage());
        }
    }

}