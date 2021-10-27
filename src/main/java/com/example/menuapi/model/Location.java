package com.example.menuapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Basic
    @Column(name = "latitude")
    private String latitude;

    @Basic
    @Column(name = "longitude")
    private String longitude;
}
