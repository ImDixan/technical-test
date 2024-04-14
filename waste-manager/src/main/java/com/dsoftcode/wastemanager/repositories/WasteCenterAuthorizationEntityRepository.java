package com.dsoftcode.wastemanager.repositories;

import com.dsoftcode.wastemanager.models.WasteCenterAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteCenterAuthorizationEntityRepository extends JpaRepository<WasteCenterAuthorizationEntity, Long> {
}