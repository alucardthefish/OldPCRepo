<?php

use Symfony\Component\Routing\Exception\MethodNotAllowedException;
use Symfony\Component\Routing\Exception\ResourceNotFoundException;
use Symfony\Component\Routing\RequestContext;

/**
 * appProdUrlMatcher
 *
 * This class has been auto-generated
 * by the Symfony Routing Component.
 */
class appProdUrlMatcher extends Symfony\Bundle\FrameworkBundle\Routing\RedirectableUrlMatcher
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

        if (0 === strpos($pathinfo, '/')) {
            // usuario_homepage
            if (0 === strpos($pathinfo, '/hello') && preg_match('#^/hello/(?P<name>[^/]+)$#s', $pathinfo, $matches)) {
                return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'Cupon\\UsuarioBundle\\Controller\\DefaultController::indexAction',)), array('_route' => 'usuario_homepage'));
            }

            // tienda_homepage
            if (0 === strpos($pathinfo, '/hello') && preg_match('#^/hello/(?P<name>[^/]+)$#s', $pathinfo, $matches)) {
                return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'Cupon\\TiendaBundle\\Controller\\DefaultController::indexAction',)), array('_route' => 'tienda_homepage'));
            }

            // ciudad_homepage
            if (0 === strpos($pathinfo, '/hello') && preg_match('#^/hello/(?P<name>[^/]+)$#s', $pathinfo, $matches)) {
                return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'Cupon\\CiudadBundle\\Controller\\DefaultController::indexAction',)), array('_route' => 'ciudad_homepage'));
            }

            // oferta_homepage
            if (0 === strpos($pathinfo, '/hello') && preg_match('#^/hello/(?P<name>[^/]+)$#s', $pathinfo, $matches)) {
                return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'Cupon\\OfertaBundle\\Controller\\DefaultController::indexAction',)), array('_route' => 'oferta_homepage'));
            }

            // pagina_estatica
            if (0 === strpos($pathinfo, '/sitio') && preg_match('#^/sitio/(?P<pagina>[^/]+)/?$#s', $pathinfo, $matches)) {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'pagina_estatica');
                }

                return array_merge($this->mergeDefaults($matches, array (  '_controller' => 'Cupon\\OfertaBundle\\Controller\\SitioController::estaticaAction',)), array('_route' => 'pagina_estatica'));
            }

            // portada
            if (rtrim($pathinfo, '/') === '') {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'portada');
                }

                return array (  '_controller' => 'Cupon\\OfertaBundle\\Controller\\DefaultController::portadaAction',  '_route' => 'portada',);
            }

        }

        throw 0 < count($allow) ? new MethodNotAllowedException(array_unique($allow)) : new ResourceNotFoundException();
    }
}
