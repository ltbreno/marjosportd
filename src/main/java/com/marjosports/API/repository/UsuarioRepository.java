package com.marjosports.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marjosports.API.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByCpf(String cpf);
}
