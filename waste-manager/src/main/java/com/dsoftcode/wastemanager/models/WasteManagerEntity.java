package com.dsoftcode.wastemanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "WASTE_MANAGER")
public class WasteManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "NIF")
    private String nif;

    @OneToOne(mappedBy = "wasteManager")
    private WasteManagerAddressEntity wasteManagerAddressEntity;

    @OneToMany(mappedBy = "wasteManagerEntity")
    @ToString.Exclude
    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorization;

    @Column(name = "IS_ENABLED")
    private Boolean isEnabled;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;
}
