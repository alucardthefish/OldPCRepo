<?php
// src/Blogger/BlogBundle/Form/EnquiryType.php
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
namespace Blogger\BlogBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilder;
use Symfony\Component\Form\FormBuilderInterface;

/**
 * Description of EnquiryType
 *
 * @author Administrador
 */
class EnquiryType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('name');
        $builder->add('email', 'email');
        $builder->add('subject');
        $builder->add('body', 'textarea');
        parent::buildForm($builder, $options);
    }


    
    
    public function getName()
    {
        return 'contact';
    }
}

?>
