package com.thiago.controle_financeiro.controller;

import com.thiago.controle_financeiro.model.Transacao;
import com.thiago.controle_financeiro.repository.TransacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransacaoController {

    private final TransacaoRepository repository;

    public TransacaoController(TransacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/transacoes")
    public List<Transacao> listar() {
        return repository.findAll();
    }

    @PostMapping("/transacoes")
    public Transacao criar(@RequestBody TransacaoRequest request) {
        Transacao transacao = new Transacao(request.descricao(), request.valor());
        return repository.save(transacao);
    }
}