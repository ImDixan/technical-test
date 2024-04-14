package com.dsoftcode.wastemanageraddress.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "WASTE_CENTER_AUTHORIZATION")
public class WasteCenterAuthorizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AUTHORIZATION_NUMBER")
    private String authorizationNumber;

    @ManyToOne
    @JoinColumn(name = "WASTE_MANAGER_ID")
    private WasteManagerEntity wasteManagerEntity;
}
