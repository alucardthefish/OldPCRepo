<?php 
include('conexion.php');
  class Modelo
  {    
    var $idUsuario;
    var $fecha;
    var $horas;
    var $minutos;
    var $estacion1;
    var $estacion2;
	
    public function __construct($idUsuario, $fecha, $horas, $minutos, $estacion1, $estacion2)
    {
      $this->idUsuario = $idUsuario;
      $this->fecha = $fecha;
      $this->horas = $horas;
      $this->minutos = $minutos;
      $this->estacion1 = $estacion1;
      $this->estacion2 = $estacion2;
    }
	
    public function insertarRegistro()
    {
      conectar();
      $consulta="insert into registro_viajes (id_pasajero, fecha, hora_entrada, minuto_entrada, nombre_estacion_origen, nombre_estacion_destino) values ('$this->idUsuario', '$this->fecha', '$this->horas', '$this->minutos', '$this->estacion1', '$this->estacion2')";
      mysql_query($consulta) or die(mysql_error());
      desconectar();
    }
    
    public function mostrarRegistro()
    {
      conectar();
	  $consult="SELECT id_registro, id_pasajero, fecha, hora_entrada, minuto_entrada, est1.id_estacion as est1_id, est1.nombre as est1_nombre, est2.id_estacion as est2_id, est2.nombre as est2_nombre FROM registro_viajes JOIN estaciones as est1 JOIN estaciones as est2 WHERE nombre_estacion_origen = est1.id_estacion and nombre_estacion_destino = est2.id_estacion";
      //$consult = "select * from registro_viajes";
      $datos = mysql_query($consult) or die (mysql_error());
      desconectar();
      
      return $datos;
    }
	
	public function eleminarRegistro()
	{
		conectar();
		
		desconectar();
	}

    
  }
?>