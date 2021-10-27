package com.spring5.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring5.prueba.model.Persona;
import com.spring5.prueba.repository.PersonaRepository;


@Service
public class PersonaServicelmpl implements PersonaService{
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Persona> findAll(Pageable paginable) {
		return personaRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> findById(Long id) {
		return personaRepository.findById(id);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		personaRepository.deleteById(id);
	}

	@Override
	public List<Persona> findAdminById(Long id) {
		List<Persona> personas = personaRepository.findAdminById(id);
		return personas;
	}

}
