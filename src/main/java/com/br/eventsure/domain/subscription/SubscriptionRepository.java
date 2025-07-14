package com.br.eventsure.domain.subscription;

import java.util.Optional;
import java.util.UUID;

public interface SubscriptionRepository {
    Subscription save(Subscription subscription);
    Optional<Subscription> findById(UUID id);
}
