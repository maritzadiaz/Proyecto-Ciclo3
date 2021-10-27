package com.spring5.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring5.prueba.model.Persona;

public interface PersonaService {
	public List<Persona> findAll();
	public Page<Persona> findAll(Pageable paginable);
	public Optional<Persona> findById(Long id);
	public List<Persona> findAdminById(Long id);
	public Persona save(Persona persona);
	public void deleteById(Long id);
}
