<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// src/Acme/TareaBundle/Entity/Tarea.php
namespace Sergio\TareaBundle\Entity;
/**
 * Description of Tarea
 *
 * @author Administrador
 */
class Tarea
{
    //put your code here
    
    protected $tarea;
    
    protected $fechaVencimiento;
    
    public function getTarea()
    {
        return $this->tarea;
    }
    
    public function setTarea($tarea)
    {
        $this->tarea = $tarea;
    }
    
    public function getFechaVencimiento()
    {
        return $this->fechaVencimiento;
    }
    
    public function setFechaVencimiento(\DateTime $fechaVencimiento = null)
    {
        $this->fechaVencimiento = $fechaVencimiento;
    }
    
}

?>
