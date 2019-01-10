<?php

require_once '../Controlador/config.php';
$config=new Config();
$productos=$config->getProductos();
?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <title>Carrito de Compras</title>
		<!-- Bootstrap -->
		<link type="text/css" href="../Assets/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen">
		<link href="../Assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<script src="../Scripts/XHRObjeto.js"></script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le styles -->
	
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
				<h1>Carrito de Compras</h1>
				<hr />
    
		
		
		
		<?php while($row = pg_fetch_array($productos))
			{?>
		
		
			<div class="span3">
				
				<h3><?php echo $row['titulo'];?></h3>
				<img src="<?php echo $row['foto'];?>" alt="alan"/>
				<p><?php echo $row['artista'];?></p>
				<p><?php echo $row['precio'];?></p>
				
				<a class="btn" href="pro.php?id=<?php echo $row['id_cancion_venta'];?>">detalle</a>
				
			</div>
		 <?php }?>
		
	

		</div>
			</div>
    </div> <!-- /container -->
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script src="../Assets/bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>
