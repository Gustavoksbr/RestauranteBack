CREATE TRIGGER AtualizaNomeProduto
BEFORE INSERT ON ItemComanda
FOR EACH ROW
BEGIN
    DECLARE produto_nome VARCHAR(255);
    SELECT nome INTO produto_nome FROM Produto WHERE id = NEW.id_produto;
    SET NEW.nome_produto = produto_nome;
END;
