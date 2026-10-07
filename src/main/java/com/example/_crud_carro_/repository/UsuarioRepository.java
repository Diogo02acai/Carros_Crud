package com.example._crud_carro_.repository;

import com.example._crud_carro_.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
