<?php

namespace Cupon\CiudadBundle\DataFixtures\ORM;

use Doctrine\Common\DataFixtures\FixtureInterface;
use Doctrine\Common\Persistence\ObjectManager;
use Cupon\CiudadBundle\Entity\Ciudad;

/**
 * Description of Ciudades
 *
 * @author Administrador
 */
class Ciudades implements FixtureInterface
{
    public function load(ObjectManager $manager)
    {
//        $ciudades = array(
//            array('nombre' => 'Madrid'),
//            array('nombre' => 'Barcelona'),
//            array('nombre' => 'Valencia'),
//            array('nombre' => 'Tenerife'),
//            array('nombre' => 'Malaga'),
//            array('nombre' => 'Valladolid')
//        );
        
        
        $ciudades = array(
            'Madrid',
            'Barcelona',
            'Valencia',
            'Sevilla',
            'Zaragoza',
            'Málaga',
            'Murcia',
            'Palma de Mallorca',
            'Las Palmas de Gran Canaria',
            'Bilbao',
            'Alicante',
            'Córdoba',
            'Valladolid',
            'Vigo',
            'Gijón',
            'Hospitalet de Llobregat',
            'La Coruña',
            'Granada',
            'Vitoria-Gasteiz',
            'Elche',
            'Oviedo',
            'Santa Cruz de Tenerife',
            'Badalona',
            'Cartagena',
            'Tarrasa',
        );
        
        
        foreach($ciudades as $nombre)
        {
            $entidad = new Ciudad();
            
            $entidad->setNombre($nombre);
            //$entidad->setSlug($ciudad['slug']);
            
            $manager->persist($entidad);
        }
        
        $manager->flush();
    }
}

?>
