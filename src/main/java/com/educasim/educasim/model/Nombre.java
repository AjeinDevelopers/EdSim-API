package com.educasim.educasim.model;

import jakarta.persistence.*;

@Entity
public class Nombre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idNombre;

    @Column
    private String nombre;

    @Column
    private String apePat;

    @Column
    private String apeMat;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;



}
