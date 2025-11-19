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
        Carro carroExistente = carroRepository.findById(carro.getId()).orElseThrow(()-> new CarroNaoEncontradoException(carro.getId()));
        carroExistente.setAno(carro.getAno());
        carroExistente.setMarca(carro.getMarca());
        carroExistente.setModelo(carro.getModelo());
        carroExistente.setNome(carro.getNome());
        carroExistente.setPreco(carro.getPreco());


        return carroRepository.save(carroExistente);
    }

    public Carro buscarCarro(Long id) {
        return carroRepository.findById(id).orElseThrow(()-> new CarroNaoEncontradoException(id));
    }

    public List<Carro> listarCarros() {
        return carroRepository.findAll();
    }

}
