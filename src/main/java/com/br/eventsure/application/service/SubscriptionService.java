package com.br.eventsure.application.service;

import org.springframework.stereotype.Service;

import com.br.eventsure.adapter.web.dto.CreateSubscriptionRequest;
import com.br.eventsure.application.usecase.RegisterSubscriptionUseCase;
import com.br.eventsure.domain.subscription.Subscription;
import com.br.eventsure.domain.subscription.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionService implements RegisterSubscriptionUseCase{
    private final SubscriptionRepository repository;

    @Override
    public Subscription execute(CreateSubscriptionRequest request) {
        Subscription subscription = Subscription.createNew(request.name(), request.url(), request.eventTypes(), request.active());
        return repository.save(subscription);
    }
}
