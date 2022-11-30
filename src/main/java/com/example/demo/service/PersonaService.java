package com.example.demo.service;

import com.example.demo.dto.RequestParams;
import com.example.demo.model.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService {
    Page<Persona> findAll(RequestParams requestParams, Pageable pageable);
}
