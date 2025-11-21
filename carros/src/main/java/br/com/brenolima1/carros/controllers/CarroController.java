package br.com.brenolima1.carros.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brenolima1.carros.dtos.carro.CarroRequestDTO;
import br.com.brenolima1.carros.dtos.carro.CarroResponseDTO;
import br.com.brenolima1.carros.mapper.CarroMapper;
import br.com.brenolima1.carros.models.Carro;
import br.com.brenolima1.carros.models.Usuario;
import br.com.brenolima1.carros.services.CarroService;
import br.com.brenolima1.carros.services.UsuarioService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
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
    private final UsuarioService usuarioService;

    public CarroController(CarroService carroService, UsuarioService usuarioService) {
        this.carroService = carroService;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<CarroResponseDTO>> listarCarros() {
        List<Carro> carros = carroService.listarCarros();
        List<CarroResponseDTO> dtos = carros.stream()
                .map(CarroMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }    

    @PostMapping
    public ResponseEntity<CarroResponseDTO> salvarCarro(@Valid @RequestBody CarroRequestDTO dto) {
        Usuario dono = usuarioService.buscarUsuario(dto.getDonoId());
        Carro carro = CarroMapper.toEntity(dto, dono);
        Carro novoCarro = carroService.salvarCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(CarroMapper.toDTO(novoCarro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id) {
        carroService.deletarCarro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> atualizarCarro(@PathVariable Long id, @Valid @RequestBody CarroRequestDTO dto) {
        Usuario dono = usuarioService.buscarUsuario(dto.getDonoId());
        Carro carro = CarroMapper.toEntity(dto, dono);
        carro.setId(id);
        Carro atualizado = carroService.atualizarCarro(carro);
        return ResponseEntity.ok(CarroMapper.toDTO(atualizado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> buscarCarro(@PathVariable Long id) {
        Carro carro = carroService.buscarCarro(id);
        return ResponseEntity.ok(CarroMapper.toDTO(carro));
    }
}