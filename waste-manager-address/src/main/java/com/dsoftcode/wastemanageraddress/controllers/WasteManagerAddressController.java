package com.dsoftcode.wastemanageraddress.controllers;

import com.dsoftcode.wastemanageraddress.dtos.WasteManagerAddressDto;
import com.dsoftcode.wastemanageraddress.services.WasteManagerAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/waste-manager-address")
public class WasteManagerAddressController {

    private final WasteManagerAddressService wasteManagerAddressService;

    @GetMapping("/{wasteManagerId}")
    public ResponseEntity<WasteManagerAddressDto> findByWasteManagerId(@PathVariable("wasteManagerId") Long wasteManagerId) {
        return wasteManagerAddressService.findByWasteManagerId(wasteManagerId);
    }

    @PostMapping("/create/{wasteManagerId}")
    public ResponseEntity<String> create(@RequestBody WasteManagerAddressDto wasteManagerAddressDto, @PathVariable("wasteManagerId") Long wasteManagerId) {

        return wasteManagerAddressService.create(wasteManagerAddressDto, wasteManagerId);
    }

    @PutMapping("/update/{wasteManagerId}")
    public ResponseEntity<String> update(@RequestBody WasteManagerAddressDto wasteManagerAddressDto, @PathVariable("wasteManagerId") Long wasteManagerId) {
        return wasteManagerAddressService.update(wasteManagerAddressDto,wasteManagerId);
    }
}
