package com.example.demo.controller;

import com.example.demo.dto.RequestParams;
import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping("/test")
    public ResponseEntity<List<Persona>> findAll(RequestParams requestParams, Pageable pageable){
        Page<Persona> personas = personaService.findAll(requestParams, pageable);
        List<Persona> personasList = personas.getContent();
        return new ResponseEntity<>(personasList, HttpStatus.OK);
    }
}
