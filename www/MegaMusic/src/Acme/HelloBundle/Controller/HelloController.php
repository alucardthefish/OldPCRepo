<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    namespace Acme\HelloBundle\Controller;
    
    use Symfony\Component\HttpFoundation\Response;
    
    class HelloController
    {
        public function indexAction($name)
        {
            return new Response('<html><body><h2>Hola '.$name.'! que hay de nuevo</h2><br />
                <a href="http://localhost/MegaMusic/web/app_dev.php/exit/'.$name.'">Salir</a></body></html>');
        }
        
    }


?>
