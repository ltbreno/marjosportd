package com.marjosports.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marjosports.API.model.Usuario;
import com.marjosports.API.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	

    public Usuario login(String cpf, String senha) {
        Usuario usuario = usuarioRepository.findByCpf(cpf);
        
       
        if (usuario != null && usuario.getPassword().equals(senha)) {
            return usuario;
        }
        
        return null; 
    }
	
	public void create(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	

}
