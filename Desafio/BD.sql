create table cadastro(
id serial primary key,
nome_novo_funcionario varchar(255),
cargo varchar(255),
funcao varchar(255),
usuario varchar(255),
senha varchar(255)
);

insert into login(usuario, senha)
values ('thiago', 'thiago99');
delete from login;
select * from login;

select * from cadastro;

insert into login(nome_novo_funcionario, cargo, funcao, usuario , senha) values ('a', 'b','c','d','e');