create table unidade(
	id int not null auto_increment,
    proprietario varchar (60) not null,
    contato varchar (25) not null,
    email varchar(120) not null,
    apartamento int not null,
    torre varchar (60) not null,


    primary key (id)
);
create table encomenda (
	id int not null auto_increment,
    unidade_id int not null,
    status_encomenda varchar(20) not null,
    entrada_encomenda datetime not null,
    baixa_encomenda datetime,
    nota_fiscal varchar(40) not null,
    destinatario_nome varchar(40) not null,
    destinatario_rg varchar(20) not null,

    primary key (id)
);
alter table encomenda add constraint fk_encomenda_unidade
foreign key (unidade_id) references unidade (id);
