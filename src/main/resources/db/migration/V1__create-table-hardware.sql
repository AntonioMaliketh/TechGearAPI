create table hardware(
    id bigint not null auto_increment,
    tipo varchar (100) not null,
    produto varchar (100) not null,
    marca varchar (100) not null,
    quantidade varchar (100) not null,

    primary key (id)
);