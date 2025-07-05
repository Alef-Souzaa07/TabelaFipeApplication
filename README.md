# 🔍 Tabela FIPE Java

Este é um projeto em Java que permite consultar informações de **carros**, **motos** e **caminhões** diretamente da [API pública da Tabela FIPE](https://deividfortuna.github.io/fipe/). Ele utiliza o terminal para interagir com o usuário de forma intuitiva.

## 🚗 Funcionalidades

- Escolha do tipo de veículo: **carro**, **moto** ou **caminhão**;
- Listagem de marcas disponíveis para o tipo selecionado;
- Busca por marca usando nome ou código;
- Listagem de modelos da marca selecionada;
- Busca por modelo usando nome ou código;
- Listagem de anos de fabricação disponíveis;
- Exibição de todos os **detalhes do veículo**, incluindo:
  - Valor
  - Código FIPE
  - Mês de referência
  - Tipo de combustível
  - Ano/modelo

---

## 📦 Tecnologias utilizadas

- **Java 17** ou superior
- **API REST da Tabela FIPE**
- **Jackson** (para deserialização JSON)
- **HttpClient** (Java 11+)
- Framework (Spring)

---

## 🛠️ Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
