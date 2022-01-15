create table ocorrencia_encomenda (
	id bigint not null auto_increment,
    encomenda_id int not null,
    descricao text not null,
    data_registro datetime not null,

    primary key (id)
);

alter table ocorrencia_encomenda add constraint fk_ocorrencia_encomenda_encomenda
foreign key (encomenda_id) references encomenda (id);

