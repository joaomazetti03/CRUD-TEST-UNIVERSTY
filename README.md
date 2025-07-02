# 📜 Personagens & Itens Mágicos - Prova CRUD

Este projeto é uma aplicação de CRUD (Create, Read, Update, Delete) desenvolvida para gerenciar Personagens e Itens Mágicos, criada para fins de prova em uma Escola de TI. Ele fornece uma API RESTful para interagir com os dados, utilizando Spring Boot para rápido desenvolvimento e gerenciamento de banco de dados em memória H2.

## 🚀 Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias:

* **Java 21**
* **Spring Boot 3.4.4**
* **Spring Data JPA**: Para acesso a dados e persistência no banco de dados.
* **Spring Web**: Para construir a API RESTful.
* **H2 Database**: Banco de dados em memória para desenvolvimento e testes.
* **Springdoc OpenAPI UI (Swagger)**: Para documentação interativa da API.
* **Maven**: Ferramenta de automação de construção de projetos.

## 🛠️ Configuração e Execução

### Pré-requisitos

* Java Development Kit (JDK) 21 ou superior.
* Apache Maven.

### Como Executar

1.  **Clone o repositório:** (Se o código estiver em um repositório Git, adicione aqui o comando `git clone <URL_DO_REPOSITORIO>`).
2.  **Navegue até o diretório do projeto:**
    ```bash
    cd crud-test-universty
    ```
3.  **Compile o projeto com Maven:**
    ```bash
    mvn clean install
    ```
4.  **Execute a aplicação Spring Boot:**
    ```bash
    mvn spring-boot:run
    ```
    A aplicação será iniciada na porta `8081`.

### Acesso ao Swagger UI e H2 Console

* **Swagger UI**: Após iniciar a aplicação, você pode acessar a documentação interativa da API no seu navegador:
    [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
* **H2 Console**: Para inspecionar o banco de dados em memória H2, acesse:
    [http://localhost:8081/h2-console](http://localhost:8081/h2-test-universty/CRUD-TEST-UNIVERSTY-84c2dbb7c08557f3e044b1c0e6cf160f8a9bb7b6/src/main/resources/application.properties)
    Utilize as seguintes credenciais:
    * **JDBC URL**: `jdbc:h2:mem:cinema`
    * **User Name**: `sa`
    * **Password**: (deixe em branco)

## 🌐 Endpoints da API

### `CharacterController` (`/character`)
Gerenciamento de Personagens.

* **GET `/character`**: Busca todos os personagens.
* **GET `/character/{characterId}`**: Busca personagem por ID.
* **POST `/character`**: Cria um novo personagem.
    Exemplo de JSON para requisição:
    ```json
    {
      "characterName": "Warrior1",
      "adventurerName": "John",
      "characterClass": "GUERREIRO",
      "level": 5,
      "attackCharacter": 3,
      "defenseCharacter": 7
    }
    ```
    *Nota: `characterClass` deve ser um dos valores definidos em `CharacterClass` (GUERREIRO, MAGO, ARQUEIRO, LADINO, BARDO).*
* **PUT `/character/{characterId}/adventurer-name`**: Atualiza o nome de aventureiro de um personagem.
* **DELETE `/character/{characterId}`**: Deleta um personagem por ID.

### `MagicItenController` (`/magicIten`)
Gerenciamento de Itens Mágicos.

* **GET `/magicIten`**: Lista todos os itens mágicos.
* **GET `/magicIten/{magicItenId}`**: Busca item mágico por ID.
* **GET `/magicIten/character/{characterId}`**: Busca itens mágicos atribuídos a um personagem.
* **GET `/magicIten/character/{characterId}/amulet`**: Busca o amuleto de um personagem.
* **POST `/magicIten`**: Cria um novo item mágico.
    Exemplo de JSON para requisição:
    ```json
    {
      "magicItenName": "Espada Mágica",
      "magicItenType": "ARMA",
      "attackMagicIten": 5,
      "defenseMagicIten": 0
    }
    ```
    *Nota: `magicItenType` deve ser um dos valores definidos em `MagicItenType` (ARMA, ARMADURA, AMULETO). Regras de validação são aplicadas para `attackMagicIten` e `defenseMagicIten`.*
* **POST `/magicIten/{magicItenId}/add/{characterId}`**: Atribui um item mágico a um personagem.
* **DELETE `/magicIten/{magicItenId}/remove-character`**: Remove um item mágico de um personagem.
* **DELETE `/magicIten/{magicItenId}`**: Deleta um item mágico por ID.

## 📦 Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Spring Boot, com camadas bem definidas:

* **`com.example.provacrud.Model`**: Contém as classes de entidade que mapeiam as tabelas do banco de dados:
    * `Character.java`: Representa um personagem, com atributos como nome, classe, nível e estatísticas. Possui uma relação One-to-Many com `MagicIten`.
    * `MagicIten.java`: Representa um item mágico, com atributos como nome, tipo, ataque e defesa. Possui uma relação Many-to-One com `Character`.
    * `CharacterClass.java`: Enumeração para as classes de personagem (GUERREIRO, MAGO, ARQUEIRO, LADINO, BARDO).
    * `MagicItenType.java`: Enumeração para os tipos de item mágico (ARMA, ARMADURA, AMULETO).
* **`com.example.provacrud.Repository`**: Interfaces que estendem `JpaRepository` para operações de CRUD com o banco de dados.
    * `CharacterRepository.java`
    * `MagicItenRepository.java`
* **`com.example.provacrud.Service`**: Camada de serviço que contém a lógica de negócios e orquestra as operações de repositório.
    * `CharacterService.java`
    * `MagicIntenService.java`
* **`com.example.provacrud.Controller`**: Camada de controle REST que expõe os endpoints da API.
    * `CharacterController.java`
    * `MagicItenController.java`
* **`ProvacrudApplication.java`**: A classe principal da aplicação Spring Boot.
