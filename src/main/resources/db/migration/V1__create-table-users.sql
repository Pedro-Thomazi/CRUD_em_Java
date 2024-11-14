create table users(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    phone varchar(20) not null unique,
    gender varchar(6) not null,
    age int(3) not null,

    primary key(id)
);