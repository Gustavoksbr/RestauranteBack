# RestauranteBack




## Descrição

Este é o back end de um projeto para gestão de restaurantes

É uma Api Rest com o principal objetivo de gerenciar as comandas e seu itens relacionados, utilizando métodos http e consultando num banco de dados

Visualize o front end [aqui](https://github.com/Gustavoksbr/RestauranteFront)

O projeto completo (back, front e ux design) foi desenvolvido por uma equipe no Azure DevOps, utilizando a metodologia ágil Scrum

## Instalando o projeto

### Dependências
Instale:
-Java 17
-Mysql

### Passo a passo para rodar a API

1. Clone o repositório para a sua máquina local:
    ```bash
    git clone https://github.com/Gustavoksbr/RestauranteBack.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd RestauranteBack
    ```

3. Execute o comando para construir o projeto com Gradle:
    ```bash
    ./gradlew build
    ```

4. No Mysql, crie um banco de dados chamado restaurante *

5. Execute a aplicação:
    ```bash
    ./gradlew bootRun
    ```

6. Acesse a API através do endereço* :
    ```
    http://localhost:8080
    ```
obs: vc pode alterar o nome do banco de dados e as portas do spring de acordo com a sua preferência em src/main/resources/aplication.properties

## Modelagem

![Modelagem do Banco de Dados](docs/modelagem.png)


## Casos de Uso

### 1. Listagem de Mesas

- GET /mesa
- Sem json request
- **Exemplo de Json Response:**
    ```json
    [
        {"id": 1, "quantidadeComandas": 3},
        {"id": 2, "quantidadeComandas": 0},
        {"id": 3, "quantidadeComandas": 1},
        {"id": 4, "quantidadeComandas": 2}
    ]
    ```
### 2. Listagem de Produtos


- GET /produto
- Sem json request
- **Exemplo de Json Response:**
    ```json
    [
        {"nome": "bombom", "categoria": "sobremesa", "precoUnitario": 3},
        {"nome": "lasanha", "categoria": "prato", "precoUnitario": 20}
    ]
    ```
  
### 3. Listagem de Comandas

- GET mesa/{id}/comanda
- Sem json request
- **Exemplo de Json Response:**
    ```json
    [
        {"id": 2, "total": 5.50},
        {"id": 5, "total": 90.00},
        {"id": 7, "total": 38.00}
    ]
    ```

### 4. Listagem de Itens da Comanda


- GET comanda/{id}/itemcomanda
- Sem json request
- **Exemplo de Json Response:**
    ```json
    [
        {"nomeProduto": "bombom", "precoUnitario": 3, "quantidade": 4, "precoTotal": 12},
        {"nomeProduto": "lasanha", "precoUnitario": 20, "quantidade": 1, "precoTotal": 20}
    ]
    ```


### 5. Criar Comanda

-  `POST /mesa/{id}/comanda`

### 6. Criar Item na Comanda

- `POST /comanda/{id}/itemcomanda`
- **Exemplo de Json Request:**
    ```json
    [
        {"nomeProduto": "bombom", "quantidade": 4},
        {"nomeProduto": "lasanha", "quantidade": 1}
    ]
    ```
- Sem json response

### 7. Apagar Item da Comanda

- `DELETE /itemcomanda/{idcomanda}/{nomeproduto}`

### 8. Apagar Comanda da Mesa

- `DELETE /comanda/{id}`

### 9. Pagar Comanda

- `PATCH /comanda/{id}`

## Detalhes Técnicos

### Arquitetura

- Utilizada arquitetura hexagonal
- Dividido entre a camada de domínio (models, casos de uso e portas) e a camada da aplicação (controllers e persistencia)
- Os métodos dos services refletem os métodos dos controllers. Já os métodos dos repositories refletem a sua respectiva entidade
- Justificativa: prepara o projeto para possíveis mudanças de tecnologias e adicões de funcionalidades. Por exemplo, possível autenticação de usuários e serviço de envio de emails no futuro

### Ordem dos processos de cada caso de uso
- Controller -> ServicePort -> ServiceImpl -> RepositoryPort -> RepositoryImpl -> JpaRepository

### Dependências específicas

- Jpa para persistência
- Flyway para migrations
- Lombok para redução de boilerplate
- Spring Validation para validação de body requests
