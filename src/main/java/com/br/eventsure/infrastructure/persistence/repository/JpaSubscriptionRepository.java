package com.br.eventsure.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.br.eventsure.domain.subscription.Subscription;
import com.br.eventsure.domain.subscription.SubscriptionRepository;
import com.br.eventsure.infrastructure.persistence.entity.SubscriptionEntity;
import com.br.eventsure.infrastructure.persistence.mapper.SubscriptionMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JpaSubscriptionRepository implements SubscriptionRepository {

    private final SpringDataSubscriptionRepository jpaRepository;
    private final SubscriptionMapper mapper;

    @Override
    public Subscription save(Subscription subscription) {
        SubscriptionEntity entity = mapper.toEntity(subscription);
        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Subscription> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
}
