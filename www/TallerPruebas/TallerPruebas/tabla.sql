create table usuarios(
	id_usuario varchar(8) not null primary key,
	nombre varchar(25),
	apellidos varchar(50),
	telefono varchar(8),
	barrio varchar(40)
);

create table estaciones(
	id_estacion varchar(7) not null primary key,
	nombre varchar(35),
	direccion varchar(90),
	barrio varchar(30)
);

create table registro_viajes(
id_registro integer not null auto_increment primary key,
id_pasajero varchar(8) not null,
fecha date,
hora_entrada varchar (10),
minuto_entrada varchar (10),
nombre_estacion_origen varchar(20),
nombre_estacion_destino varchar (20),
foreign key (id_pasajero) references usuarios(id_usuario),
foreign key (nombre_estacion_origen) references estaciones(id_estacion),
foreign key (nombre_estacion_destino) references estaciones(id_estacion)
);

insert into usuarios (id_usuario, nombre, apellidos, telefono, barrio) values 
('user001', 'Alberto', 'Calderon', '3425676', 'Belen'),
('user002', 'Bruno', 'Torres', '3325596', 'Alamos'),
('user003', 'Rigoberto', 'Zapata', '5425378', 'Belalcazar'),
('user004', 'Maria', 'Rosales', '3425676', 'Golondrinas'),
('user005', 'Adalgiza', 'Buitrago', '3484676', 'Caney'),
('user006', 'Mario', 'Vives', '3420976', 'Libertadores'),
('user007', 'Ronald', 'Perez', '6755676', 'Colon'),
('user008', 'Angelica', 'Tabares', '3442486', 'Guadales'),
('user009', 'Mariana', 'Daza', '3935676', 'Melendez'),
('user010', 'Santiago', 'Norrea', '3478436', 'El trebol');

insert into estaciones (id_estacion, nombre, direccion, barrio) values
('sta001', 'Chiminangos', 'Cra 1 con Cll 62', 'Chiminangos'),
('sta002', 'Flora Industrial', 'Cra 1 con Cll 56', 'La flora'),
('sta003', 'Chapinero', 'Cra 15 con Cll 48', 'Chapinero'),
('sta004', 'Belalcazar', 'Cra 15 con Cll 21', 'Belalcazar'),
('sta005', 'Plaza Caycedo', 'Cll 13 con Cra 4', 'Obrero'),
('sta006', 'Centro', 'Cll 13 con Cra 8', 'Santa Rosa'),
('sta007', 'Santa Librada', 'Cll 5 con Cra 22', 'San Bosco'),
('sta008', 'Universidades', 'Cra 100 con Cll 16', 'Ciudad Jardin'),
('sta009', 'Vipasa', 'Av. 3N con Cll 44N', 'Vipasa'),
('sta010', 'Versalles', 'Av. Las Américas con Cll 21N', 'Versalles'),
('sta011', 'Nuevo Latir', 'Cra 28D con Cll 80', 'Nuevo Latir'),
('sta012', 'Villanueva', 'Tr. 25 con Cll 32', 'Villanueva');
























