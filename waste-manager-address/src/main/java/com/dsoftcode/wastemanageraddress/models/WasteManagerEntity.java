package com.dsoftcode.wastemanager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
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
    private Long id;

    @Column()
    private String nombre;

    @Column()
    private String nif;

    @OneToOne(mappedBy = "wasteManager")
    private WasteManagerAddressEntity wasteManagerAddressEntity;

    @OneToMany(mappedBy = "wasteManagerEntity")
    @ToString.Exclude
    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorization = new ArrayList<>();

    @Column()
    private Boolean isEnabled = Boolean.TRUE;

    @Column()
    private Long version = 0L;

    @Column()
    private Date createdDate;

    @Column()
    private Date lastModifiedDate;
}
