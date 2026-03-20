📌 API de Login com Spring Boot

🧠 Visão Geral

Este projeto é uma API REST de autenticação de usuários desenvolvida usando Spring Boot em Java. Ele foi criado com o objetivo de:

Aprender e aplicar conceitos sólidos de autenticação utilizando o ecossistema Spring.

Implementar um backend capaz de gerenciar usuários, fazer login e proteger rotas.

Servir como base para projetos maiores (mobile, web ou microserviços) que dependam de login/token de acesso.

---

❓Por que foi criado

A API foi criada enquanto estudo desenvolvimento backend com Java e Spring, com foco em:

Entender profundamente o fluxo de autenticação (como receber credenciais e gerar uma resposta segura).

Configurar e usar ferramentas da stack Spring (Web, Security, JPA, etc.).

Exercitar boas práticas de arquitetura (camadas de controller, serviço e persistência).

Documentar um projeto próprio que demonstra habilidades concretas em autenticação de APIs.

---
🛠 Tecnologias usadas

A API foi construída com as seguintes ferramentas:

| Tecnologia         | Funcao                                       |
| ------------------ | -------------------------------------------- |
| Java               | Linguagem de programação                     |
| Spring Boot        | Framework para construir a aplicação         |
| Spring Web         | Criação de controladores REST                |
| Spring Security    | Controle de autenticação e proteção de rotas |
| Spring Data JPA    | Interação com banco de dados                 |
| Banco de dados SQL | Persistência de usuários                     |
| Maven              | Gerenciamento de dependências                |

---
🚀 Funcionalidades

A API oferece:

Registro de usuários

Login de usuários

Proteção de rotas com autenticação

Armazenamento de usuários em banco

Possível uso de JWT ou outra estratégia de token (Ainda sera implementado)

---
🧩 Estrutura do Projeto

A organização do código segue o padrão:

src/

├── main/

│     ├── java/

│     │   └── com/seu/pacote/

│     │       ├── controller/    → Endpoints REST

│     │       ├── service/       → Lógica de negócios

│     │       ├── repository/    → Persistência de dados

│     │       └── model/         → Entidades e DTOs

└── resources
     └── application.properties → Configurações da aplicação

---
🧪 Testando a API

🔹 Postman
<img width="872" height="462" alt="image" src="https://github.com/user-attachments/assets/b65e0e7d-734d-4670-a460-94273e8a2dfe" />
<img width="836" height="534" alt="image" src="https://github.com/user-attachments/assets/2e799a26-4127-4c5e-959e-b1bae3f0fbf4" />
<img width="779" height="282" alt="image" src="https://github.com/user-attachments/assets/a07be1fd-c3a4-4a89-b989-4bb0ff99761b" />

