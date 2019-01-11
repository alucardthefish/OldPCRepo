<?php

namespace Sergio\TareaBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sergio\TareaBundle\Entity\Tarea;
use Symfony\Component\HttpFoundation\Request;

class DefaultController extends Controller
{
    
    public function nuevaAction(Request $peticion)
    {
        // Crea una tarea y proporciona unos datos ficticios para este ejemplo
        $tarea = new Tarea();
        $tarea->setTarea('Escribir una entrada para el blog');
        $tarea->setFechaVencimiento(new \DateTime('tomorrow'));
        
        $form = $this->createFormBuilder($tarea)
                ->add('tarea', 'text')
                ->add('fechaVencimiento', 'date')
                ->getForm();
        
        return $this->render('SergioTareaBundle:Default:nueva.html.twig', array('form' => $form->createView()));
        
    }


//    public function indexAction($name)
//    {
//        return $this->render('SergioTareaBundle:Default:index.html.twig', array('name' => $name));
//    }
}
