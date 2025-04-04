package checkp.jadv.demo.domainmodel;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String marca;
    private String modelo;
    private int ano;
    private int potencia;
    private double economia;
    private String tipo;
    private double preco;

    // Construtor sem argumentos (necessário para JPA)
    public Carro() {
    }

    // Construtor com todos os atributos
    public Carro(UUID id, String marca, String modelo, int ano, int potencia, double economia, String tipo, double preco) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = potencia;
        this.economia = economia;
        this.tipo = tipo;
        this.preco = preco;
    }

    // Getters e Setters (caso ainda não tenha)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public double getEconomia() {
        return economia;
    }

    public void setEconomia(double economia) {
        this.economia = economia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
