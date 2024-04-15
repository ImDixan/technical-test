package com.dsoftcode.wastemanager.controllers;

import com.dsoftcode.wastemanager.dtos.WasteManagerDto;
import com.dsoftcode.wastemanager.services.WasteManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/waste-managers")
public class WasteManagerController {

    private final WasteManagerService wasteManagerService;

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

}
