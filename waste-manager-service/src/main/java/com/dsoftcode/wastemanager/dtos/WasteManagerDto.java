package com.dsoftcode.wastemanager.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WasteManagerDto {
    private Long id;
    private String nombre;
    private String nif;
    private WasteManagerAddressDto wasteManagerAddress;
    private List<WasteCenterAuthorizationDto> listOfWasteCenterAuthorization;
    private Boolean isEnabled;
    private Long version;
    private Date createdDate;
    private Date lastModifiedDate;
}
