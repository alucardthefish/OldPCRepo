<?php

// src/Cupon/OfertaBundle/Controller/SitioController.php

namespace Cupon\OfertaBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of SitioController
 *
 * @author Administrador
 */
class SitioController extends Controller
{
    //put your code here
    
    public function estaticaAction($pagina)
    {
        return $this->render('OfertaBundle:Sitio:'.$pagina.'.html.twig');
    }
    
}

?>
