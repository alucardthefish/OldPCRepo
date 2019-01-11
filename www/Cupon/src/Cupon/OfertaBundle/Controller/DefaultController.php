<?php

namespace Cupon\OfertaBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;

class DefaultController extends Controller
{
    public function ayudaAction()
    {
        return $this->render('OfertaBundle:Default:ayuda.html.twig');
    }
    
    public function portadaAction($ciudad)
    {
        if($ciudad == null)
        {
            $ciudad = $this->container
                    ->getParameter('cupon.ciudad_por_defecto');
            
            return new RedirectResponse(
            $this->generateUrl('portada', array('ciudad' => $ciudad))
            );
        }
        
        
        $em = $this->getDoctrine()->getManager();
        
        $oferta = $em->getRepository('OfertaBundle:Oferta')->findOneBy(array(
           'ciudad' => $ciudad,
            'fecha_publicacion' => new \DateTime('today')
        ));
        
        if(!$oferta)
        {
            throw $this->createNotFoundException('No se ha creado la oferta del día en la ciudad seleccionada');
        }
        
        return $this->render('OfertaBundle:Default:portada.html.twig', 
                array('oferta' => $oferta));
    }
    
}
