package com.dsoftcode.wastemanager.repositories;

import com.dsoftcode.wastemanager.models.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteManagerEntityRepository extends JpaRepository<WasteManagerEntity, Long> {
}