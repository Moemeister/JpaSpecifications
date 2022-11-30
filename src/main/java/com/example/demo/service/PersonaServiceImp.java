package com.example.demo.service;

import com.example.demo.dto.RequestParams;
import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.repository.PersonaSpecifications.*;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
@RequiredArgsConstructor
public class PersonaServiceImp implements PersonaService{
    private final PersonaRepository personaRepository;

    @Override
    public Page<Persona> findAll(RequestParams requestParams, Pageable pageable) {
        String nombre = requestParams.getNombre();
        String apellido = requestParams.getApellido();
        Integer dui = requestParams.getDui();
        Integer fecha = requestParams.getFecha();
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(dui);
        System.out.println(fecha);

        return personaRepository.findAll(where(likeNombre(nombre)
                .and(likeApellido(apellido)
                        .and(equaldui(dui)
                                .and(equalFecha(fecha)
                                )
                        )
                )
        ), pageable);
    }
}
