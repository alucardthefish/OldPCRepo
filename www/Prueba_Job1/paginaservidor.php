<?php
	include('conexion.php');

	$peticion = $_POST["peticion"];
	
	
	switch($peticion)
	{
		case "articulos":
		
		conectar();
		$consulta = "select * from articulo";
		$resConsulta = mysql_query($consulta) or die(mysql_error());
		desconectar();
		
		$datos = "";
		
		while($fila = mysql_fetch_array($resConsulta))
		{
			$datos = $datos."<option value=\"".$fila['id']."\" data-precio=\"".$fila['precio']."\" data-idprod=\"".$fila['id']."\">".$fila['nombre']." - $".$fila['precio']."</option>";
		}
		
		echo $datos;
		
	}
	
?>