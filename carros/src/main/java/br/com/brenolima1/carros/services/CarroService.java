package br.com.brenolima1.carros.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.brenolima1.carros.exception.CarroNaoEncontradoException;
import br.com.brenolima1.carros.models.Carro;
import br.com.brenolima1.carros.repository.CarroRepository;

@Service
public class CarroService {
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro salvarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public void deletarCarro(Long id) {
        carroRepository.deleteById(id);
    }

    public Carro atualizarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro buscarCarro(Long id) {
        return carroRepository.findById(id).orElseThrow(()-> new CarroNaoEncontradoException());
    }

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

}
