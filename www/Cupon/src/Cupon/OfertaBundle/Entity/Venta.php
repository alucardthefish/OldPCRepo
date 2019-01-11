<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


namespace Cupon\OfertaBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Description of Venta
 *
 * @author Administrador
 */


/** @ORM\Entity */
class Venta
{
    /** @ORM\Column(type="datetime") */
    protected $fecha;
    
    
    /**
     * @ORM\Id
     * @ORM\ManyToOne(targetEntity="Cupon\OfertaBundle\Entity\Oferta")
     */
    protected $oferta;
    
    /**
     * @ORM\Id
     * @ORM\ManyToOne(targetEntity="Cupon\UsuarioBundle\Entity\Usuario")
     */
    protected $usuario;
    
    public function setFecha($fecha)
    {
        $this->fecha = $fecha;
    }
    
    public function getFecha()
    {
        return $this->fecha;
    }
    
    public function setOferta(\Cupon\OfertaBundle\Entity\Oferta $oferta)
    {
        $this->oferta = $oferta;
    }
    
    public function getOferta()
    {
        return $this->oferta;
    }
    
    public function setUsuario(\Cupon\UsuarioBundle\Entity\Usuario $usuario)
    {
        $this->usuario = $usuario;
    }
    
    public function getUsuario()
    {
        return $this->usuario;
    }
    
    
}

?>
