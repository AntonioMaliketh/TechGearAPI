create table hardware(
    id bigint not null auto_increment,
    category varchar (100) not null,
    product varchar (100) not null,
    brand varchar (100) not null,
    quantity int (20) not null,

    primary key (id)
);