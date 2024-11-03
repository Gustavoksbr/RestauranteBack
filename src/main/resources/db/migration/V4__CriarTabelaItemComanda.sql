CREATE TABLE ItemComanda (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    id_comanda INT NOT NULL,
    id_produto INT NOT NULL,
    nome_produto VARCHAR(255) NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) DEFAULT 0.00,
    subtotal DECIMAL(10, 2) AS (quantidade * preco_unitario) STORED,
    FOREIGN KEY (id_comanda) REFERENCES Comanda(id),
    FOREIGN KEY (id_produto) REFERENCES Produto(id)
);
