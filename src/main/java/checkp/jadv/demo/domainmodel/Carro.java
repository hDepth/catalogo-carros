package checkp.jadv.demo.domainmodel;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private int potencia;

    @Column(nullable = false)
    private double economia;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private double preco;

    // Construtor padrão (necessário para JPA)
    public Carro() {
    }

    // Construtor sem ID (o banco de dados gera automaticamente)
    public Carro(String marca, String modelo, int ano, int potencia, double economia, String tipo, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.potencia = potencia;
        this.economia = economia;
        this.tipo = tipo;
        this.preco = preco;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
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
