package com.dsoftcode.wastemanageraddress.services;


import com.dsoftcode.wastemanageraddress.dtos.WasteManagerAddressDto;
import com.dsoftcode.wastemanageraddress.models.WasteManagerAddressEntity;
import com.dsoftcode.wastemanageraddress.repositories.WasteManagerAddressEntityRepository;
import com.dsoftcode.wastemanageraddress.utils.Mappers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WasteManagerAddressService {

    private final WasteManagerAddressEntityRepository wasteManagerAddressRepository;
    private final Mappers mappers;


    public ResponseEntity<WasteManagerAddressDto> findByWasteManagerId(Long wasteManagerId) {
        try {
            Optional<WasteManagerAddressEntity> wasteManagerAddress = wasteManagerAddressRepository.findByWasteManagerId(wasteManagerId);
            if (wasteManagerAddress.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(mappers.wasteManagerAddressToDto(wasteManagerAddress.get()), HttpStatus.OK);
            }
        } catch (Exception error) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<String> create(WasteManagerAddressDto wasteManagerAddressDto, Long wasteManagerId) {
        try {

//          Variable WasteManagerEntity para guardar los datos de la nueva entidad
            WasteManagerAddressEntity wasteManagerAddress = new WasteManagerAddressEntity();

//          Se asignan a wasteManagerAddress los datos de la nueva entidad contenidos en wasteManagerAddressDto
            wasteManagerAddress.setDireccion(wasteManagerAddressDto.getDireccion());
            wasteManagerAddress.setWasteManagerId(wasteManagerId);

//          Al crear un nuevo wasteManagerAddress se asignan por defecto los atributos: isEnable(true), version(0), createdDate(fecha actual)
            wasteManagerAddress.setIsEnabled(true);
            wasteManagerAddress.setVersion(0L);
            wasteManagerAddress.setCreatedDate(Date.from(Instant.now()));

//          Guardar la entidad en la Base de Datos
            wasteManagerAddressRepository.save(wasteManagerAddress);

//          Guardar WasteManagerAddress utilizando el endpoint


            return new ResponseEntity<>("Waste Manager Address creada satisfactoriamente", HttpStatus.CREATED);

        } catch (Exception error) {
//          De ocurrir alguna excepcion devuelve un ResponseEntity con el mensaje de error
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<String> update(WasteManagerAddressDto wasteManagerAddressDto, Long wasteManagerId) {
        try {
//          Buscar el Waste Manager a actualizar por el id
            Optional<WasteManagerAddressEntity> wasteManagerAddress = wasteManagerAddressRepository.findByWasteManagerId(wasteManagerId);

            if (wasteManagerAddress.isEmpty()) {
                return new ResponseEntity<>("El Waste Manager con id: " + wasteManagerAddressDto.getId() + " no tiene dirección asignada", HttpStatus.BAD_REQUEST);
            }

//          Variable WasteManagerEntity para actualizar los datos de la entidad
            WasteManagerAddressEntity newWasteManagerAddress = wasteManagerAddress.get();

//          Se asignan a wasteManager los datos de la nueva entidad contenidos en wasteManagerDto
            newWasteManagerAddress.setDireccion(wasteManagerAddressDto.getDireccion());
            newWasteManagerAddress.setIsEnabled(wasteManagerAddressDto.getIsEnabled());

//          Se actualizan los atributos: version(+1), lastModifiedDate(fecha actual)
            newWasteManagerAddress.setVersion(wasteManagerAddressDto.getVersion() + 1L);
            newWasteManagerAddress.setLastModifiedDate(Date.from(Instant.now()));

//          Guardar la entidad en la Base de Datos
            wasteManagerAddressRepository.save(newWasteManagerAddress);

            return new ResponseEntity<>("Waste Manager Address con managerId: " + wasteManagerId + " actualizado satisfactoriamente", HttpStatus.OK);

        } catch (Exception error) {
//          De ocurrir alguna excepcion devuelve un ResponseEntity con el mensaje de error
            return new ResponseEntity<>(error.getMessage(), HttpStatus.CONFLICT);

        }
    }

    public ResponseEntity<String> delete(Long wasteManagerId) {
        try {
//          Buscar el Waste Manager a eliminar por el id del Waste Manager
            Optional<WasteManagerAddressEntity> wasteManagerAddress = wasteManagerAddressRepository.findByWasteManagerId(wasteManagerId);

            if (wasteManagerAddress.isEmpty()) {
                return new ResponseEntity<>("El Waste Manager con id: " + wasteManagerId + " no tiene dirección asignada", HttpStatus.BAD_REQUEST);
            }

//          Eliminar la entidad en la Base de Datos
            wasteManagerAddressRepository.delete(wasteManagerAddress.get());

            return new ResponseEntity<>("Waste Manager Address con managerId: " + wasteManagerId + " eliminado con éxito", HttpStatus.OK);

        } catch (Exception error) {
//          De ocurrir alguna excepcion devuelve un ResponseEntity con el mensaje de error
            return new ResponseEntity<>(error.getMessage(), HttpStatus.CONFLICT);

        }
    }

}
