# Controle Financeiro

API REST para controle de gastos pessoais, com categorização automática de transações a partir da descrição.

## O problema

Controlar gastos manualmente é repetitivo: toda transação precisa ser classificada numa categoria (Transporte, Alimentação, Renda...) na mão. Esse projeto automatiza isso com uma API que recebe transações, classifica sozinha com base em regras, e persiste tudo num banco de dados.

## Funcionalidades

- Criar uma transação (`POST /transacoes`) — validação de dados e categorização automática.
- Listar todas as transações (`GET /transacoes`).
- Persistência real em banco de dados (não perde os dados ao reiniciar a aplicação).

## Tecnologias

- Java 21
- Spring Boot 4.1.1 (Spring Web)
- Spring Data JPA
- H2 Database (em memória)
- Maven

## Como rodar

Pré-requisitos: JDK 21+.

```bash
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

## Endpoints

### `GET /transacoes`
Retorna todas as transações cadastradas.

**Resposta:**
```json
[
  {
    "id": 1,
    "descricao": "Uber",
    "valor": 25.9,
    "categoria": "Transporte"
  }
]
```

### `POST /transacoes`
Cria uma nova transação.

**Corpo da requisição:**
```json
{
  "descricao": "Cinema",
  "valor": 45.00
}
```

**Resposta:**
```json
{
  "id": 4,
  "descricao": "Cinema",
  "valor": 45.0,
  "categoria": "Outros"
}
```

## Regras de categorização

A categoria é definida automaticamente a partir de palavras-chave na descrição:

| Palavra-chave na descrição | Categoria |
|---|---|
| Uber, 99 | Transporte |
| Mercado, Supermercado | Alimentação |
| Salario | Renda |
| (nenhuma das acima) | Outros |

## Como a IA foi usada

Este projeto foi desenvolvido com apoio de IA (Claude) como tutor, não como autor do código. A IA explicou os conceitos (Spring Boot, JPA, anotações, etc.) e revisou o código, mas a lógica de negócio e a estrutura do projeto foram escritas e entendidas por mim, linha por linha, como parte da minha preparação para a vaga na Agibank.