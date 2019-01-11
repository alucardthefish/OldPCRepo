<?php

/* BloggerBlogBundle:Blog:show.html.twig */
class __TwigTemplate_faab6ef741828f7ada423718e78a7668 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = $this->env->loadTemplate("BloggerBlogBundle::base.html.twig");

        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'body' => array($this, 'block_body'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "BloggerBlogBundle::base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $this->parent->display($context, array_merge($this->blocks, $blocks));
    }

    // line 5
    public function block_title($context, array $blocks = array())
    {
        echo " ";
        echo twig_escape_filter($this->env, $this->getAttribute($this->getContext($context, "blog"), "title"), "html", null, true);
        echo " ";
    }

    // line 7
    public function block_body($context, array $blocks = array())
    {
        // line 8
        echo "<article class=\"blog\">
    <header>
        <div class=\"date\"><time datetime=\"";
        // line 10
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, $this->getAttribute($this->getContext($context, "blog"), "created"), "c"), "html", null, true);
        echo "\">";
        echo twig_escape_filter($this->env, twig_date_format_filter($this->env, $this->getAttribute($this->getContext($context, "blog"), "created"), "l, F j, Y"), "html", null, true);
        echo "</time></div>
        <h2>";
        // line 11
        echo twig_escape_filter($this->env, $this->getAttribute($this->getContext($context, "blog"), "title"), "html", null, true);
        echo "</h2>
    </header>
    <img src=\"";
        // line 13
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl(twig_join_filter(array(0 => "images/", 1 => $this->getAttribute($this->getContext($context, "blog"), "image")))), "html", null, true);
        echo "\" alt=\"";
        echo twig_escape_filter($this->env, $this->getAttribute($this->getContext($context, "blog"), "title"), "html", null, true);
        echo " image not found\" class=\"large\" />
    <div>
        <p>";
        // line 15
        echo twig_escape_filter($this->env, $this->getAttribute($this->getContext($context, "blog"), "blog"), "html", null, true);
        echo "</p>
    </div>
</article>
<section class=\"comments\" id=\"comments\">
    <section class=\"previous-comments\">
        <h3>Comentarios</h3>
        ";
        // line 21
        $this->env->loadTemplate("BloggerBlogBundle:Comment:index.html.twig")->display(array_merge($context, array("comments" => $this->getContext($context, "comments"))));
        // line 22
        echo "    </section>
</section>
";
    }

    public function getTemplateName()
    {
        return "BloggerBlogBundle:Blog:show.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  71 => 22,  69 => 21,  60 => 15,  53 => 13,  48 => 11,  42 => 10,  38 => 8,  35 => 7,  27 => 5,);
    }
}
