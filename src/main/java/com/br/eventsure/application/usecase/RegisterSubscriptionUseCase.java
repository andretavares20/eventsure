package com.br.eventsure.application.usecase;

import com.br.eventsure.adapter.web.dto.CreateSubscriptionRequest;
import com.br.eventsure.domain.subscription.Subscription;

public interface RegisterSubscriptionUseCase {
    Subscription execute(CreateSubscriptionRequest request);
}
