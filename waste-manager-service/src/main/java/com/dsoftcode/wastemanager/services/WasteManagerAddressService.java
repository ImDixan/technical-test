package com.dsoftcode.wastemanager.services;

import com.dsoftcode.wastemanager.dtos.WasteManagerAddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "waste-manager-address-service", url = "http://localhost:8091/api/waste-manager-address/")
public interface WasteManagerAddressService {

    @GetMapping("/{wasteManagerId}")
    ResponseEntity<WasteManagerAddressDto> findByWasteManagerId(@PathVariable("wasteManagerId") Long wasteManagerId);

    @PostMapping("/create/{wasteManagerId}")
    ResponseEntity<String> create(@RequestBody WasteManagerAddressDto wasteManagerAddressDto,
                                  @PathVariable("wasteManagerId") Long wasteManagerId);

    @PutMapping("/update/{wasteManagerId}")
    ResponseEntity<String> update(@RequestBody WasteManagerAddressDto wasteManagerAddressDto,
                                  @PathVariable("wasteManagerId") Long wasteManagerId);

}
