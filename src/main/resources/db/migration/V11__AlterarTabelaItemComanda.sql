ALTER TABLE `itemcomanda` DROP FOREIGN KEY IF EXISTS `fk_id_comanda`;

ALTER TABLE `itemcomanda`
ADD CONSTRAINT `fk_id_comanda`
FOREIGN KEY (`id_comanda`) REFERENCES `comanda`(`id`) ON DELETE CASCADE;