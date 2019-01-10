
    <div class="topbar">
      <div class="fill">
        <div class="container">
          <a class="brand" href="carritoCompras.php">Mi tienda</a>
       		
       		<div class="row">
       			
       			
       			<div  class="span4" style="background:#fff;float:right;">
       			
       			  <a href="carro.php">    
                               
                 <img src="img/carrito.png" alt="carro">
			
                <?php if(isset($_SESSION["cantidadTotal"])):?> 
                 
		total:<?php echo $_SESSION["cantidadTotal"];?>
		$ <?php echo $_SESSION["totalcoste"];?> 
                
                <?php else:?>
                
                    total: 0
                     $     0
                <?php endif;?>
             </a>
					
       			
       			
       			</div>
       			
       		</div>
        		
        	</div>
        
       
        </div>
      </div>