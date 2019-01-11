<?php
// src/Blogger/BlogBundle/Controller/BlogController.php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
namespace Blogger\BlogBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
/**
 * Controlador del blog
 *
 * @author Administrador
 */
class BlogController extends Controller
{
    /**
     * Muestra una entrada del blog
     */
    public function showAction($id)
    {
        $em = $this->getDoctrine()->getEntityManager();
        
        $blog = $em->getRepository('BloggerBlogBundle:Blog')->find($id);
        
        if(!$blog)
        {
            throw $this->createNotFoundException('Incapaz de encontrar el blog buscado.');
        }
        
        $comments = $em->getRepository('BloggerBlogBundle:Comment')
                ->getCommentsForBlog($blog->getId());
        
        return $this->render('BloggerBlogBundle:Blog:show.html.twig', array(
            'blog' => $blog,
            'comments' => $comments
        ));
    }
}

?>
