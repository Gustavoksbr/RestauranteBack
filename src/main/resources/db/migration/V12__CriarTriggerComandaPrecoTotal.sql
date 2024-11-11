CREATE TRIGGER SetPrecoTotal
AFTER INSERT ON ItemComanda
FOR EACH ROW
BEGIN
    UPDATE Comanda
    SET total = total + NEW.preco_unitario
    WHERE id = NEW.id_comanda;
END;
