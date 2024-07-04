<<<<<<< HEAD
```markdown
# Projeto de Teste Automático com Selenium e JUnit

Este projeto é um exemplo de automação de testes usando Selenium WebDriver com JUnit em Java. O objetivo é testar uma aplicação web automatizando ações e verificando resultados esperados.

## Estrutura do Projeto

A estrutura do projeto está organizada da seguinte forma:

```
.
├── src
│   └── main
│       └── java
│           ├── base
│           │   └── BasePage.java
│           ├── config
│           │   └── config.properties
│           ├── org.example
│           ├── pages
│           │   ├── HomePage.java
│           │   └── SignUpPage.java
│           └── utils
│               ├── ElementUtil.java
│               ├── JavaScriptUtil.java
│               └── OptionsManager.java
│       └── resources
│           └── test_pdf.pdf
└── test
    └── java
        └── base
            ├── BaseTest.java
            └── tests
                └── SignUpTest.java
```

## Requisitos

- Java JDK 8 ou superior
- Maven
- Navegador Chrome
- ChromeDriver compatível com a versão do navegador

## Configuração

1. Clone o repositório:

   ```sh
   git clone https://github.com/joseivo01/SeleniumJavaJUnit.git
   ```

2. Navegue até o diretório do projeto:

   ```sh
   cd SeleniumJavaJUnit
   ```

3. Instale as dependências do projeto usando Maven:

   ```sh
   mvn install
   ```

4. Configure as propriedades do projeto no arquivo `config.properties` localizado em `src/main/java/config`:

   ```properties
   browser=chrome
   url=https://qavbox.github.io/demo/
   ```

## Estrutura dos Testes

### BasePage.java

Classe base para todas as páginas, contendo métodos comuns a todas elas.

### HomePage.java

Classe que representa a página inicial da aplicação, com métodos para interação com os elementos desta página.

### SignUpPage.java

Classe que representa a página de cadastro da aplicação, com métodos para interação com os elementos desta página.

### ElementUtil.java, JavaScriptUtil.java e OptionsManager.java

Classes utilitárias para facilitar a interação com elementos, execução de JavaScript e configuração de opções do navegador.

### BaseTest.java

Classe base para todos os testes, configurando o WebDriver e gerenciando a inicialização e finalização dos testes.

### SignUpTest.java

Classe que contém os testes específicos para a funcionalidade de cadastro, incluindo métodos de teste para acessar a página de cadastro, registrar um novo usuário e verificar o tutorial.

## Executando os Testes

Para executar os testes, utilize o seguinte comando Maven:

```sh
mvn test
```

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorar o projeto.

## Licença

Este projeto está licenciado sob os termos da licença MIT. Consulte o arquivo `LICENSE` para obter mais informações.

```

Este README fornece uma visão geral do projeto, requisitos, configuração, estrutura de arquivos, e como executar os testes. Sinta-se à vontade para modificar conforme necessário para se adequar ao seu projeto específico.
=======
# SeleniumJavaJUnit
>>>>>>> 614b6ac97a52bde8a19e609fd16333fa379c56fd
