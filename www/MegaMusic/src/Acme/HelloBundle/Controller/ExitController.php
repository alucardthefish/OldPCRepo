<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    namespace Acme\HelloBundle\Controller;
    
    use Symfony\Component\HttpFoundation\Response;
    
    class ExitController
    {
        public function salirAction($name)
        {
            return new Response('<html><body><h1>'.$name.'Te has salido!!!!</h1></body></html>');
        }
        
        public function cerrarAction()
        {
            return new Response('<html><body><h1>Te has salido!!!!</h1></body></html>');
        }
    }

?>
