package com.example.menuapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "menu_item")
@Getter
@Setter
@NoArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_item_id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_category_id", nullable = false)
    private MenuCategory menuCategory;
}
