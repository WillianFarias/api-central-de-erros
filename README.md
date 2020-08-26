# Central de erros (Api Rest)

Api Rest desenvolvida como projeto final do Acelera Dev Java da Codenation. 

## Instalação

Projeto desenvolvido para ser executado utilizando maven, necessária a instalação deste.

> Instalando o Maven: [https://maven.apache.org/install.html](https://maven.apache.org/install.html).

## Tecnologias utilizadas

- [Java](https://www.oracle.com/technetwork/java/javase/downloads/index.html) ```1.8```
- [Spring Boot](https://spring.io/projects/spring-boot) ```2.3.3.RELEASE```
- [Maven](https://maven.apache.org/) ```3.8.1```
- [H2 Database Engine](https://www.h2database.com/html/main.html) ```2.1.4.200``` 
- [Swagger](https://swagger.io/) ```2.9.2```

## Uso

Clone
```bash
$ git clone https://github.com/WillianFarias/api-central-de-erros.git
```

Compilando e Empacotando
```bash
$ cd api-central-de-erros
$ mvn compile
$ mvn package
```
Executando 
```bash
$ mvn spring-boot:run
```

##Documentação
Após a execução é possível acessar a documentação dos metodos http da aplicação por meio do seguinte url:
```bash
$ http://localhost:8080/swagger-ui.html#/
```
