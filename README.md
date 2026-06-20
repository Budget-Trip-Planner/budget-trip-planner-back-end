# Budget Trip Planner — Back-end (API)

API REST du projet **Budget Trip Planner**, une application web de planification de
voyage selon budget, préférences et contraintes. Construite avec **Spring Boot**. Projet académique — ESIEE Paris (E5, 2025/2026).

---

## Stack

Spring Boot 3.5 · Java · Spring Data JPA · Spring Security + JWT · Maven · Docker · PostgreSQL

---

## Rôle dans l'architecture

Expose l'API REST consommée par le front Angular, gère l'authentification (JWT)
et la persistance des données dans PostgreSQL (via Spring Data JPA).

```
Front Angular  ──REST/JWT──▶  API Spring Boot  ──JPA──▶  PostgreSQL
```

---

## Prérequis

- Java 17+
- Maven (ou le wrapper `./mvnw`)
- Une base PostgreSQL accessible (voir le dépôt `budget-trip-planner-datamodel`)

---

## Configuration

Les profils d'environnement sont séparés :

- `src/main/resources/dev/application.properties` — développement
- `src/main/resources/prod/application.properties` — production

Renseigner l'URL, l'utilisateur et le mot de passe de la base ainsi que le secret JWT
selon l'environnement.

---

## Lancement

```bash
# Développement (profil dev par défaut)
./mvnw spring-boot:run

# Build du jar
./mvnw clean package

# Via Docker
docker build -t btp-back .
docker run -p 8080:8080 btp-back
```

L'API démarre par défaut sur `http://localhost:8080`.
