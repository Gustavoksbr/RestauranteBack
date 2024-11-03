CREATE TABLE Produto (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(255) NOT NULL UNIQUE,
    preco DECIMAL(10, 2) NOT NULL,
    categoria ENUM('Bebida', 'Prato', 'Sobremesa') NOT NULL
);
