<?php
include_once("modelo.php");
$accion = $_POST["accion"];

$idUsuario = @$_POST['idusuario'];
$fecha = @$_POST['fecha'];
$horas = @$_POST['hora'];
$minutos = @$_POST['minutos'];
$estacion1 = @$_POST['estacion1'];
$estacion2 = @$_POST['estacion2'];
  
  if($_POST["accion"]=="registrar")
  {
	if($_POST["fecha"]=="")
	{
		//echo "<div class='alert alert-info'><a class='close' data-dismiss='alert'>x</a><h4 class='alert-heading'>Campos vacios!</h4>Asegurate de rellenar todos los campos del formulario</div>";
		//mostramos error
		$stmsj = "<h3>Campos vacios</h3>";
		echo $stmsj;
	}
	else
	{
		
		//espacio para incluir el modelo
		$modelo = new Modelo($idUsuario, $fecha, $horas, $minutos, $estacion1, $estacion2);
		//Insertando en la base de datos
		$modelo->insertarRegistro();
		//<script>alert("Ingresado con exito");</script>
		//echo "<h3>Ingreso a la base de datos correctamente</h3>";
		//Captando todos los registros
		$querymostrar = $modelo->mostrarRegistro();
		
		//Mostrando las tablas justo despues de insertar
		$registros = "";
		
		while($row = mysql_fetch_array($querymostrar))
		{
			$registros = $registros."<div class=\"record\"><div class=\"usuario\"><strong>Usuario: </strong>".$row['id_pasajero']."</div><div class=\"fecha\"><strong>Fecha: </strong>".$row['fecha']."</div><div class=\"hora\"><strong>Hora: </strong>".$row['hora_entrada'].":".$row['minuto_entrada']."</div><div class=\"sta_origen\"><strong>Estacion origen: </strong>".$row['est1_nombre']."</div><div class=\"sta_destino\"><strong>Estacion destino: </strong>".$row['est2_nombre']."</div><div class=\"select\"><button onclick=\"darclick('".$row['id_registro']."', '".$row['id_pasajero']."', '".$row['fecha']."', '".$row['hora_entrada']."', '".$row['minuto_entrada']."', '".$row['est1_id']."', '".$row['est2_id']."');\">Seleccionar</button></div></div>";
		}
		
		echo $registros;	
	}
  }
  else if($_POST["accion"]=="mostrar")
  {
		$modeloshow = new Modelo("","","","","","");
		$receptorDatos = $modeloshow->mostrarRegistro();
		$registros = "";
		
		while($row = mysql_fetch_array($receptorDatos))
		{
			$registros = $registros."<div class=\"record\"><div class=\"usuario\"><strong>Usuario: </strong>".$row['id_pasajero']."</div><div class=\"fecha\"><strong>Fecha: </strong>".$row['fecha']."</div><div class=\"hora\"><strong>Hora: </strong>".$row['hora_entrada'].":".$row['minuto_entrada']."</div><div class=\"sta_origen\"><strong>Estacion origen: </strong>".$row['est1_nombre']."</div><div class=\"sta_destino\"><strong>Estacion destino: </strong>".$row['est2_nombre']."</div><div class=\"select\"><button onclick=\"darclick('".$row['id_registro']."', '".$row['id_pasajero']."', '".$row['fecha']."', '".$row['hora_entrada']."', '".$row['minuto_entrada']."', '".$row['est1_id']."', '".$row['est2_id']."');\">Seleccionar</button></div></div>";
		}
		
		echo $registros;
  }
  else if($_POST["accion"]=="eliminar")
  {
		
  }
  

?>