<?php

/* ::base.html.twig */
class __TwigTemplate_e4b1de0c10e3b6a1415f12e4af2edfae extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'stylesheets' => array($this, 'block_stylesheets'),
            'id' => array($this, 'block_id'),
            'body' => array($this, 'block_body'),
            'javascripts' => array($this, 'block_javascripts'),
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        echo "<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />
        <title>";
        // line 5
        $this->displayBlock('title', $context, $blocks);
        echo " | Cupon </title>
        ";
        // line 6
        $this->displayBlock('stylesheets', $context, $blocks);
        // line 7
        echo "    </head>
    <body id=\"";
        // line 8
        $this->displayBlock('id', $context, $blocks);
        echo "\">
        <div id=\"contenedor\">
            ";
        // line 10
        $this->displayBlock('body', $context, $blocks);
        // line 11
        echo "                <footer>
                    &copy; ";
        // line 12
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, "now", "Y"), "html", null, true);
        echo " - Cupon
                    <a href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("pagina_estatica", array("pagina" => "ayuda")), "html", null, true);
        echo "\">Ayuda</a>
                    <a href=\"";
        // line 14
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("pagina_estatica", array("pagina" => "contacto")), "html", null, true);
        echo "\">Contacto</a>
                    <a href=\"";
        // line 15
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("pagina_estatica", array("pagina" => "privacidad")), "html", null, true);
        echo "\">Privacidad</a>
                    <a href=\"";
        // line 16
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("pagina_estatica", array("pagina" => "sobre-nosotros")), "html", null, true);
        echo "\">Sobre nosotros</a>
                </footer>
            ";
        // line 18
        $this->displayBlock('javascripts', $context, $blocks);
        // line 19
        echo "        </div>
    </body>
</html>
";
    }

    // line 5
    public function block_title($context, array $blocks = array())
    {
    }

    // line 6
    public function block_stylesheets($context, array $blocks = array())
    {
    }

    // line 8
    public function block_id($context, array $blocks = array())
    {
        echo "";
    }

    // line 10
    public function block_body($context, array $blocks = array())
    {
    }

    // line 18
    public function block_javascripts($context, array $blocks = array())
    {
    }

    public function getTemplateName()
    {
        return "::base.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  100 => 18,  89 => 8,  84 => 6,  72 => 19,  70 => 18,  65 => 16,  57 => 14,  53 => 13,  49 => 12,  46 => 11,  36 => 7,  30 => 5,  24 => 1,  90 => 23,  85 => 27,  83 => 26,  79 => 5,  77 => 23,  61 => 15,  58 => 12,  50 => 9,  44 => 10,  40 => 6,  35 => 5,  32 => 4,  140 => 53,  137 => 52,  130 => 48,  122 => 43,  118 => 42,  111 => 37,  104 => 34,  98 => 32,  95 => 10,  93 => 30,  87 => 27,  81 => 24,  74 => 20,  67 => 16,  62 => 16,  55 => 11,  51 => 11,  48 => 10,  45 => 9,  39 => 8,  34 => 6,  31 => 3,);
    }
}
