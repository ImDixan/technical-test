package com.dsoftcode.wastemanageraddress.repositories;

import com.dsoftcode.wastemanageraddress.models.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteManagerAddressEntityRepository extends JpaRepository<WasteManagerAddressEntity, Long> {
}