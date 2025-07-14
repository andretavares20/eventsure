package com.br.eventsure.infrastructure.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.eventsure.infrastructure.persistence.entity.SubscriptionEntity;

public interface SpringDataSubscriptionRepository extends JpaRepository<SubscriptionEntity, UUID> {
}
