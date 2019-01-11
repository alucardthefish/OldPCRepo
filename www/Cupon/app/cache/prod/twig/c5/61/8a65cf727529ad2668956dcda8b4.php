<?php

/* OfertaBundle:Default:portada.html.twig */
class __TwigTemplate_c5618a65cf727529ad2668956dcda8b4 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        echo "<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />
        <title>Portada | Cupon</title>
    </head>
    
    <body id=\"portada\">
        <div id=\"contenedor\">
            <header>
                <h1><a href=\"";
        // line 12
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("portada"), "html", null, true);
        echo "\">CUPON</a></h1>
                <nav>
                    <ul>
                        <li><a href=\"";
        // line 15
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("portada"), "html", null, true);
        echo "\">Oferta del día</a></li>
                        <li><a href=\"#\">Ofertas recientes</a></li>
                        <li><a href=\"#\">Mis ofertas</a></li>
                    </ul>
                </nav>
            </header>
            
                <article class=\"oferta\">
                    <section class=\"descripcion\">
                        <h1><a href=\"#\"> ";
        // line 24
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "nombre"), "html", null, true);
        echo " </a></h1>
                        ";
        // line 25
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "descripcion"), "html", null, true);
        echo "
                        <a class=\"boton\" href=\"#\">Comprar</a>
                    </section>
                        
                        <section class=\"galeria\">
                            <img alt=\"Fotografía de la oferta\" src=\"";
        // line 30
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl(("uploads/images/" . $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "foto"))), "html", null, true);
        echo "\">
                            <p class=\"precio\">";
        // line 31
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "precio"), "html", null, true);
        echo " &euro;
                                <span>";
        // line 32
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "descuento"), "html", null, true);
        echo "</span></p>
                            <p><strong>Condiciones:</strong> ";
        // line 33
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "condiciones"), "html", null, true);
        echo "</p>
                        </section>
                        
                        <section class=\"estado\">
                            <div class=\"tiempo\">
                                <strong>Faltan</strong>: ";
        // line 38
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "fechaExpiracion")), "html", null, true);
        echo "
                            </div>
                                <div class=\"compras\">
                                    <strong>Compras</strong>: ";
        // line 41
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "compras"), "html", null, true);
        echo "
                                </div>
                                <div class=\"faltan\">
                                    ";
        // line 44
        $context["faltan"] = ($this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "umbral") - $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "compras"));
        // line 45
        echo "                                    ";
        if (((isset($context["faltan"]) ? $context["faltan"] : null) > 0)) {
            // line 46
            echo "                                        Faltan <strong> ";
            echo twig_escape_filter($this->env, (isset($context["faltan"]) ? $context["faltan"] : null), "html", null, true);
            echo " compras</strong> <br />
                                        para activar la oferta
                                    
                                    ";
        } else {
            // line 50
            echo "                                        <strong>Oferta activada</strong> por superar las
                                        <strong>";
            // line 51
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "umbral"), "html", null, true);
            echo "</strong> compras necesarias
                                    ";
        }
        // line 53
        echo "                                </div>
                        </section>
                        
                        <section class=\"direccion\">
                            <h2>Disfruta de la oferta en</h2>
                            <p>
                                <a href=\"#\">";
        // line 59
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "tienda"), "nombre"), "html", null, true);
        echo "</a>
                                ";
        // line 60
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "tienda"), "direccion"), "html", null, true);
        echo "
                            </p>
                        </section>
                        
                        <section class=\"tienda\">
                            <h2>Sobre la tienda</h2>
                            ";
        // line 66
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : null), "tienda"), "descripcion"), "html", null, true);
        echo "
                        </section>
                        
                </article>
                
                <aside>
                    ## FORMULARIO DE LOGIN ##
                    
                    <section id=\"nosotros\">
                        <h2>Sobre nosotros</h2>
                        <p>Loren ipsum dolor sit amen....</p>
                    </section>
                </aside>
                
                <footer>
                    &copy; ";
        // line 81
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, "now", "Y"), "html", null, true);
        echo " - Cupon
                    <a href=\"";
        // line 82
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("pagina_estatica", array("pagina" => "ayuda")), "html", null, true);
        echo "\">
                        Ayuda
                    </a>
                    <a href=\"";
        // line 85
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("pagina_estatica", array("pagina" => "contacto")), "html", null, true);
        echo "\">
                        Contacto
                    </a>
                    <a href=\"";
        // line 88
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("pagina_estatica", array("pagina" => "privacidad")), "html", null, true);
        echo "\">
                        Privacidad
                    </a>
                    <a href=\"";
        // line 91
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("pagina_estatica", array("pagina" => "sobre-nosotros")), "html", null, true);
        echo "\">
                        Sobre nosotros
                    </a>
                </footer>
            
        </div>
    </body>
    
</html>
";
    }

    public function getTemplateName()
    {
        return "OfertaBundle:Default:portada.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  176 => 91,  170 => 88,  164 => 85,  158 => 82,  154 => 81,  136 => 66,  127 => 60,  123 => 59,  115 => 53,  110 => 51,  107 => 50,  99 => 46,  96 => 45,  94 => 44,  88 => 41,  82 => 38,  74 => 33,  70 => 32,  66 => 31,  62 => 30,  54 => 25,  50 => 24,  38 => 15,  32 => 12,  19 => 1,);
    }
}
