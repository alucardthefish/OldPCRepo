<?php

namespace Cupon\OfertaBundle\Util;

/**
 * Description of Util
 *
 * @author Administrador
 */
class Util
{
    static public function getSlug($cadena, $separador = '-')
    {
        $slug = iconv('UTF-8', 'ASCII//TRANSLIT', $cadena);
        $slug = preg_replace("/[^a-zA-Z0-9\/_|+ -]/", '', $slug);
        $slug = strtolower(trim($slug, $separador));
        $slug = preg_replace("/[\/_|+ -]+/", $separador, $slug);
        
        
        return $slug;
    }
}

?>
