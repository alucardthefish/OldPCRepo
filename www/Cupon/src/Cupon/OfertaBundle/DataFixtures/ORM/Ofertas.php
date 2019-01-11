<?php

namespace Cupon\OfertaBundle\DataFixtures\ORM;

use Doctrine\Common\DataFixtures\FixtureInterface;
use Doctrine\Common\Persistence\ObjectManager;
use Cupon\OfertaBundle\Entity\Oferta;

/**
 * Description of Ofertas
 *
 * @author Administrador
 */
class Ofertas implements FixtureInterface
{
    public function load(ObjectManager $manager) {
        for($i = 0; $i < 400; $i++)
        {
            $entidad = new Oferta();
            
            $entidad->setNombre('Oferta '.$i);
            $entidad->setPrecio(rand(1, 100));
            $entidad->setDescuento(rand(10, 50));
            $entidad->setFechaPublicacion(new \DateTime());
            $entidad->setDescripcion("Cupon de la oferta para el producto ".$i." te ofrece la mejor opcion");
            
            $manager->persist($entidad);
        }
        
        $manager->flush();
    }
}

?>
