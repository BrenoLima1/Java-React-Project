package br.com.brenolima1.carros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brenolima1.carros.models.Carro;
import br.com.brenolima1.carros.repository.CarroRepository;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/carros")
public class CarroController {
    private final CarroRepository repo;

    public CarroController(CarroRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Carro> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Carro criarCarro(@RequestBody Carro carro) {
        return repo.save(carro);
    }

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable(value = "id") Long id) {
        return repo.findById(id).orElseThrow(
            () -> new RuntimeException("Carro não encontrado")
        );
    }
    
    @PutMapping("/{id}")
    public Carro atualizarCarro(@PathVariable Long id, @RequestBody Carro carro) {
        Carro carroExistente = repo.findById(id).orElseThrow(
            () -> new RuntimeException("Carro não encontrado")
        );
        carroExistente.setNome(carro.getNome());
        carroExistente.setMarca(carro.getMarca());
        carroExistente.setAno(carro.getAno());
        return repo.save(carroExistente);
    }

    @DeleteMapping("/{id}")
    public void deletarCarro(@PathVariable Long id) {
        repo.deleteById(id);
    }
    
    
}
