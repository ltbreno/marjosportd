package com.marjosports.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marjosports.API.model.Usuario;
import com.marjosports.API.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Usuario usuario) {
        usuarioService.create(usuario);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Usuario loggedUser = usuarioService.login(usuario.getCpf(), usuario.getPassword());
        
        if (loggedUser != null) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed. Please check your credentials.");
        }
    }
    
    @GetMapping("/cpfs/{id}")
    public ResponseEntity<?> getAllCpfs(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        
        if (usuario.isAdmin()) {
            List<String> allCpfs = usuarioService.getAllCpfs();
            return ResponseEntity.ok(allCpfs);
        } else {
            String cpf = usuario.getCpf(); 
            return ResponseEntity.ok(cpf);
        }
    }
}
