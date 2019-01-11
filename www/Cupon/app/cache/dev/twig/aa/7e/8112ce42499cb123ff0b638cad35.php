<?php

/* ::frontend.html.twig */
class __TwigTemplate_aa7e8112ce42499cb123ff0b638cad35 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = $this->env->loadTemplate("::base.html.twig");

        $this->blocks = array(
            'stylesheets' => array($this, 'block_stylesheets'),
            'javascripts' => array($this, 'block_javascripts'),
            'body' => array($this, 'block_body'),
            'article' => array($this, 'block_article'),
            'aside' => array($this, 'block_aside'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "::base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $this->parent->display($context, array_merge($this->blocks, $blocks));
    }

    // line 4
    public function block_stylesheets($context, array $blocks = array())
    {
        // line 5
        echo "<link href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("bundles/oferta/css/normalizar.css"), "html", null, true);
        echo "\" rel=\"stylesheet\" type=\"text/css\" />
<link href=\"";
        // line 6
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("bundles/oferta/css/comun.css"), "html", null, true);
        echo "\" rel=\"stylesheet\" type=\"text/css\" />
<link href=\"";
        // line 7
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("bundles/oferta/css/frontend.css"), "html", null, true);
        echo "\" rel=\"stylesheet\" type=\"text/css\" />
";
    }

    // line 9
    public function block_javascripts($context, array $blocks = array())
    {
    }

    // line 11
    public function block_body($context, array $blocks = array())
    {
        // line 12
        echo "<header>
    <h1><a href=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("portada"), "html", null, true);
        echo "\">Cupon</a></h1>
    <nav>
        <ul>
            <li><a href=\"";
        // line 16
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("portada"), "html", null, true);
        echo "\">Oferta del día</a></li>
            <li><a href=\"#\">Ofertas recientes</a></li>
            <li><a href=\"#\">Mis ofertas</a></li>
        </ul>
    </nav>
</header>
<article>
    ";
        // line 23
        $this->displayBlock('article', $context, $blocks);
        // line 24
        echo "</article>
<aside>
    ";
        // line 26
        $this->displayBlock('aside', $context, $blocks);
        // line 27
        echo "</aside>
";
    }

    // line 23
    public function block_article($context, array $blocks = array())
    {
    }

    // line 26
    public function block_aside($context, array $blocks = array())
    {
    }

    public function getTemplateName()
    {
        return "::frontend.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  90 => 23,  85 => 27,  83 => 26,  79 => 24,  77 => 23,  61 => 13,  58 => 12,  50 => 9,  44 => 7,  40 => 6,  35 => 5,  32 => 4,  140 => 53,  137 => 52,  130 => 48,  122 => 43,  118 => 42,  111 => 37,  104 => 34,  98 => 32,  95 => 26,  93 => 30,  87 => 27,  81 => 24,  74 => 20,  67 => 16,  62 => 16,  55 => 11,  51 => 11,  48 => 10,  45 => 9,  39 => 7,  34 => 4,  31 => 3,);
    }
}
