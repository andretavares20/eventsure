package com.br.eventsure.adapter.web.dto;

import java.util.List;

public record CreateSubscriptionRequest(
    String name,
    String url,
    List<String> eventTypes,
    boolean active
) {}