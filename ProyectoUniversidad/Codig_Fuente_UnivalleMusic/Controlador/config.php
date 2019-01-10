<?php
session_start();
include('../Config/conexion.php');
class Config{

	private $pdo;
	private $datos;
	
	
	public function __construct(){
	
	
	
	}
	
	private function _redirect(){
		
		
		return header('location:../Vista/carritoCompras.php');
		
	}
	

	
	public function getProductos(){
		
		conectar();
      $consulta="SELECT * FROM cancionesenventa";
      $datos = pg_query($consulta) or die(pg_last_error());
      desconectar();
      
	  return $datos; 
		
		
	}
	

	public function getProductosPorId($id=null){
		
		$id=(int)$id;
		
		if(empty($id) OR !$id){
			
			
			$this->_redirect();
		}
		conectar();
      $consulta="SELECT * FROM cancionesenventa
										WHERE cancionesenventa.id_cancion_venta='".$id."'";
      $datos = pg_query($consulta) or die(pg_last_error());
      desconectar();
      
	  return $datos; 
	}
	
	public function carro(){
					
				
			if(isset($_GET['id'])){
						
				$id=$_GET['id'];	
				
			}
			
			else{
					
				$id=1;
			}
			
					
			if(isset($_GET['action'])){
						
				$action=$_GET['action'];	
				
			}
			
			else{
					
				$action="";
			}
	
			if(isset($_GET['su'])){
						
				$valor=$_GET['su'];	
				
				$valor=(int)$valor;
				
				if($valor==0 OR $valor=='' OR !$valor){
					
					
					$action='removeProd';
				}
			}
			
			else{
					
				$valor=0;
			}
	
	
			switch ($action) {
				
				
				case 'sum':
					
					if(isset($_SESSION['carro'][$id]))
					
						$_SESSION['carro'][$id]=$valor;
					
					else 
						
						$_SESSION['carro'][$id]=1;
					
					
					break;
				
				
				case 'add':
					
					if(isset($_SESSION['carro'][$id]))
					
						$_SESSION['carro'][$id]=1;
					
					else 
						
						$_SESSION['carro'][$id]=1;
					
					
					break;
					
				case 'remove':
					
					if(isset($_SESSION['carro'][$id]))
					{
						$_SESSION['carro'][$id]--;
						
						if($_SESSION['carro'][$id]==0){
								
							unset($_SESSION['carro'][$id]);
						}
					}
					
					
					
					break;
				
			case 'removeProd':
					
					if(isset($_SESSION['carro'][$id]))
					{
						
								
							unset($_SESSION['carro'][$id]);
						
					}
					
					
					
					break;	
							
			case 'empty':
					
					
							unset($_SESSION['carro'][$id]);
					
					
					break;		
				
			}
		
	}	

}



?>