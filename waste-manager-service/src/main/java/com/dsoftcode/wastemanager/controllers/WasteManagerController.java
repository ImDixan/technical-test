package com.dsoftcode.wastemanager.controllers;

import com.dsoftcode.wastemanager.dtos.WasteManagerAddressDto;
import com.dsoftcode.wastemanager.dtos.WasteManagerDto;
import com.dsoftcode.wastemanager.services.WasteManagerAddressService;
import com.dsoftcode.wastemanager.services.WasteManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/waste-manager")
public class WasteManagerController {

    private final WasteManagerService wasteManagerService;
    private final WasteManagerAddressService wasteManagerAddressService;

    @GetMapping("/all")
    public ResponseEntity<List<WasteManagerDto>> findAll() {
        return wasteManagerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteManagerDto> findById(@PathVariable("id") Long id) {
        return wasteManagerService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody WasteManagerDto wasteManagerDto) {
        return wasteManagerService.create(wasteManagerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody WasteManagerDto wasteManagerDto) {
        return wasteManagerService.update(wasteManagerDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        return wasteManagerService.deleteById(id);
    }

    @PostMapping("/address/create/{wasteManagerId}")
    public ResponseEntity<String> createAddress(@RequestBody WasteManagerAddressDto addressDto,
                                                @PathVariable("wasteManagerId") Long wasteManagerId) {

        if (wasteManagerService.findById(wasteManagerId).getStatusCode() == HttpStatus.OK) {
            return wasteManagerAddressService.create(addressDto, wasteManagerId);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/address/update/{wasteManagerId}")
    public ResponseEntity<String> updateAddress(@RequestBody WasteManagerAddressDto addressDto,
                                                @PathVariable("wasteManagerId") Long wasteManagerId) {

        if (wasteManagerService.findById(wasteManagerId).getStatusCode() == HttpStatus.OK) {
            return wasteManagerAddressService.update(addressDto, wasteManagerId);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/address/delete/{wasteManagerId}")
    public ResponseEntity<String> deleteAddress(@PathVariable("wasteManagerId") Long wasteManagerId) {

        if (wasteManagerService.findById(wasteManagerId).getStatusCode() == HttpStatus.OK) {
            return wasteManagerAddressService.delete(wasteManagerId);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
