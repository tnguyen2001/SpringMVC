package com.ntt.lab3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "CATEGORY")
public class Category {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
}