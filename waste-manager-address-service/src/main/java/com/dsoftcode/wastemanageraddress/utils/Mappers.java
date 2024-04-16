package com.dsoftcode.wastemanageraddress.utils;

import com.dsoftcode.wastemanageraddress.dtos.WasteManagerAddressDto;
import com.dsoftcode.wastemanageraddress.models.WasteManagerAddressEntity;
import org.springframework.stereotype.Service;


@Service
public class Mappers {

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

}
