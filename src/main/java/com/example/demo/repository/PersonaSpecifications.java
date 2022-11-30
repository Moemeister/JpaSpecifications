package com.example.demo.repository;

import com.example.demo.model.Persona;
import org.springframework.data.jpa.domain.Specification;

public class PersonaSpecifications {
    public static Specification<Persona> likeNombre(String nombre) {

        return (root, query, cb) -> {
            if (nombre == null) {
                return cb.conjunction();
            }
            return cb.like(cb.lower(root.get("nombre")),  "%" + nombre + "%");
        };
    }

    public static Specification<Persona> likeApellido(String apellido) {

        return (root, query, cb) -> {
            if (apellido == null) {
                return cb.conjunction();
            }
            return cb.like(cb.lower(root.get("apellido")), "%" + apellido + "%");
        };
    }

    public static Specification<Persona> equaldui(Integer dui) {

        return (root, query, cb) -> {
            if (dui == null) {
                return cb.conjunction();
            }
            return cb.equal(root.get("dui"), dui);
        };
    }

    public static Specification<Persona> equalFecha(Integer fecha) {
        if (fecha == null) {
            return null;
        }
        return (root, query, cb) -> {
            return cb.equal(root.get("fecha"), fecha);
        };
    }
}
