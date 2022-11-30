package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table
public class Persona {

    @Id
    private Integer id;

    private String nombre;
    private String apellido;
    private int fecha;
    private int dui;
}
