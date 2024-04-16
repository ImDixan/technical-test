package com.dsoftcode.wastemanager.services;

import com.dsoftcode.wastemanager.dtos.WasteManagerDto;
import com.dsoftcode.wastemanager.models.WasteManagerEntity;
import com.dsoftcode.wastemanager.repositories.WasteManagerEntityRepository;
import com.dsoftcode.wastemanager.utils.Mappers;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WasteManagerService {

    private final WasteManagerEntityRepository wasteManagerRepository;
    private final Mappers mappers;

    public ResponseEntity<List<WasteManagerDto>> findAll() {
        List<WasteManagerEntity> wasteManagers = wasteManagerRepository.findAll();
        if (wasteManagers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<WasteManagerDto> wasteManagersDto = new ArrayList<>();

            for (WasteManagerEntity wasteManager : wasteManagers) {
                wasteManagersDto.add(mappers.wasteManagerToDto(wasteManager));
            }

            return new ResponseEntity<>(wasteManagersDto, HttpStatus.OK);
        }
    }

    public ResponseEntity<WasteManagerDto> findById(Long id) {
        try {
            Optional<WasteManagerEntity> wasteManager = wasteManagerRepository.findById(id);
            if (wasteManager.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(mappers.wasteManagerToDto(wasteManager.get()), HttpStatus.OK);
            }
        } catch (Exception error) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> create(WasteManagerDto wasteManagerDto) {
        try {

//          Variable WasteManagerEntity para guardar los datos de la nueva entidad
            WasteManagerEntity wasteManager = new WasteManagerEntity();

//          Se asignan a wasteManager los datos de la nueva entidad contenidos en wasteManagerDto
            wasteManager.setNombre(wasteManagerDto.getNombre());
            wasteManager.setNif(wasteManagerDto.getNif());

//          Al crear un nuevo wasteManager se asignan por defecto los atributos: isEnable(true), version(0), createdDate(fecha actual)
            wasteManager.setIsEnabled(true);
            wasteManager.setVersion(0L);
            wasteManager.setCreatedDate(Date.from(Instant.now()));

//          Guardar la entidad en la Base de Datos
            wasteManagerRepository.save(wasteManager);

//          Guardar WasteManagerAddress utilizando el endpoint


            return new ResponseEntity<>("Waste Manager creado satisfactoriamente", HttpStatus.CREATED);

        } catch (Exception error) {
//          De ocurrir alguna excepcion devuelve un ResponseEntity con el mensaje de error
            return new ResponseEntity<>(error.getMessage(), HttpStatus.CONFLICT);

        }
    }

    public ResponseEntity<String> update(WasteManagerDto wasteManagerDto) {
        try {

//          Buscar el Waste Manager a actualizar por el id
            Optional<WasteManagerEntity> wasteManagerOpt = findOptionalById(wasteManagerDto.getId());

            if (wasteManagerOpt.isEmpty()) {
                return new ResponseEntity<>("No existe un Waste Manager con id: " + wasteManagerDto.getId(), HttpStatus.NOT_FOUND);
            }

//          Variable WasteManagerEntity para actualizar los datos de la entidad
            WasteManagerEntity wasteManager = wasteManagerOpt.get();

//          Se asignan a wasteManager los datos de la nueva entidad contenidos en wasteManagerDto
            wasteManager.setNombre(wasteManagerDto.getNombre());
            wasteManager.setNif(wasteManagerDto.getNif());
            wasteManager.setIsEnabled(wasteManagerDto.getIsEnabled());

//          Se actualizan los atributos: version(+1), lastModifiedDate(fecha actual)
            wasteManager.setVersion(wasteManager.getVersion() + 1L);
            wasteManager.setLastModifiedDate(Date.from(Instant.now()));

//          Guardar la entidad en la Base de Datos
            wasteManagerRepository.save(wasteManager);

            return new ResponseEntity<>("Waste Manager con id: " + wasteManager.getId() + " actualizado satisfactoriamente", HttpStatus.CREATED);

        } catch (Exception error) {
//          De ocurrir alguna excepcion devuelve un ResponseEntity con el mensaje de error
            return new ResponseEntity<>(error.getMessage(), HttpStatus.CONFLICT);

        }
    }

    public Optional<WasteManagerEntity> findOptionalById(Long wasteManagerId) {
        return wasteManagerRepository.findById(wasteManagerId);
    }



}