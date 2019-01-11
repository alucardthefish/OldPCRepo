<?php

use Symfony\Component\Routing\Exception\MethodNotAllowedException;
use Symfony\Component\Routing\Exception\ResourceNotFoundException;
use Symfony\Component\Routing\RequestContext;

/**
 * appprodUrlMatcher
 *
 * This class has been auto-generated
 * by the Symfony Routing Component.
 */
class appprodUrlMatcher extends Symfony\Bundle\FrameworkBundle\Routing\RedirectableUrlMatcher
{
    /**
     * Constructor.
     */
    public function __construct(RequestContext $context)
    {
        $this->context = $context;
    }

    public function match($pathinfo)
    {
        $allow = array();
        $pathinfo = rawurldecode($pathinfo);

        // sergio_tarea_homepage
        if (0 === strpos($pathinfo, '/hello') && preg_match('#^/hello/(?P<name>[^/]+)$#s', $pathinfo, $matches)) {
            return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'Sergio\\TareaBundle\\Controller\\DefaultController::indexAction',)), array('_route' => 'sergio_tarea_homepage'));
        }

        // tarea_nueva
        if ($pathinfo === '/Formulario') {
            return array (  '_controller' => 'Sergio\\TareaBundle\\Controller\\DefaultController::nuevaAction',  '_route' => 'tarea_nueva',);
        }

        // mdw_demo_homepage
        if (0 === strpos($pathinfo, '/hello') && preg_match('#^/hello/(?P<name>[^/]+)$#s', $pathinfo, $matches)) {
            return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'MDW\\DemoBundle\\Controller\\DefaultController::indexAction',)), array('_route' => 'mdw_demo_homepage'));
        }

        // acme_hello_homepage
        if (0 === strpos($pathinfo, '/hello') && preg_match('#^/hello/(?P<name>[^/]+)$#s', $pathinfo, $matches)) {
            return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'Acme\\HelloBundle\\Controller\\HelloController::indexAction',)), array('_route' => 'acme_hello_homepage'));
        }

        // acme_hello_exit
        if (0 === strpos($pathinfo, '/exit') && preg_match('#^/exit/(?P<name>[^/]+)$#s', $pathinfo, $matches)) {
            return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'Acme\\HelloBundle\\Controller\\ExitController::salirAction',)), array('_route' => 'acme_hello_exit'));
        }

        throw 0 < count($allow) ? new MethodNotAllowedException(array_unique($allow)) : new ResourceNotFoundException();
    }
}
