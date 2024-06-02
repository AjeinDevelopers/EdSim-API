package com.educasim.educasim.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List<Contacto> contactos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nombre_idNombre", referencedColumnName = "idNombre")
    private Nombre nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FormaAprendizaje_idFAprendizaje",referencedColumnName = "idFAprendizaje")
    private FormaAprendizaje formaAprendizaje;


    private List<Clase> clases;
    private List<Progreso> progreso;

}
