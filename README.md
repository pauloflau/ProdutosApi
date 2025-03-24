# ProdutosAPI

A **ProdutosAPI** é uma API RESTful desenvolvida em Java utilizando Spring Web, Spring JPA, autenticação JWT, Swagger para documentação da API e um banco de dados H2. O Frontend será desenvolvido utilizando Angular.

## Funcionalidades

- **Autenticação e Autorização** utilizando JWT
- **Operações CRUD** (Create, Read, Update, Delete) para gerenciamento de produtos
- **Documentação automática da API** com Swagger
- **Conexão com Banco de Dados** para persistência de produtos
- **Endpoints protegidos** com autenticação via JWT

## Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA**
- **JWT (JSON Web Token)**
- **Swagger** (para documentação)
- **Banco de Dados Relacional** (ex: MySQL, PostgreSQL, H2)
- **Angular 12+** (Frontend)
- **Maven** (Gerenciamento de dependências)

## Pré-requisitos
Antes de rodar a aplicação, certifique-se de ter instalado:
- [JDK 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Postman](https://www.postman.com/downloads/)
- Banco de Dados configurado (MySQL, PostgreSQL ou H2)

## Configuração do Banco de Dados (H2)

1. Configure as credenciais no `application.properties`:
   ```properties
   # Configuração do banco de dados H2 (em memória)
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true  # Habilita o console H2 para visualização do banco

   ````

**Nota:** o banco de dados H2 será criado e destruído a cada execução da aplicação.

Caso queira visualizar os dados no banco, você pode acessar o console do H2 diretamente através do seguinte link (quando a aplicação estiver em execução):

[h2-console](http://localhost:8080/h2-console)

**JDBC URL**: jdbc:h2:mem:testdb

**Username**: sa

**Password**: password

## Executando o Projeto
Clone o repositório e navegue até a pasta do projeto:
```sh
git clone https://github.com/pauloflau/ProdutosAPI.git
cd ProdutosAPI
```

Compile e execute a aplicação com:
```sh
mvn spring-boot:run
```
A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080/api)

## Documentação da API (Swagger)
A documentação da API é gerada automaticamente pelo Swagger. Após a API estar em execução, você pode acessar a documentação via:

[http://localhost:8080/swagger-ui.html]

## Estrutura do Projeto

```
ProdutosAPI/
│── src/
│   ├── main/
│   │   ├── java/com/exemplo/api/produtosapi/
│   │   │   ├── controller/         (Controladores das APIs)
│   │   │   ├── model/              (Entidades JPA)
│   │   │   ├── repository/         (Repositórios JPA)
│   │   │   ├── security/           (Configuração de segurança e JWT)
│── pom.xml
│── README.md

```

## Referências
- [Documentação do Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Documentação do Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/index.html)
- [Documentação do Spring Security(JWT)](https://docs.spring.io/spring-security/reference/index.html)
- [Swagger](https://swagger.io/docs/)
- [Documentação do Angular](https://angular.dev/)


## Contribuição
Se você deseja contribuir para o desenvolvimento deste projeto, fique à vontade para abrir uma pull request ou um issue.

## Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
