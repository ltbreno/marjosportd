package com.marjosports.API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
		 if (usuario.getCpf() == null) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF não pode ser nulo");
	        }

		 if (usuarioRepository.existsByCpf(usuario.getCpf())) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF já cadastrado");
	        }
		usuarioRepository.save(usuario);
	}
	
	public List<String> getAllCpfs() {
        return usuarioRepository.findAllCpfs();
    }

	

}
