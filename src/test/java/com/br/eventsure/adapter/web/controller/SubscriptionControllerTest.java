package com.br.eventsure.adapter.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.br.eventsure.adapter.web.dto.CreateSubscriptionRequest;
import com.br.eventsure.application.usecase.RegisterSubscriptionUseCase;
import com.br.eventsure.domain.subscription.Subscription;

@WebMvcTest(SubscriptionController.class)
class SubscriptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterSubscriptionUseCase registerSubscriptionUseCase;

    @Test
    void shouldCreateSubscription() throws Exception {
        UUID fakeId = UUID.randomUUID();

        CreateSubscriptionRequest request = new CreateSubscriptionRequest(
                "MeuWebhook",
                "http://localhost:4000/webhook",
                List.of("user.created"),
                true);

        Subscription fakeSub = Subscription.rehydrate(fakeId, request.name(), request.url(), request.eventTypes(),
                request.active());

        Mockito.when(registerSubscriptionUseCase.execute(Mockito.any())).thenReturn(fakeSub);

        String body = """
                {
                  "name": "MeuWebhook",
                  "url": "http://localhost:4000/webhook",
                  "eventTypes": ["user.created"],
                  "active": true
                }
                """;

        mockMvc.perform(post("/api/subscriptions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(fakeId.toString()))
                .andExpect(jsonPath("$.message").value("Subscription created"));
    }
}
