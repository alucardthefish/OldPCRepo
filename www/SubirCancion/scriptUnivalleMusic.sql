create table usuario( email varchar(20) not null primary key, nombre varchar(20), apellido varchar(20), password varchar(20));

create table cliente( nick varchar(20) not null primary key, email varchar(20) not null references usuario(email));

create table administrador( nick varchar(20) not null primary key, email varchar(20) not null references usuario(email));

create table cancion( titulo varchar(20) not null, artista varchar(20) not null, album varchar(20), genero varchar(20), megusta boolean default false, primary key(titulo, artista));

create table colecciona( nick varchar(20) not null references cliente(nick), titulo varchar(20) not null references cancion(titulo), artista varchar(20) not null references cancion(artista), primary key(nick, titulo, artista));

create table cancion_venta( nick varchar(20) not null references administrador(nick), titulo varchar(20) not null references cancion(titulo), artista varchar(20) not null references cancion(artista), precio double, recomendado boolean, primary key(nick, titulo, artista));

insert into usuario values('admingo@gmail.com','Administrador','Admin','1234');
insert into usuario values('clientengo@gmail.com','Cliente','tengo','1234');
insert into cliente values('Cliente','clientengo@gmail.com');
insert into administrador values('Admin','admingo@gmail.com');