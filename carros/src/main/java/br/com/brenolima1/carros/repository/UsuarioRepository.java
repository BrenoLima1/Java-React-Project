package br.com.brenolima1.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brenolima1.carros.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
