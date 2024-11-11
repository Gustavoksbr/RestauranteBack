DROP TRIGGER IF EXISTS SetPrecoTotal;

DELIMITER //

CREATE TRIGGER SetPrecoTotal
AFTER INSERT ON ItemComanda
FOR EACH ROW
BEGIN
    UPDATE Comanda
    SET total = total + NEW.subtotal
    WHERE id = NEW.id_comanda;
END //

DELIMITER ;

DELIMITER //


CREATE TRIGGER SetPrecoTotalAfterDelete
AFTER DELETE ON ItemComanda
FOR EACH ROW
BEGIN
    UPDATE Comanda
    SET total = total - OLD.subtotal
    WHERE id = OLD.id_comanda;
END
//

DELIMITER ;