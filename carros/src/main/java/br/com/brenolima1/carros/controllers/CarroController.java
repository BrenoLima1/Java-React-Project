package br.com.brenolima1.carros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brenolima1.carros.models.Carro;
import br.com.brenolima1.carros.services.CarroService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public List<Carro> listarCarros() {
        return carroService.listarCarros();
    }    

    @PostMapping
    public ResponseEntity<Carro> salvarCarro(@Valid @RequestBody Carro carro) {
        Carro novoCarro = carroService.salvarCarro(carro);
        return ResponseEntity.ok(novoCarro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        carroService.deletarCarro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable Long id, @Valid @RequestBody Carro carro) {
        carro.setId(id);
        return ResponseEntity.ok(carroService.atualizarCarro(carro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarCarro(@PathVariable Long id) {
        return ResponseEntity.ok(carroService.buscarCarro(id));
    }
}
