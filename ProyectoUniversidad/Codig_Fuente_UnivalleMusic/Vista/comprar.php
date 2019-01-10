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


	
    <div class="topbar">
      <div class="fill">
        <div class="container">
          <a class="brand" href="index.php">Mi tienda</a>
       				
        	</div>
        
       
        </div>
      </div>
    </div>

    <div class="container">

    
		<div class="row">
		
		
			<div class="span14" id="productos">
				
				
				<div class="well" >
			
               
               	<form name='formTpv' method='post' action='https://www.sandbox.paypal.com/cgi-bin/webscr' style="border: 1px solid #CECECE;padding-left: 10px;">
					<input name="cmd" type="hidden" value="_cart"> 
					<input name="upload" type="hidden" value="1">
					<input name="business" type="hidden" value="diegos_1352764992_biz@gmail.com">
					<input name="shopping_url" type="hidden" value="http://eisc.univalle.edu.co/~sergiop/Univalle-Music-Postgres/UnivalleMusicPostgres/Vista/carritoCompras.php">
					<input name="currency_code" type="hidden" value="EUR">
					<input name="return" type="hidden" value="http://eisc.univalle.edu.co/~sergiop/Univalle-Music-Postgres/UnivalleMusicPostgres/Vista/exito.php">
					<input type='hidden' name='cancel_return' value='http://localhost/mitienda/errorPaypal.php'>
					<input name="notify_url" type="hidden" value="http://eisc.univalle.edu.co/~sergiop/Univalle-Music-Postgres/UnivalleMusicPostgres/Vista/paypalipn.php">
					<input name="rm" type="hidden" value="2">
               
               
               
			<?php
			$contador = 0;
					foreach($_SESSION['carro'] as $key=>$valor){
						$contador ++;
						
						$fi=$config->getProductosPorId($key);
						
						while($row = pg_fetch_array($fi))
						{
							
							
							$id=$row['id_cancion_venta'];
							$producto=$row['titulo'];
							$precio=$row['precio'];
						}
						
						?>
						
						
			<input name="item_number_<?php echo $contador; ?>" type="hidden" value="<?php echo $id; ?>">
			<input name="item_name_<?php echo $contador; ?>" type="hidden" value="<?php echo $producto; ?>"> 
			<input name="amount_<?php echo $contador; ?>" type="hidden" value="<?php echo $precio; ?>"> 
			<input name="quantity_<?php echo $contador; ?>" type="hidden" value="<?php echo $valor; ?>"> 
						
						<?php
						
						
						}
					
					
					
					?>
			<input type="submit" value="PayPal SandBox">-	
			</form>	
               
               
				
					
				</div>

				
		
			
		
		</div>
	
      <footer>
        <p>&copy; Company 2012</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>
