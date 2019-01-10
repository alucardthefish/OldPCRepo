<?php 
include('./conexion.php');
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
      $consult = "select * from registro_viajes";
      $datos = mysql_query($consult) or die (mysql_error());
      desconectar();
      
      return $datos;
    }
    

    
  }
?>