package com.planner.app.entity;

import com.planner.app.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "voyages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "object_type", nullable = false, columnDefinition = "TEXT")
    private String objectType;

    @Column(name = "object_id", nullable = false)
    private Integer objectId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_id")
    private Locations departure;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_id", nullable = false)
    private Locations destination;

    @Column(name = "budget_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal budgetTotal;

    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "hotel")
    private String hotel;

    @Convert(converter = StringListConverter.class)
    @Column(name = "tips", columnDefinition = "TEXT")
    private List<String> tips;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @ManyToOne
    @JoinColumn(name = "cover_image_id")
    private Image coverImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = OffsetDateTime.now();
        }
    }
}
