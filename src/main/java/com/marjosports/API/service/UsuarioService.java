package com.marjosports.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marjosports.API.model.Usuario;
import com.marjosports.API.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void create(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	

}
