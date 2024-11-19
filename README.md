# RestauranteBack




## Descrição 

Este é o back end de um projeto para a gestão de restaurante

É uma Api Rest com o principal objetivo de gerenciar as comandas e seu itens relacionados, utilizando métodos http e salvando em um banco de dados

Visualize o front end [aqui](https://github.com/Gustavoksbr/RestauranteFront)




## Instalando o projeto

### Dependências
As tecnologias utilizadas foram:
- Java 17
- Spring Boot
- Gradle
- MySQL

Instale-as caso não as tenha


### Passo a passo para rodar na sua máquina

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

## Banco de Dados

```sql
CREATE TABLE mesa (
    id int(11) NOT NULL,
    quantidade_comanda int(11) DEFAULT 0
);

CREATE TABLE produto (
    id int(11) NOT NULL,
    nome varchar(255) NOT NULL,
    preco decimal(10,2) NOT NULL,
    categoria enum('Bebida','Prato','Sobremesa') NOT NULL
);

CREATE TABLE comanda ( 
    id int(11) NOT NULL,
    id_mesa int(11) NOT NULL,
    pago tinyint(1) DEFAULT 0,
    total decimal(10,2) DEFAULT 0.00
);

CREATE TABLE itemcomanda (
    id_comanda int(11) NOT NULL,
    id_produto int(11) NOT NULL,
    nome_produto varchar(255) NOT NULL,
    quantidade int(11) NOT NULL,
    preco_unitario decimal(10,2) DEFAULT 0.00,
    subtotal decimal(10,2) GENERATED ALWAYS AS (quantidade * preco_unitario) STORED
);
```

## Casos de Uso

### 1. Listagem de Mesas

- **Ação:** Usuário entra na tela 1
- **Requisição:** GET /mesa
- **Json Response:**
    ```json
    [
        {"id": 1, "quantidadeComandas": 3},
        {"id": 2, "quantidadeComandas": 0},
        {"id": 3, "quantidadeComandas": 1},
        {"id": 4, "quantidadeComandas": 2}
    ]
    ```

### 2. Listagem de Comandas

- **Ação:** Na tela 1, usuário clica em uma mesa, entrando na tela 2
- **Requisição:** GET mesa/{id}/comanda
- **Json Response:**
    ```json
    [
        {"id": 2, "total": 5.50},
        {"id": 5, "total": 90.00},
        {"id": 7, "total": 38.00}
    ]
    ```

### 3. Listagem de Itens da Comanda

- **Ação:** Na tela 2, usuário seleciona uma comanda
- **Requisição:** GET comanda/{id}/itemcomanda
- **Json Response:**
    ```json
    [
        {"nomeProduto": "bombom", "precoUnitario": 3, "quantidade": 4, "precoTotal": 12},
        {"nomeProduto": "lasanha", "precoUnitario": 20, "quantidade": 1, "precoTotal": 20}
    ]
    ```

### 4. Listagem de Produtos

- **Ação:** Na tela 2, o usuário clica em 'adicionar item', entrando na tela 3
- **Requisição:** GET /produto
- **Json Response:**
    ```json
    [
        {"nome": "bombom", "categoria": "sobremesa", "precoUnitario": 3},
        {"nome": "lasanha", "categoria": "prato", "precoTotal": 20}
    ]
    ```

### 5. Criar Item na Comanda

- **Ação:** Na tela 3, o usuário seleciona o produto que quer adicionar na comanda e escolhe a quantidade
- **Requisição:** POST /comanda/{id}/itemcomanda
- **Json Request:**
    ```json
    [
        {"nomeProduto": "bombom", "quantidade": 4},
        {"nomeProduto": "lasanha", "quantidade": 1}
    ]
    ```

### 6. Apagar Item da Comanda

- **Ação:** Na tela 2, o usuário seleciona o produto que quer remover da comanda
- **Requisição:** DELETE /itemcomanda/idcomanda/nomeproduto

### 7. Apagar Comanda da Mesa

- **Ação:** Na tela 2, o usuário escolhe uma comanda para deletar
- **Requisição:** DELETE /comanda/id

### 8. Pagar Comanda

- **Ação:** Na tela 2, o usuário escolhe uma comanda para ser paga
- **Requisição:** PATCH /comanda/id

### 9. Criar Comanda

- **Ação:** Na tela 2, usuário clica em "adicionar comanda"
- **Requisição:** POST /mesa/{id}/comanda









































