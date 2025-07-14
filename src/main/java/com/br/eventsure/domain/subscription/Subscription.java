package com.br.eventsure.domain.subscription;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subscription {
    private UUID id;
    private String name;
    private String url;
    private List<String> eventTypes;
    private boolean active;

    public Subscription(String name, String url, List<String> eventTypes, boolean active) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.url = url;
        this.eventTypes = eventTypes;
        this.active = active;
    }

    public static Subscription createNew(String name, String url, List<String> eventTypes, boolean active) {
        UUID newId = UUID.randomUUID();
        return new Subscription(newId, name, url, eventTypes, active);
    }

    public static Subscription rehydrate(UUID id, String name, String url, List<String> eventTypes, boolean active) {
        return new Subscription(id, name, url, eventTypes, active);
    }
}
