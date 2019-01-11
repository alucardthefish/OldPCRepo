<?
class cancion {
	//atributos de la clase
   	var $titulo_cancion;
   	var $artista_cancion;
   	var $album_cancion;
   	var $genero_cancion;
   	var $me_gusta_cancion

	//constructor. Realiza las tareas de inicializar los objetos cuando se instancian
	//inicializa el numero de productos a 0
	function cancion ($tituloCancion, $artistaCancion, $albumCancion, $generoCancion, $meGustaCancion) {
   		$this->titulo_cancion=$tituloCancion;
   		$this->artista_cancion=$artistaCancion;
   		$this->album_cancion=$albumCancion;
   		$this->genero_cancion=$generoCancion;
   		$this->me_gusta_cancion=$meGustaCancion;
	}
	
	
	
	
	function get_titulo_cancion()
	{
	  return $this->titulo_cancion;
	}
	
	function set_titulo_cancion($titulo)
	{
	  $this->titulo_cancion = $titulo;
	}
	
	function get_artista_cancion()
	{
	  return $this->artista_cancion;
	}
	
	function set_artista_cancion($artista)
	{
	  $this->artista_cancion = $artista;
	}
	
	function get_album_cancion()
	{
	  return $this->album_cancion;
	}
	
	function set_album_cancion($album)
	{
	  $this->album_cancion = $album;
	}
	
	function get_genero_cancion()
	{
	  return $this->genero_cancion
	}
	
	function set_genero_cancion($genero)
	{
	  $this->genero_cancion = $genero;
	}
	
	function get_me_gusta_cancion()
	{
	  return $this->me_gusta_cancion;
	}
	
	function set_me_gusta_cancion($meGusta)
	{
	  $this->me_gusta_cancion = $meGusta;
	}

	
} 

?>