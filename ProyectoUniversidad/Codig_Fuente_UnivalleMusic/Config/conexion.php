<?php

function conectar()
{
	pg_connect("host=localhost port=5432 dbname=Univalle_Music user=sergio password=thefish")or die('No pudo conectarse: ' . pg_last_error());
}

function desconectar()
{
	pg_close(); // desconectarse de la base de datos
}
?>