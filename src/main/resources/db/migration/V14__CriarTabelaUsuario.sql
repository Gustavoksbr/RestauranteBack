create table users(
  id int primary key auto_increment,
  username varchar(255) unique not null,
  nome varchar(255),
  password varchar(255) not null,
  email varchar(255) not null,
  ativo boolean not null,
  dois_fatores boolean not null
)