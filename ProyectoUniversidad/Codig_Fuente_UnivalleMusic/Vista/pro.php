<?php
require_once '../Controlador/config.php';
$config=new Config();
$id=strip_tags($_GET['id']);
$productos=$config->getProductosPorId($id);
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
<link href="../Assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="../Scripts/XHRObjeto.js"></script>
  	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="../Scripts/funciones.js"></script>
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
  </head>

  <body>


	<?php require_once 'header.php';?>
    </div>

    <div class="container-fluid">

    
		<div class="row-fluid">
		
		
			<div class="span12">
				<h1>Detalle</h1>
				<hr />
				
					
					<div class="span3">
						
						<?php while($row = pg_fetch_array($productos))
						{?>
								
							
								
								<img src="<?php echo $row['foto'];?>" alt=""/>
							
							
							<div class="span7">
								
								
								<h1><?php echo $row['titulo'];?></h1>
								<p><?php echo $row['artista'];?></p>
								<p><?php echo $row['precio'];?></p>
								<p><?php echo $row['album'];?></p>
								
								
								
								
							<a class="btn" href="carro.php?id=<?php echo $row['id_cancion_venta'];?>&action=add">Comprar</a>
							
							</div>		
							
						
						
						
						
					</div>
					
					
					<div class="span12" style="text-align:center;">
						
						
						
						
					</div>
					
					<?php }?>
					
				
				
				
				
			</div>
		
		</div>
	


    </div> <!-- /container -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script src="Assets/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
