package com.br.eventsure.integration;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.br.eventsure.adapter.web.dto.CreateSubscriptionRequest;
import com.br.eventsure.adapter.web.dto.CreateSubscriptionResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SubscriptionIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldCreateAndPersistSubscription() {
        CreateSubscriptionRequest request = new CreateSubscriptionRequest(
            "Webhook Integração",
            "http://localhost:4000/webhook",
            List.of("user.updated"),
            true
        );

        ResponseEntity<CreateSubscriptionResponse> response = restTemplate.postForEntity(
            "/api/subscriptions",
            request,
            CreateSubscriptionResponse.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().id()).isNotNull();
        assertThat(response.getBody().message()).isEqualTo("Subscription created");
    }
}
