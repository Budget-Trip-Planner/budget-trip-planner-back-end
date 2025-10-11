package com.planner.app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "travelgroup")
public class TravelGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "member_ids", columnDefinition = "uuid[]", nullable = false)
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<UUID> memberIds = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime  createdAt;

    public TravelGroup() {}

    public TravelGroup(String name, List<UUID> memberIds) {
        this.name = name;
        this.memberIds = memberIds;
        this.createdAt = OffsetDateTime.now();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<UUID> getMemberIds() { return memberIds; }

    public void setMemberIds(List<UUID> memberIds) { this.memberIds = memberIds; }

    public OffsetDateTime  getCreatedAt() { return createdAt; }

    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

}
