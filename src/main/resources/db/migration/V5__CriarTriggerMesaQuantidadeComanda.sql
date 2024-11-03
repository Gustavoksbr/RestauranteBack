CREATE TRIGGER IncrementaQuantidadeComandas
AFTER INSERT ON Comanda
FOR EACH ROW
BEGIN
    UPDATE Mesa
    SET quantidade_comanda = quantidade_comanda + 1
    WHERE id = NEW.id_mesa;
END;

CREATE TRIGGER DecrementaQuantidadeComandasAoDeletar
AFTER DELETE ON Comanda
FOR EACH ROW
BEGIN
    UPDATE Mesa
    SET quantidade_comanda = quantidade_comanda - 1
    WHERE id = OLD.id_mesa;
END;

CREATE TRIGGER DecrementaQuantidadeComandasAoPagar
AFTER UPDATE ON Comanda
FOR EACH ROW
BEGIN
    IF OLD.pago = FALSE AND NEW.pago = TRUE THEN
        UPDATE Mesa
        SET quantidade_comanda = quantidade_comanda - 1
        WHERE id = NEW.id_mesa;
    END IF;
END;
