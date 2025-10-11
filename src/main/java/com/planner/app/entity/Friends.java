package com.planner.app.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "friends")
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "friends_ids", columnDefinition = "uuid[]", nullable = false)
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<UUID> friendsIds = new ArrayList<>();

    public Friends() {}

    public Friends(ArrayList<UUID> friendsIds) {
        this.friendsIds = friendsIds;
    }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public List<UUID> getFriendsIds() { return friendsIds; }

    public void setFriendsIds(List<UUID> friendsIds) { this.friendsIds = friendsIds; }

}
