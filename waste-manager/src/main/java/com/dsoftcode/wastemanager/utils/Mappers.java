package com.dsoftcode.wastemanager.utils;

import com.dsoftcode.wastemanager.dtos.WasteCenterAuthorizationDto;
import com.dsoftcode.wastemanager.dtos.WasteManagerAddressDto;
import com.dsoftcode.wastemanager.dtos.WasteManagerDto;
import com.dsoftcode.wastemanager.models.WasteCenterAuthorizationEntity;
import com.dsoftcode.wastemanager.models.WasteManagerAddressEntity;
import com.dsoftcode.wastemanager.models.WasteManagerEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mappers {

    public WasteManagerDto wasteManagerToDto(WasteManagerEntity wasteManagerEntity) {

        WasteManagerDto wasteManagerDto = new WasteManagerDto();
        List<WasteCenterAuthorizationDto> wasteCenterAuthorizationList = new ArrayList<>();

        wasteManagerDto.setId(wasteManagerEntity.getId());
        wasteManagerDto.setNombre(wasteManagerEntity.getNombre());
        wasteManagerDto.setNif(wasteManagerEntity.getNif());
        wasteManagerDto.setIsEnabled(wasteManagerEntity.getIsEnabled());
        wasteManagerDto.setVersion(wasteManagerEntity.getVersion());
        wasteManagerDto.setCreatedDate(wasteManagerEntity.getCreatedDate());
        wasteManagerDto.setLastModifiedDate(wasteManagerEntity.getLastModifiedDate());

        for (WasteCenterAuthorizationEntity centerAuthorization : wasteManagerEntity.getListOfWasteCenterAuthorization()) {
            wasteCenterAuthorizationList.add(wasteCenterAuthorizationToDto(centerAuthorization));
        }

        wasteManagerDto.setListOfWasteCenterAuthorization(wasteCenterAuthorizationList);

        wasteManagerDto.setWasteManagerAddress(wasteManagerAddressToDto(wasteManagerEntity.getWasteManagerAddressEntity()));

        return wasteManagerDto;
    }

    public WasteManagerAddressDto wasteManagerAddressToDto(WasteManagerAddressEntity wasteManagerAddress) {

        WasteManagerAddressDto addressDto = new WasteManagerAddressDto();

        addressDto.setId(wasteManagerAddress.getId());
        addressDto.setDireccion(wasteManagerAddress.getDireccion());
        addressDto.setIsEnabled(wasteManagerAddress.getIsEnabled());
        addressDto.setVersion(wasteManagerAddress.getVersion());
        addressDto.setCreatedDate(wasteManagerAddress.getCreatedDate());
        addressDto.setLastModifiedDate(wasteManagerAddress.getLastModifiedDate());

        return addressDto;
    }

    public WasteCenterAuthorizationDto wasteCenterAuthorizationToDto(WasteCenterAuthorizationEntity wasteCenterAuthorization) {

        WasteCenterAuthorizationDto wasteCenterAuthorizationDto = new WasteCenterAuthorizationDto();

        wasteCenterAuthorizationDto.setId(wasteCenterAuthorization.getId());
        wasteCenterAuthorizationDto.setAuthorizationNumber(wasteCenterAuthorization.getAuthorizationNumber());

        return wasteCenterAuthorizationDto;
    }
}
