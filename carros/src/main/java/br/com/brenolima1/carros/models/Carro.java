package br.com.brenolima1.carros.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @Column(nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Column(nullable = false)
    @Min(value = 1886, message = "O ano deve ser maior que 1886")
    private int ano;

    @Column(nullable = false)
    @PositiveOrZero(message = "O preço deve ser maior que zero")
    private double preco;

    @Column(nullable = false)
    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    public Carro() {}

    public Carro(String modelo, String nome, int ano, double preco, String marca) {
        this.modelo = modelo;
        this.nome = nome;
        this.ano = ano;
        this.preco = preco;
        this.marca = marca;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
}