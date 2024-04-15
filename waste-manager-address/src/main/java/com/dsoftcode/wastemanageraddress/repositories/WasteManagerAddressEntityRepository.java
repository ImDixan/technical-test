package com.dsoftcode.wastemanageraddress.repositories;

import com.dsoftcode.wastemanageraddress.models.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WasteManagerAddressEntityRepository extends JpaRepository<WasteManagerAddressEntity, Long> {
    Optional<WasteManagerAddressEntity> findByWasteManagerId(Long wasteManagerId);


}