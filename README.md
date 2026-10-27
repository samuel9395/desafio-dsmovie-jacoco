# DSMovie — API de Filmes e Avaliações

API REST desenvolvida com Java e Spring Boot para gerenciamento de filmes e avaliações de usuários. O projeto contempla operações relacionadas aos filmes, registro de notas, cálculo de médias de avaliação e recursos de autenticação e autorização.

O projeto foi desenvolvido como parte de um desafio de desenvolvimento backend, com foco na construção de APIs REST, persistência de dados, segurança e testes automatizados.

## 📌 Funcionalidades

- **Gerenciamento de filmes:** consulta e operações de gerenciamento dos filmes disponíveis na aplicação.
- **Avaliações de usuários:** registro de notas para filmes.
- **Cálculo de avaliações:** atualização das médias e da quantidade de votos dos filmes.
- **Persistência de dados:** mapeamento das entidades e operações de acesso ao banco de dados utilizando JPA.
- **Segurança:** configuração de autenticação e autorização com Spring Security e recursos relacionados a OAuth 2.0 e JWT.
- **Documentação da API:** especificação OpenAPI para consulta dos endpoints.
- **Testes automatizados:** estrutura de testes para verificar o comportamento da aplicação.

## 🛠️ Tecnologias utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 17 | Linguagem de programação |
| Spring Boot | Configuração e execução da aplicação |
| Spring Web MVC | Desenvolvimento dos endpoints REST |
| Spring Data JPA | Persistência e acesso a dados |
| Hibernate | Mapeamento objeto-relacional |
| Spring Security | Segurança e controle de acesso |
| OAuth 2.0 Authorization Server | Recursos para autorização e emissão de tokens |
| OAuth 2.0 Resource Server | Proteção de recursos da API |
| JWT | Representação de tokens de acesso |
| H2 Database | Banco de dados relacional em memória |
| Spring Boot Validation | Validação de dados de entrada |
| Springdoc OpenAPI | Geração da especificação da API |
| Maven | Gerenciamento de dependências e build |
| JUnit 5 | Testes automatizados |
| Mockito | Simulação de dependências durante os testes |

## 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- Java Development Kit (JDK) 17 ou superior.
- Git, para clonar o repositório.

O projeto inclui o Maven Wrapper (`mvnw`), portanto não é necessário instalar o Maven separadamente.

## 🚀 Como executar

### 1. Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

Entre no diretório do projeto:

```bash
cd desafio-dsmovie-jacoco
```

Substitua `<URL_DO_REPOSITORIO>` pela URL do repositório Git.

### 2. Executar a aplicação

No Linux ou macOS:

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

No Windows, utilizando o Prompt de Comando:

```bat
mvnw.cmd spring-boot:run
```

O Spring Boot iniciará a aplicação conforme as configurações definidas no projeto.

> **Observação:** a porta da aplicação e eventuais configurações adicionais dependem dos arquivos de configuração presentes no projeto.

## 🧪 Executando os testes

Para executar os testes automatizados:

```bash
./mvnw test
```

Para executar os testes e gerar o pacote da aplicação:

```bash
./mvnw clean verify
```

O Maven Wrapper utiliza a versão do Maven configurada no projeto. O comando `verify` executa as etapas anteriores do ciclo de build e as verificações configuradas, incluindo a execução dos testes.

## 🗄️ Banco de dados

O projeto utiliza o **H2 Database**, um banco de dados relacional que pode operar em memória, dispensando a instalação de um servidor de banco de dados separado para esse cenário.

As configurações de conexão e inicialização estão nos arquivos de configuração da aplicação. O projeto também possui um arquivo `import.sql`, utilizado para a inicialização de dados conforme a configuração do Hibernate.

## 🔐 Segurança

A aplicação utiliza Spring Security e componentes relacionados ao OAuth 2.0 para implementar recursos de segurança.

A estrutura inclui configurações relacionadas ao Authorization Server, ao Resource Server e ao uso de JWT para autenticação e autorização.

As regras de acesso, os fluxos de autenticação e os endpoints protegidos devem ser consultados na implementação e na documentação da API.

## 📖 Documentação da API

A especificação OpenAPI está disponível no repositório:

[`open-api/openAPI.json`](open-api/openAPI.json)

O arquivo pode ser utilizado para visualizar os endpoints em ferramentas compatíveis com OpenAPI, como o Swagger Editor, e para importar a documentação em plataformas como o ReadMe.

A interface interativa do Swagger UI depende de sua configuração na aplicação.

## 📬 Testando com Postman

O projeto contém uma coleção e um ambiente do Postman no diretório `postman/`:

- `Desafio DSMovie Jacoco.postman_collection.json`
- `DSMovie.postman_environment.json`

Importe os dois arquivos no Postman para consultar as requisições disponíveis e configurar o ambiente de execução.

## 📁 Estrutura do projeto

```text
desafio-dsmovie-jacoco/
├── docs/                       # Documentação complementar
├── open-api/
│   └── openAPI.json            # Especificação OpenAPI
├── postman/
│   ├── Desafio DSMovie Jacoco.postman_collection.json
│   └── DSMovie.postman_environment.json
├── src/
│   ├── main/
│   │   ├── java/com/devsuperior/dsmovie/
│   │   │   ├── config/         # Configurações da aplicação
│   │   │   ├── controllers/    # Endpoints REST
│   │   │   ├── dto/            # Objetos de transferência de dados
│   │   │   ├── entities/       # Entidades persistidas
│   │   │   ├── projections/    # Projeções de dados
│   │   │   ├── repositories/   # Acesso a dados
│   │   │   ├── services/       # Regras de negócio
│   │   │   └── utils/          # Classes utilitárias
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── application-test.properties
│   │       └── import.sql
│   └── test/
│       └── java/com/devsuperior/dsmovie/
│           ├── services/
│           └── tests/
├── mvnw                        # Maven Wrapper para Linux/macOS
├── mvnw.cmd                    # Maven Wrapper para Windows
├── pom.xml                     # Dependências e build
└── README.md
```

## 🧱 Organização da aplicação

O projeto utiliza uma organização em camadas para separar as responsabilidades:

- **Controllers:** recebem as requisições HTTP e disponibilizam os endpoints da API.
- **DTOs:** definem estruturas para transferência de dados entre a API e seus consumidores.
- **Entities:** representam os dados persistidos no banco de dados.
- **Repositories:** abstraem o acesso e as operações de persistência.
- **Services:** concentram as regras de negócio e a coordenação das operações.
- **Projections:** permitem representar conjuntos específicos de dados retornados pelas consultas.
- **Config:** reúne as configurações necessárias para o funcionamento da aplicação, incluindo os recursos de segurança.

Essa separação facilita a manutenção, a organização do código e a realização de testes.

---

Desenvolvido como projeto de estudo em desenvolvimento backend com Java e Spring Boot.