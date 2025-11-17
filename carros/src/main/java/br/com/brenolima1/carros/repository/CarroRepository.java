package br.com.brenolima1.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brenolima1.carros.models.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    
}
