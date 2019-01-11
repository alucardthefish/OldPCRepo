<?php
$I = new TestGuy($scenario);
$I->wantTo('asegurarme que se puede acceder a la pagina de developer desde pagina de inicio');
$I->amOnPage('index.html');
$I->click('Developer');
$I->see('Hola soy el developer de esta pagina', 'h2');
