package br.com.brenolima1.carros.dtos.carro;

public class CarroResponseDTO {
    private Long id;
    private String modelo;
    private int ano;
    private double preco;
    private String marca;
    private String donoUsername;

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
    public String getDonoUsername() { return donoUsername; }
    public void setDonoUsername(String donoUsername) { this.donoUsername = donoUsername; }
}
