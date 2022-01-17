create table usuario(
	id int not null auto_increment,
    username varchar (60) not null,
    senha varchar (255) not null,
    perfil varchar(20) not null,

        primary key (id)
    );
