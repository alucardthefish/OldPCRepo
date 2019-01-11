<?php
	session_start();

	if($_SESSION['login']!="ok")	//si la variable de sesion login es diferente a "ok"
	{
		header("Location: login.php"); 	//redirgimos al login.php
	}
	else	//si la variable es igual a "ok" mostramos el contenido..
	{
?>

<html>
	<head>
		<title>aqui el contenido para usuarios registrados HOLA <?php echo $_SESSION['usuario']; ?></title>
	</head>
	
	<body bgcolor="#000000" text="#FFFFFF">
		<p align="right">Bienvenido <b><?php echo $_SESSION['usuario']; ?></b> | <a href="login.php?action=logout">Cerrar Sesion</a></p><hr><br>
		<center>
		<h1>Aqui iria el contenido para los usuarios registrados</h1>
		blablabla xD<br>Visita <a href="http://zone-hack.net" target="_blank">http://zone-hack.net</a>
	</body>
</html>
<?php
}
?> 