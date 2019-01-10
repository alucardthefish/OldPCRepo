/* REFERENTE A CONSULTAS PARA CREAR LISTAS DE REPRODUCCION */
INSERT INTO lista_reproduccion (nombre_lista, id_cliente) VALUES ('Mi reggaes', 'sergionick');

/*La consulta de abajo me permite cojer todos los nombres de las listas de reproduccion de un cliente especificado*/

select id_lista_reproduccion, nombre_lista
from lista_reproduccion
where id_cliente = 'sergionick';

/*La sentencia de abajo inserta en una lista de reproduccion especificada una cancion*/
INSERT INTO canciones_en_lista (id_lista, id_cancion) VALUES ('1', '8');


/*La consulta de abajo me permite cojer todas las canciones de una lista de reproduccion de un cliente especificado por id de la lista de reproduccion si es que quiero recoger todos los campos*/
select * from canciones_en_lista join canciones_usuario
where canciones_en_lista.id_cancion = canciones_usuario.id_cancion_usuario and canciones_en_lista.id_lista = 2;

/*La consulta de abajo me permite seleccionar el titulo y la ubicacion del archivo de todas las canciones de una lista de reproduccion de un cliente especificado por id de la lista de reproduccion. Ideal para la parte de reproducir las canciones*/
select canciones_usuario.titulo, canciones_usuario.ubicacion from canciones_en_lista join canciones_usuario
where canciones_en_lista.id_cancion = canciones_usuario.id_cancion_usuario and canciones_en_lista.id_lista = 2;


/* REFERENTE A CONSULTAS PARA COMPARTIR CANCIONES */

/*Borrando canciones por id*/
delete from canciones_compartidas where id_cancion_compartida = 6;

/* Seleccionando las canciones que han sido compartidas por un usuario al usuario logueado */
SELECT canciones_compartidas.id_cancion_compartida, canciones_usuario.titulo, canciones_usuario.artista, canciones_usuario.album, canciones_usuario.genero, canciones_usuario.nick
FROM canciones_compartidas, canciones_usuario
WHERE canciones_compartidas.id_cancion_user = canciones_usuario.id_cancion_usuario and canciones_compartidas.cliente_key = 'fannynick' and
canciones_usuario.nick = 'sergionick';


/* dsfdf*/
insert into canciones_en_lista (id_lista, id_cancion) VALUES ('3', '4');