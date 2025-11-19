package br.com.brenolima1.carros.exception;

public class CarroNaoEncontradoException extends RuntimeException {
    public CarroNaoEncontradoException() {
        super("Carro não encontrado");
    }
}