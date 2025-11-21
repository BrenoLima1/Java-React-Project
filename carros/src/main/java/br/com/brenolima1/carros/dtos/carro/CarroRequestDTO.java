package br.com.brenolima1.carros.dtos.carro;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class CarroRequestDTO {
    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @Min(value = 1886, message = "O ano deve ser maior que 1886")
    private int ano;

    @PositiveOrZero(message = "O preço deve ser maior ou igual a zero")
    private double preco;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    private Long donoId; // ID do dono do carro

    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getPreco() { return preco; }
    public String getMarca() { return marca; }
    public Long getDonoId() { return donoId; }
}