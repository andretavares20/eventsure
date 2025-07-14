package com.br.eventsure.adapter.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.eventsure.adapter.web.dto.CreateSubscriptionRequest;
import com.br.eventsure.adapter.web.dto.CreateSubscriptionResponse;
import com.br.eventsure.application.usecase.RegisterSubscriptionUseCase;
import com.br.eventsure.domain.subscription.Subscription;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final RegisterSubscriptionUseCase registerUseCase;

    @PostMapping
    public ResponseEntity<CreateSubscriptionResponse> create(@RequestBody CreateSubscriptionRequest request) {
        Subscription subscription = registerUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
            new CreateSubscriptionResponse(subscription.getId(), "Subscription created")
        );
    }
}
