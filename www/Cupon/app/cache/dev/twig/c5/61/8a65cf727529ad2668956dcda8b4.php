<?php

/* OfertaBundle:Default:portada.html.twig */
class __TwigTemplate_c5618a65cf727529ad2668956dcda8b4 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = $this->env->loadTemplate("::frontend.html.twig");

        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'id' => array($this, 'block_id'),
            'article' => array($this, 'block_article'),
            'aside' => array($this, 'block_aside'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "::frontend.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $this->parent->display($context, array_merge($this->blocks, $blocks));
    }

    // line 3
    public function block_title($context, array $blocks = array())
    {
        // line 4
        echo "Cupon, cada día ofertas increibles en tu ciudad con descuentos de hasta el 90%
";
    }

    // line 7
    public function block_id($context, array $blocks = array())
    {
        echo "portada";
    }

    // line 9
    public function block_article($context, array $blocks = array())
    {
        // line 10
        echo "<section class=\"descripcion\">
    <h1><a href=\"#\">";
        // line 11
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "nombre"), "html", null, true);
        echo "</a></h1>
    ";
        // line 12
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "descripcion"), "html", null, true);
        echo "
    <a class=\"boton\" href=\"#\">Comprar</a>
</section>
<section class=\"galeria\">
    <img alt=\"Fotografía de la oferta\" src=\"";
        // line 16
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl(("uploads/images/" . $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "foto"))), "html", null, true);
        echo "\" />
    <p class=\"precio\">
        ";
        // line 18
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "precio"), "html", null, true);
        echo " &euro; <span>";
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "descuento"), "html", null, true);
        echo "</span>
    </p>
    <p><strong>Condiciones:</strong> ";
        // line 20
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "condiciones"), "html", null, true);
        echo "</p>
</section>
<section class=\"estado\">
    <div class=\"tiempo\">
        <strong>Faltan</strong>: ";
        // line 24
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "fechaExpiracion")), "html", null, true);
        echo "
    </div>
        <div class=\"compras\">
            <strong>Compras</strong>: ";
        // line 27
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "compras"), "html", null, true);
        echo "
        </div>
        <div class=\"faltan\">
            ";
        // line 30
        $context["faltan"] = ($this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "umbral") - $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "compras"));
        // line 31
        echo "                ";
        if (((isset($context["faltan"]) ? $context["faltan"] : $this->getContext($context, "faltan")) > 0)) {
            // line 32
            echo "                Faltan <strong>";
            echo twig_escape_filter($this->env, (isset($context["faltan"]) ? $context["faltan"] : $this->getContext($context, "faltan")), "html", null, true);
            echo " compras</strong> <br /> Para activar la oferta
                ";
        } else {
            // line 34
            echo "                <strong>Oferta activada</strong> por superar las <strong>";
            echo twig_escape_filter($this->env, $this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "umbral"), "html", null, true);
            echo "</strong> 
                compras necesarias
                ";
        }
        // line 37
        echo "        </div>
</section>
<section class=\"direccion\">
    <h2>Disfruta de la oferta en</h2>
    <p>
        <a href=\"#\">";
        // line 42
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "tienda"), "nombre"), "html", null, true);
        echo "</a>
        ";
        // line 43
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "tienda"), "direccion"), "html", null, true);
        echo "
    </p>
</section>
<section class=\"tienda\">
    <h2>Sobre la tienda</h2>
    ";
        // line 48
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute((isset($context["oferta"]) ? $context["oferta"] : $this->getContext($context, "oferta")), "tienda"), "descripcion"), "html", null, true);
        echo "
</section>
";
    }

    // line 52
    public function block_aside($context, array $blocks = array())
    {
        // line 53
        echo "## FORMULARIO DE LOGIN ##

<section id=\"nosotros\">
    <h2>Sobre nosotros</h2>
    <p>Loren ipsun dolor kei idiol ldkjeo jdi ...</p>
</section>
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
        return array (  140 => 53,  137 => 52,  130 => 48,  122 => 43,  118 => 42,  111 => 37,  104 => 34,  98 => 32,  95 => 31,  93 => 30,  87 => 27,  81 => 24,  74 => 20,  67 => 18,  62 => 16,  55 => 12,  51 => 11,  48 => 10,  45 => 9,  39 => 7,  34 => 4,  31 => 3,);
    }
}
