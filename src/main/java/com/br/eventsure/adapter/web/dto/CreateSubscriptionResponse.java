package com.br.eventsure.adapter.web.dto;

import java.util.UUID;

public record CreateSubscriptionResponse(
    UUID id,
    String message
) {}
