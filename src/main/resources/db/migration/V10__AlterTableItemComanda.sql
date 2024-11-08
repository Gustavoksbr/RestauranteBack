ALTER TABLE ItemComanda
drop constraint if exists pk_itemcomanda,
drop column id,
add constraint pk_itemcomanda primary key (id_comanda, id_produto);