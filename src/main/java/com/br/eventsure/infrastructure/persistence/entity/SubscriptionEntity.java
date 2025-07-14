package com.br.eventsure.infrastructure.persistence.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "subscriptions")
@Data
public class SubscriptionEntity {

    @Id
    private UUID id;

    private String name;

    private String url;

    @ElementCollection
    @CollectionTable(name = "subscription_event_types", joinColumns = @JoinColumn(name = "subscription_id"))
    @Column(name = "event_type")
    private List<String> eventTypes;

    private boolean active;
}
