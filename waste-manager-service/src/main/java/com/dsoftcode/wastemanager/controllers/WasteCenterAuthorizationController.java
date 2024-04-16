package com.dsoftcode.wastemanager.controllers;

import com.dsoftcode.wastemanager.dtos.WasteCenterAuthorizationDto;
import com.dsoftcode.wastemanager.models.WasteManagerEntity;
import com.dsoftcode.wastemanager.services.WasteCenterAuthorizationService;
import com.dsoftcode.wastemanager.services.WasteManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/waste-center-authorization")
public class WasteCenterAuthorizationController {

    private final WasteManagerService wasteManagerService;
    private final WasteCenterAuthorizationService centerAuthorizationService;

    @PostMapping("/create/{wasteManagerId}")
    public ResponseEntity<String> create(@RequestBody List<WasteCenterAuthorizationDto> centerAuthorizationList,
                                         @PathVariable(name = "wasteManagerId") Long wasteManagerId) {

        Optional<WasteManagerEntity> wasteManager = wasteManagerService.findOptionalById(wasteManagerId);

        if (wasteManager.isEmpty()) {
            return  new ResponseEntity<>("Solicitud denegada, no existe Waste Manager con id: " + wasteManagerId, HttpStatus.BAD_REQUEST);
        }

        return centerAuthorizationService.create(centerAuthorizationList, wasteManager.get());
    }

    @PutMapping("/update/{wasteManagerId}")
    public ResponseEntity<String> update(@RequestBody List<WasteCenterAuthorizationDto> centerAuthorizationList,
                                         @PathVariable(name = "wasteManagerId") Long wasteManagerId) {

        Optional<WasteManagerEntity> wasteManager = wasteManagerService.findOptionalById(wasteManagerId);

        if (wasteManager.isEmpty()) {
            return  new ResponseEntity<>("Solicitud denegada, no existe Waste Manager con id: " + wasteManagerId, HttpStatus.BAD_REQUEST);
        }

        return centerAuthorizationService.update(centerAuthorizationList, wasteManager.get());
    }

}
