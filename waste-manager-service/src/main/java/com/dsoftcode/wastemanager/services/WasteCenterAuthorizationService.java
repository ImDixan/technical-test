package com.dsoftcode.wastemanager.services;

import com.dsoftcode.wastemanager.dtos.WasteCenterAuthorizationDto;
import com.dsoftcode.wastemanager.models.WasteCenterAuthorizationEntity;
import com.dsoftcode.wastemanager.models.WasteManagerEntity;
import com.dsoftcode.wastemanager.repositories.WasteCenterAuthorizationEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WasteCenterAuthorizationService {

    private final WasteCenterAuthorizationEntityRepository wasteCenterAuthorizationRepository;

    public ResponseEntity<String> create(List<WasteCenterAuthorizationDto> wasteCenterAuthorizationList
            , WasteManagerEntity wasteManager) {

        try {
            for (WasteCenterAuthorizationDto centerDto : wasteCenterAuthorizationList) {
                WasteCenterAuthorizationEntity center = new WasteCenterAuthorizationEntity();
                center.setAuthorizationNumber(centerDto.getAuthorizationNumber());
                center.setWasteManagerEntity(wasteManager);
                wasteCenterAuthorizationRepository.save(center);
            }

            return new ResponseEntity<>("Lista de Waste Center Authorization guardadas con éxito", HttpStatus.CREATED);

        } catch (Exception error) {

            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<String> update(List<WasteCenterAuthorizationDto> wasteCenterAuthorizationList
            , WasteManagerEntity wasteManager) {
        try {
            for (WasteCenterAuthorizationDto centerDto : wasteCenterAuthorizationList) {
                WasteCenterAuthorizationEntity center = new WasteCenterAuthorizationEntity();
                center.setId(centerDto.getId());
                center.setAuthorizationNumber(centerDto.getAuthorizationNumber());
                center.setWasteManagerEntity(wasteManager);
                wasteCenterAuthorizationRepository.save(center);
            }

            return new ResponseEntity<>("Lista de Waste Center Authorization actualizadas con éxito", HttpStatus.CREATED);

        } catch (Exception error) {

            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
}
