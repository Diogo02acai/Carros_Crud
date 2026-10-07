package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String marca;
    private double preco;
    private int ano;


public Carro(){}

public Carro(String modelo, String marca, double preco, int ano) {
    this.modelo = modelo;
    this.marca = marca;
    this.preco = preco;
    this.ano = ano;
}

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    public String getModelo() {
        return modelo;
    }

    public Long getId() {
        return id;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setId(Long id) {
        this.id = id;
    }

}