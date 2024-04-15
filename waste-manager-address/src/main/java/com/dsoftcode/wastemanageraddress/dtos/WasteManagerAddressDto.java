package com.dsoftcode.wastemanageraddress.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class WasteManagerAddressDto {
    private Long id;
    private String direccion;
    private Boolean isEnabled;
    private Long version;
    private Date createdDate;
    private Date lastModifiedDate;
}
