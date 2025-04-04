# 🚗 Catálogo de Carros API - Spring Boot

Bem-vindo ao **Catálogo de Carros API**! 🚀 Este projeto foi desenvolvido utilizando **Spring Boot** para gerenciar um catálogo de veículos, permitindo a consulta, criação, edição e remoção de carros no sistema.

## 📌 Funcionalidades
✅ Cadastro de novos veículos 📝  
✅ Consulta de todos os veículos 🔎  
✅ Consulta de um veículo específico por ID 🆔  
✅ Atualização de informações de um carro 🔄  
✅ Remoção de veículos ❌  
✅ Suporte para veículos de combustão e elétricos ⚡⛽
✅ Testes unitários 🧪  

---

## 🛠️ Tecnologias Utilizadas
- **Java 17** ☕
- **Spring Boot 3** 🚀
- **Spring Data JPA** 🗄️
- **H2 Database (para testes)** 💾
- **MySQL (para produção)** 🏢
- **JUnit** 🧪
- **Maven** 📦

---

## 🚀 Como Executar o Projeto

### 🔧 Pré-requisitos
Antes de rodar o projeto, certifique-se de ter instalado:
- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker (opcional para MySQL)](https://www.docker.com/)

### 💻 Rodando a API
1️⃣ Clone este repositório:
```sh
git clone https://github.com/seu-usuario/catalogo-carros.git
cd catalogo-carros
```

3️⃣ Execute o projeto:
```sh
mvn spring-boot:run
```

4️⃣ Acesse a API via Insomnia/Postman:
```
http://localhost:8080/carros
```

---

## 🔥 Endpoints da API

### 🚘 Veículos
| Método | Endpoint | Descrição |
|--------|----------|------------|
| `GET`  | `/carros` | Retorna todos os veículos |
| `GET`  | `/carros/{id}` | Retorna um veículo específico |
| `GET` | `/carros/potencia` | Retorna os 10 carros com maior potência (ordenados decrescentemente) |
| `GET` | `/carros/economia` | Retorna os 10 carros com maior economia (ordenados decrescentemente) |
| `POST` | `/carros` | Adiciona um novo veículo |
| `PUT`  | `/carros/{id}` | Atualiza um veículo existente |
| `DELETE` | `/carros/{id}` | Remove um veículo |

### 🔥 Exemplo de JSON para Criar um Veículo
```json
{
  "modelo": "Tesla Model S",
  "marca": "Tesla",
  "ano": 2023,
  "tipo": "elétrico"
}
```

---

## 📜 Documentação Swagger
Ainda indisponível, em breve será adicionada!

---

## 🧪 Testes
Para rodar os testes unitários, utilize o comando:
```sh
mvn test
ou
./mvnw test
```

---

## 🤝 Contribuição
Fique à vontade para contribuir com melhorias! Para isso:
1. Faça um **fork** do repositório 🍴
2. Crie uma **branch** nova: `git checkout -b minha-mudanca`
3. Faça suas alterações e commit: `git commit -m "Descrição da mudança"`
4. Envie as alterações: `git push origin minha-mudanca`
5. Abra um **Pull Request** 🚀

---

🚀 **Desenvolvido com 💙 por Pedro Henrique Jorge De Paula (https://github.com/hDepth)**

