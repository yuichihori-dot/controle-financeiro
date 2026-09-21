package com.thiago.controle_financeiro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private double valor;
    private String categoria;

    protected Transacao() {
        // construtor vazio exigido pelo JPA — não use ele diretamente
    }

    public Transacao(String descricao, double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor da transação não pode ser negativo.");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("A descrição da transação não pode ser nula ou vazia.");
        }
        this.descricao = descricao;
        this.valor = valor;
        categorizar();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void categorizar() {
        if (descricao.contains("Uber") || descricao.contains("99")) {
            this.categoria = "Transporte";
        } else if (descricao.contains("Mercado") || descricao.contains("Supermercado")) {
            this.categoria = "Alimentação";
        } else if (descricao.contains("Salario")) {
            this.categoria = "renda";
        } else {
            this.categoria = "Outros";
        }
    }

    public void exibir() {
        System.out.println(descricao + " - R$" + valor + " - " + categoria);
    }
}