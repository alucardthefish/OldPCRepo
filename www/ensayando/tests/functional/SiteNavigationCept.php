<?php
$I = new TestGuy($scenario);
$I->wantTo('ensure we can visit the about page from the home page');
$I->amOnPage('index.html');
$I->click('About');
$I->see('About Functional Test', 'h1');
