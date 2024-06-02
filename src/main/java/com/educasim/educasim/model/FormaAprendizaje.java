package com.educasim.educasim.model;


import jakarta.persistence.*;

@Entity
public class FormaAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;


}
