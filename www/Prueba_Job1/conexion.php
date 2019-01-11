<?php
function conectar()
{
	mysql_connect("localhost", "root", "sergiop");// conectarse al servidor de bases de datos
	mysql_select_db("prueba_job1");       // seectcionar la bases de datos
}

function desconectar()
{
	mysql_close(); // desconectarse de la base de datos
}
?>