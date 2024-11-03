CREATE TRIGGER SetPrecoUnitario
BEFORE INSERT ON ItemComanda
FOR EACH ROW
BEGIN
    DECLARE preco_produto DECIMAL(10, 2);
    SELECT preco INTO preco_produto
    FROM Produto
    WHERE id = NEW.id_produto;

    SET NEW.preco_unitario = preco_produto;
END;
