package com.dsoftcode.wastemanager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class WasteManagerEntity {

    @Id
    private Long id;

    private String nombre;

    private String nif;

    private WasteManagerAddressEntity wasteManagerAddressEntity;

    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorization = new ArrayList<>();

    private Boolean isEnabled = Boolean.TRUE;

    private Long version = 0L;

    private Date createdDate;

    private Date lastModifiedDate;
}
