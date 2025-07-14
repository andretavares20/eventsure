package com.br.eventsure.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.br.eventsure.domain.subscription.Subscription;
import com.br.eventsure.infrastructure.persistence.entity.SubscriptionEntity;

@Component
public class SubscriptionMapper {

    public SubscriptionEntity toEntity(Subscription subscription) {
        SubscriptionEntity entity = new SubscriptionEntity();
        entity.setId(subscription.getId());
        entity.setName(subscription.getName());
        entity.setUrl(subscription.getUrl());
        entity.setEventTypes(subscription.getEventTypes());
        entity.setActive(subscription.isActive());
        return entity;
    }

    public Subscription toDomain(SubscriptionEntity entity) {
        return Subscription.rehydrate(entity.getId(), entity.getName(), entity.getUrl(), entity.getEventTypes(),
                entity.isActive());

    }
}
