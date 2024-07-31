create table if not exists user(
	id int primary key auto_increment ,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    email varchar(100) not null,
    hashed_password varchar(500) not null,
    salt varchar(50) not null
);