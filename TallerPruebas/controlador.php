<?php
$accion = $_POST["accion"];

$idUsuario = $_POST['idusuario'];
$fecha = $_POST['fecha'];
$horas = $_POST['hora'];
$minutos = $_POST['minutos'];
$estacion1 = $_POST['estacion1'];
$estacion2 = $_POST['estacion2'];
  
  if($_POST['accion']=="registrar")
  {
	if($_POST['idusuario']=="" || $_POST['fecha']=="" || $_POST['hora']=="" || $_POST['minutos']=="" || $_POST['estacion1']=="" || $_POST['estacion2']=="")
	{
		//echo "<div class='alert alert-info'><a class='close' data-dismiss='alert'>x</a><h4 class='alert-heading'>Campos vacios!</h4>Asegurate de rellenar todos los campos del formulario</div>";
		//mostramos error
		?><script>alert("campos vacios");</script>
<?php
	}
	else
	{
		//espacio para incluir el modelo
		$modelo = new Modelo($idUsuario, $fecha, $horas, $minutos, $estacion1, $estacion2);
		//Insertando en la base de datos
		$modelo->insertarRegistro();
		
		//Captando todos los registros
		$$modelo->mostrarRegistro()
		
		//Mostrando las tablas justo despues de insertar
		$registros = "<div class="record">
				<div class="usuario"><strong>Usuario: </strong>user003</div>
				<div class="fecha"><strong>Fecha: </strong>05/22/2012</div>
				<div class="hora"><strong>Hora: </strong>08:25</div>
				<div class="sta_origen"><strong>Estacion origen: </strong>Chiminangos</div>
				<div class="sta_destino"><strong>Estacion destino: </strong>Centro</div>
				<div class="select"><button onclick="darclick('user003', '05/22/2012', '08', '25', 'sta001', 'sta006');">Seleccionar</button></div>
			</div>";
		while($row = mysql_fetch_array($querymostrar))
		{ 
			$tabla = $tabla."<tr><td>".$row['titulo']."</td><td>".$row['artista']."</td><td>".$row['album']."</td><td>".$row['genero']."</td></tr>";
		}
		
		
	}
  }
  else if($_POST['accion']=="mostrar")
  {
	
  }

?>