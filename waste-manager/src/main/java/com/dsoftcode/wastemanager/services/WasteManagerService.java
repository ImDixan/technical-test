package com.dsoftcode.wastemanager.services;

import com.dsoftcode.wastemanager.models.WasteManagerEntity;
import com.dsoftcode.wastemanager.repositories.WasteManagerEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WasteManagerService {

    private WasteManagerEntityRepository wasteManagerRepository;

    public ResponseEntity<List<WasteManagerEntity>> findAll() {
        List<WasteManagerEntity> wasteManagers = wasteManagerRepository.findAll();
        if (wasteManagers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(wasteManagers, HttpStatus.OK);
        }
    }

    public ResponseEntity<WasteManagerEntity> findById(Long id) {
        try {
            Optional<WasteManagerEntity> wasteManager = wasteManagerRepository.findById(id);
            if (wasteManager.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(wasteManager.get(), HttpStatus.OK);
            }
        } catch (Exception error) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> create(WasteManagerEntity wasteManager) {
        try {
            wasteManagerRepository.save(wasteManager);
            return new ResponseEntity<>("Waste Manager creado satisfactoriamente",HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
