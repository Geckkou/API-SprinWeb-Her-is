# Demo sobre live coding da digital innovation one - spring webflux - criando seu gerenciador de herois

## Empilhar usar

- Java8
- Spring Webflux
- Dados de primavera
- dynamodb
- Junit
- sl4j
- reator

### Slides de palestra: https://speakerdeck.com/kamilahsantos/live-coding-dio-api-de-herois-com-spring-webflux

### Palestra garavda: https://www.youtube.com/watch?v=1VllPZYn6RI&t=3257s

### Executar dínamo:

na pasta em que o jar está baixado: java -Djava.library.path =. / DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

para listar como tabelas padrões: aws dynamodb list-tables --endpoint-url [http: // localhost: 8000](http://localhost:8000/)

documentacao gerada pela aplicação: swagger: [http: // localhost: 8080 / swagger-ui-heroes-reactive-api.html](http://localhost:8080/swagger-ui-heroes-reactive-api.html)