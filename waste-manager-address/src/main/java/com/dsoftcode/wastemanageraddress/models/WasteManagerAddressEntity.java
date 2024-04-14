package com.dsoftcode.wastemanageraddress.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "WASTE_MANAGER_ADDRESS")
public class WasteManagerAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DIRECCION")
    private String direccion;

    @OneToOne
    @JoinColumn(name = "WASTE_MANAGER_ID")
    private WasteManagerEntity wasteManager;

    @Column(name = "IS_ENABLE")
    private Boolean isEnabled = Boolean.TRUE;

    @Column(name = "VERSION")
    private Long version = 0L;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "LAST_MODIFIED_DATE")
    private Date lastModifiedDate;
}
