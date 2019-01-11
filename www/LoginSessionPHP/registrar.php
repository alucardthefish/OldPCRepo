<?php


if($_POST['action']=="enviar")
{ //si mandamos el formulario...
	if($_POST['usuario']=="" || $_POST['email']=="" || $_POST['pregunta']=="" || $_POST['r_secreta']=="" || $_POST['pass']=="" || $_POST['pass2']==""){ //si los campos estan vacios
		echo"<script>alert('debe rellerar todos los campos')</script>"; //mostramos error

    }
	else
	{ //sino estan vacios...
		if($_POST['pass']!=$_POST['pass2'])
		{ //si los password no coinciden
			echo "<script>alert('los password no coinciden!')</script>"; //mostramos mensaje de error
        }
		else
		{ //si coinciden..
			if(!file_exists("./users/".$_POST['usuario']))
			{ //si no existe el usuario..
            
				mkdir("users/".$_POST['usuario'], 0777) or die("no se pudo crear el usuario "); //creamos una carpeta
				$fp=fopen("users/".$_POST['usuario']."/datos.php","w+") or die("no se pudo crear el usuarioo"); //creamos el archivo datos.php donde se guardara su user y su pass
				fputs($fp,"<?php \n");
				fputs($fp,"\$email=\"".strip_tags($_POST['email'])."\";\n"); //eliminamos etiquetas html, y guardamos el correo
				fputs($fp,"\$pregunta=\"".strip_tags($_POST['pregunta'])."\";\n"); //eliminamos etiquetas html, y guardamos la pregunta para cambiar pass
				fputs($fp,"\$r_secreta=\"".strip_tags($_POST['r_secreta'])."\";\n"); //eliminamos etiquetas html, y guardamos el user
				fputs($fp,"\$user=\"".strip_tags($_POST['usuario'])."\";\n"); //eliminamos etiquetas html, y guardamos el user
				fputs($fp,"\$pass=\"".strip_tags($_POST['pass'])."\";\n"); //eliminamos etiquetas html, encriptamos con nuestro propio sistema de encriptamiento y guardamos el pass
				fputs($fp,"?>\n");
				echo "<script>alert('registro completo!')</script>"; //mostramos que todo salio bien
				echo "<meta http-equiv=refresh content=0;url=login.php>";
			}
			else
			{ //si ya existe el usuario
				echo "<script>alert('ya existe el usuario ".$_POST['usuario']."')</script>"; //mostramos que ya existe el usuario
			}
        }
    }
}



?>
<html>
	<head>
		<title>Registro de usuarios sin base de datos</title>
	</head>
	
	<body bgcolor="#000000" text="#FFFFFF">
		<br>
		<?php
			if($_SESSION['login']!="ok")	//si la variable de sesion es diferente a ok entonces mostraremos el formulario de registro
			{
		?>
		<center>
		<h1>Registro de usuarios sin base de datos</h1>
		<table border="0" align="center">
			<form method="post" action="registrar.php">
				<tr>
					<td>usuario: </td>
					<td><input type="text" name="usuario"></td>
				</tr>
				<tr>
					<td>E-mail: </td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>password: </td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td>repita el pass: </td>
					<td><input type="password" name="pass2"></td>
				</tr>
				<tr>
					<td>pregunta seguridad: (<a href="javascript:alert('se te preguntara esta pregunta y su respuesta en caso de que olvides tu password')">?</a>)</td>
					<td>
						<select name="pregunta">
							<option value="">selecciona una pregunta</option>
							<option value="mascota favorita">mascota favorita</option>
							<option value="mejor amigo">mejor amigo</option>
							<option value="pelicula favorita">pelicula favorita</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>respuesta secreta: </td>
					<td><input type="text" name="r_secreta"></td>
				</tr>
				<input type="hidden" name="action" value="enviar">
				<tr>
					<td colspan="2">
						<center>
							<input type="submit" value="registrarse!">
						</center>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<center>
							<a href="login.php">Iniciar Sesion</a>
						</center>
					</td>
				</tr>
			</form>
		</table>
		<?php
			}
			else	//si la varieble de sesion es igual a ok entonces redirigimos al index
			{
				header("Location: index.php");
			}
		?>
	</body>
</html>