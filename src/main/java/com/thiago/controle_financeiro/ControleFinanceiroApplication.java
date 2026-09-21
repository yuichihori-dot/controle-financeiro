package com.thiago.controle_financeiro;

import com.thiago.controle_financeiro.model.Transacao;
import com.thiago.controle_financeiro.repository.TransacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControleFinanceiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleFinanceiroApplication.class, args);
    }

    @Bean
    CommandLineRunner carregarDados(TransacaoRepository repository) {
        return args -> {
            repository.save(new Transacao("Uber", 25.9));
            repository.save(new Transacao("Mercado", 30.5));
            repository.save(new Transacao("Salario", 15.0));
        };
    }
}