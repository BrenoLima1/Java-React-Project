package br.com.brenolima1.carros.exception;

public class CarroNaoEncontradoException extends RuntimeException {
    public CarroNaoEncontradoException(Long id) {
        super("Carro não encontrado com o id: " + id);
    }
}