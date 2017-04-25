create table funcionario(
id_funcionario serial primary key,
nome_funcionario varchar(255),
cargo varchar(255),
funcao varchar(255),
usuario varchar(255),
senha varchar(255)
);

create table chamado(
id_numeroChamado serial primary key,
cliente varchar(255),
desc_chamado text,
notificacao text,
tipo_incidente varchar(255),
id_funcionario integer references funcionario(id_funcionario) 
);

create table setores(
id_setor serial primary key,
nome_setor varchar(255)
);

create table setor_funcionario(
id_setor_funcionario serial primary key,
id_setor integer references setores(id_setor),
id_funcionario integer references funcionario(id_funcionario)
);

drop table funcionario;
select * from funcionario;

