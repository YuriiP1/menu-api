package com.example.menuapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "image_url")
    private String imageUrl;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    private Menu menu;
}
