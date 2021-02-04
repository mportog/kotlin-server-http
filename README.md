[![official JetBrains project](https://jb.gg/badges/official.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

## Kotlin server side !
# Criando uma API de requisições HTTP com Ktor

Este repositório corresponde ao resultado final do tutorial [Creating HTTP APIs with Ktor](https://play.kotlinlang.org/hands-on/Creating%20http%20apis%20with%20ktor/01_Introduction). contido no [site oficial do koltin](https://kotlinlang.org/)

### Objetivos
Criar uma aplicação que use Kotlin no código do servidor, sendo possivel usar desta API em Kotlin para registra, criar e deletar, pedidos e clientes.

#### Próximos passos 
(Para não comlpicar o exemplo)
- Foi usado in-memory storage (lista mutável de Customers), ao invés de um banco de dados, como deve ser feito nas aplicações reais. 
- Melhorar a confiabilidade da requisição, pois neste exemplo, a informação pode ser perder em casos de requisições muliplas no mesmo momento.

### Teste
Afins de teste, as chamadas devem ser feitas da seguinte forma:

Ao rodar a aplicação, consulta pode ser facilmente feita via [Postman](https://www.postman.com/downloads/), para isso basta:
- Adicionar ao Header das chamadas Content-Type : application/json
- Usar do endereço : http://127.0.0.1:8080/customer/{id} para uma requisição do tipo HHTP GET. Onde {id} corresponde ao Id do cliente a ser consultado e remover o /{id} caso queira consultar todos os clientes
- Usardo endereço : http://127.0.0.1:8080/customer para uma requisição do tipo HTTP POST. Onde o corpo da requisição seja um JSON da seguinte forma:
> <p>{</p>
> <p>"id": "1",</p>
> <p>"firstName": "Matheus",</p>
> <p>"lastName": "Porto",</p>
> <p>"email": "matheusporto@anymail.com"</p>
> <p>}</p>
