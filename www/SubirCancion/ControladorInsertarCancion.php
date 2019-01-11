<?php 
include('conexion.php');
  class ControladorInsertarCancion
  {    
    var $titulo ;
    var $artista ;
    var $album ;
    var $genero ;
    var $nick ;
    
    function ControladorInsertarCancion($titulo, $artista, $album, $genero, $nick)
    {
      $this->titulo=$titulo;
      $this->artista=$artista;
      $this->album=$album;
      $this->genero=$genero;
      $this->nick=$nick;
    }
    
    function insertarCancion()
    {
      conectar();
      $consulta="INSERT INTO cancion (titulo, artista, album, genero) VALUES ('$this->titulo','$this->artista','$this->album','$this->genero')";
      mysql_query($consulta) or die(mysql_error());
      $consulta2="INSERT INTO colecciona (nick, titulo, artista) VALUES ('$this->nick','$this->titulo','$this->artista')";
      mysql_query($consulta2) or die(mysql_error());
      desconectar();
    }
    
  }
?>