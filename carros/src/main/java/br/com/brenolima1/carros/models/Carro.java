package br.com.brenolima1.carros.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @Min(value = 1886, message = "O ano deve ser maior que 1886")
    private int ano;

    @Column(nullable = false)
    @PositiveOrZero(message = "O preço deve ser maior ou igual a zero")
    private double preco;

    @Column(nullable = false)
    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @ManyToOne
    private Usuario dono;

    public Carro() {}

    public Carro(String modelo, int ano, double preco, String marca, Usuario dono) {
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.marca = marca;
        this.dono = dono;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public Usuario getDono() { return dono; }
    public void setDono(Usuario dono) { this.dono = dono; }
}