<?php
session_start();


if(@$_SESSION['login']=="ok"){ //si la variable de sesion login es igual a "ok"

    if($_GET['action']=="logout"){ //si el action obtenido de la ur es igual a logout destruimos las sessiones
        Session_destroy();
        header("Location: index.php");
        exit();    
    }else{ //sino es ninguna accion redirigimos al index

    header("Location: index.php");
    exit();
    }
    
}else{ //sino es igual a ok

if($_GET['action']=="remember"){ //si el action tomado del url es igual a remember 

    
    if($_POST['remember']=="enviar"){ //si enviamos el formulario de recordar pass
        if($_POST['usuario']=="" || $_POST['email']=="" || $_POST['pregunta']=="" || $_POST['r_secreta']==""){ //si los campos estan vacios..
            echo "<script>alert('debe rellenar todos los campos')</script>"; //mostramos mensaje de error
            echo "<meta http-equiv=refresh content=0;url=login.php?action=remember>"; //y redirigimos de nuevo al formulario
        }else{     //si los campos no estan vacios
            if(file_exists("./users/".$_POST['usuario'])){ //si existe el usuario
                include("./users/".$_POST['usuario']."/datos.php"); //incluimos los datos
                    if($email==$_POST['email']){ //si el email del login coincide con el del registro
                        if($pregunta==$_POST['pregunta'] && $r_secreta==$_POST['r_secreta']){ //si la pregunta de seguridad y el email coinciden con los del registro
                            $encabezados = "From: admin@dominio.comnReply-To: admin@dominio.comnContent-Type: text/html; charset=iso-8859-1";
                            $mensaje= "tu usuario es: ".$_POST['usuario']."<br><br>Tu password es: ".$pass;
                            if(mail($_POST['email'], "has solicitado tu password",$mensaje, $encabezados)){ //mandamos el email con los datos
                                echo "<script>alert('tu pass ha sido enviado a tu correo')</script>";
                            }else{ //sino se pudo mandar el email
                                echo "<script>alert('tu password es: ".$pass."')</script>"; //mostramos el password
                                echo "<meta http-equiv=refresh content=0;url=index.php>"; //redirigimos al index
                            }
                        }else{ //si la pregunta o respuesta secreta no coindicen con los del registro...
                            echo "<script>alert('la pregunta o respuesta secreta no coinciden con la pregunta o respuesta del registro')</script>"; //mostramos error
                            echo "<meta http-equiv=refresh content=0;url=login.php?action=remember>"; //redirigimos al formulario
                        }
                    }else{ //si el email no coindide con el del registro
                        echo"<script>alert('el email no coincide con el del registro')</script>"; //mostramos error
                        echo "<meta http-equiv=refresh content=0;url=login.php?action=remember>"; //redirigimos al formulario
                    }
        
            }else{ //si el usuario no existe..
                echo"<script>alert('el usuario no existe!')</script>"; //mostramos error
                echo "<meta http-equiv=refresh content=0;url=login.php?action=remember>"; //redirigimos al formulario
            }
        }
    }else{ //sino se ha enviado el formulario de recordar pass mostramos el formulario..
?>
<html>
	<head>
		<title>Remeber Password</title>
	</head>
	<body bgcolor="#000000" text="#FFFFFF">
		<center>
		<h1>recordar pass</h1>
		<table border="0" align="center">
			<form method="post" action="login.php?action=remember">
				<tr>
					<td>usuario: </td>
					<td><input type="text" name="usuario"></td>
				</tr>
				<tr>
					<td>E-mail: </td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>pregunta seguridad: (<a href="javascript:alert('la pregunta que elegiste cuando te registraste')">?</a>)</td>
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
				<input type="hidden" name="remember" value="enviar">
				<tr>
					<td colspan="2">
						<center><input type="submit" value="Obtener Password"></center>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<center><a href="login.php">Iniciar Sesion</a></center>
					</td>
				</tr>
			</form>
		</table>
	</body>
</html>
<?php
    }
}else{ //si el action obtenido de la url no es remember


if($_POST['action']=="enviar"){ //si enviamos el formulario del login

    if($_POST['usuario']=="" || $_POST['pass']==""){ //si los campos estan vacios
        echo"<script>alert('debe introducir todos los datos!')</script>"; //mostramos error
    }else{ //sino estan vacios

    if(file_exists("./users/".$_POST['usuario'])){ //si existe el usuario
        include("./users/".$_POST['usuario']."/datos.php"); //incluimos los datos
            if($pass==$_POST['pass']){ //si el pass del login coincide con el del rgistro
                $_SESSION['usuario']=strip_tags($_POST['usuario']); //creamos una variable de sesion con el nombre del usuario
                $_SESSION['login']="ok"; //creamos la variable de sesion login con el valor de ok
                header("Location: index.php"); //redirigimos al index
            }else{ //si no coinciden los pass
                echo"<script>alert('los datos son incorrectos!')</script>"; //mostramos que no son correctos los datos
            }
        
    }else{ //sino existe el usuario
        echo "<script>alert('el usuario no existe!')</script>"; //mostramos que no existe el usuario
    }
    
    }

}

}

}
if($_GET['action']!="remember"){ //si action obtenido de la url es diferente a remember mostramos el formulario de login
?>
<html>
	<head>
		<title>Login</title>
	</head>
	<body bgcolor="#000000" text="#FFFFFF">
		<center>
		<h1>Login de usuarios</h1>
		<table border="0" align="center">
			<form method="post" action="">
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="usuario"></td>
				</tr>
				<tr>
					<td>Pass:</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<input type="hidden" name="action" value="enviar">
				<tr>
					<td colspan="2">
						<center><input type="submit" value="Enviar"></center>
					</td>
				</tr>
			</form>
			<tr>
				<td>
					<center><a href="registrar.php">Registrarse</a>
				</td>
				<td>
					<center><a href="login.php?action=remember">Olvido su Password?</a>
				</td>
			</tr>
		</table>
	</body>
</html>
<?php
}
?> 