create database mercado;

use mercado;

create table usuarios (
	id int auto_increment primary key,
    nome varchar(100) not null,
    cpf varchar(100) unique not null,
    senha varchar(100),
    adm bool default false
);

create table produtos (
	id int auto_increment primary key,
	nome varchar(100) not null,
    descricao varchar(150),
    quantidade int default 0,
    preco decimal(10, 2) not null
);

create table pedidos (
	id int auto_increment primary key,
    usuario_id int not null,
    foreign key (usuario_id) references usuarios(id)
);

create table itens_pedido (
	id int auto_increment primary key,
    pedido_id int not null,
    produto_id int not null,
    quantidade int not null,
    preco_unitario decimal(10, 2) not null,
    foreign key (pedido_id) references pedidos(id),
    foreign key (produto_id) references produtos(id)
);