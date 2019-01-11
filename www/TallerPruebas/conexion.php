<?php

function conectar()
{
	mysql_connect("mysql", "jreyse", "jreyse");// conectarse al servidor de bases de datos
	mysql_select_db("jreyse");       // seectcionar la bases de datos
}

function desconectar()
{
	mysql_close(); // desconectarse de la base de datos
}

?>