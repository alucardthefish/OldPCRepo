#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Módulos
import scene
import pygame
from pygame.locals import *
import scene_home

# Clases
# ---------------------------------------------------------------------

class SceneWin(scene.Scene):
    """Escena De Victoria"""
    
    def __init__(self, director):
        scene.Scene.__init__(self, director)
        # Cargando las imagenes de la escena inicio
        self.backgroundImage = pygame.image.load('ZeldaImgs/zeldalogo2.jpg').convert()
        # Inicializamos escena inicial, por si se quiere jugar nuevamente
        self.home_scene = scene_home.SceneHome(self.director)

        # Inicializamos sonido de escena
        self.winSound = pygame.mixer.Sound('ZeldaAudios/victory.ogg')
       
    def on_update(self):
        pass

    def on_event(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                self.director.quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    self.director.quit()
            if event.type == pygame.KEYUP:
                if event.key == pygame.K_RETURN:
                    pygame.mixer.music.stop()
                    self.winSound.stop()
                    pygame.mixer.music.load('ZeldaAudios/title.ogg')
                    pygame.mixer.music.play(-1)
                    self.director.change_scene(self.home_scene)

    def on_draw(self, screen):
        screen.fill((255, 255, 255))
        # Dibujando la imagen de fondo en la pantalla
        screen.blit(self.backgroundImage, (0, 0))

        self.drawText("Ganaste, Ganon ha caido", pygame.font.SysFont("comicsansms", 28), screen, 180, 40, (230, 192, 23))
        self.drawText("Presiona Enter para volver al inicio", pygame.font.SysFont("comicsansms", 18), screen, 180, 400, (230, 142, 23))

    def drawText(self, text, font, surface, x, y, color):
        textobj = font.render(text, 1, color)
        textrect = textobj.get_rect()
        textrect.topleft = (x, y)
        surface.blit(textobj, textrect)

    def playSound(self):
        self.winSound.play()

# ---------------------------------------------------------------------

# Funciones
# ---------------------------------------------------------------------



# ---------------------------------------------------------------------


