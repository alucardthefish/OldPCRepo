<?php
require_once '../Controlador/config.php';
$config=new Config();

?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <title>Mi tienda</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le styles -->
<link type="text/css" href="../Assets/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
  	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
		<script src="../Scripts/funciones.js"></script>
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
  </head>

  <body>


	



    <div class="container">

    
		<div class="row">
		
		
			<div class="span14" id="productos">
				
				
				<div class="well" >
			
               
				<?php $config->carro(); ?>
                       
                  <?php  
                  
                  	if(isset($_SESSION['carro'])){
                  		
						
						$totalcoste=0;
						$Total=0;
                  ?>     
                            
					<table>
						
						<tr>
							
							<th>Producto</th>
							<th>Cantidad</th>
							<th>Peticion Normal</th>
							<th>&nbsp;</th>
							<th>Total</th>
							
						</tr>
						
					<?php
					
					foreach($_SESSION['carro'] as $key=>$valor){
					
						$fi=$config->getProductosPorId($key);
						
						while($row = pg_fetch_array($fi))
						{
							
							
							$id=$row['id_cancion_venta'];
							$producto=$row['titulo'];
							$precio=$row['precio'];
						}
					
					$coste=$precio*$valor;
					$totalcoste=$totalcoste+$coste;
					$Total=$Total+$valor;
					
					?>
				
					<tr>
						
						<td><?php echo $producto?></td>
						<td><?php echo $valor;?></td>
						
						
					
				
					<td>
						
						
						
						
						<a href="?id=<?php echo $id ?>&action=removeProd"><img src="img/eliminar.png" alt="aumentar" title="eliminar"/></a>

						
					</td>
					
					
					
					
		
					<td>=</td>
		
					<td style="width: 10px"><?php echo $coste ?></td>
						
					</tr>
		
					<?php
					}
					?>

					<tr>
						
						<td colspan="5">Total</td>
						
						<td><?php echo $totalcoste ?></td>
						
					</tr>					
					</table>
					
				</div>
				<button onclick="window.location='comprar.php'" class="btn success">Finalizar compra</button>

				<?php
				}

				$_SESSION['totalcoste']=$totalcoste;
				$_SESSION['cantidadTotal']=$Total;
				?>
		
			</div>
				
				<button onclick="window.location='carritoCompras.php'" class="btn success">Seguir comprando</button>
			</div>
		
		</div>
	
      <footer>
        <p>&copy; Company 2012</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
