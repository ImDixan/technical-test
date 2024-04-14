package com.dsoftcode.wastemanager.models;

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
    private Long id;

    @Column(name = "AUTHORIZATION_NUMBER")
    private String authorizationNumber;

    @ManyToOne
    @JoinColumn(name = "WASTE_MANAGER_ID")
    private WasteManagerEntity wasteManagerEntity;
}
