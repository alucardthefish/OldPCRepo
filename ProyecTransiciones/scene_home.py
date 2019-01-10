#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Módulos
import scene
import pygame
from pygame.locals import *
import scene_stage1
import time


# Clases
# ---------------------------------------------------------------------

class SceneHome(scene.Scene):
    """Escena inicial del juego, esta es la primera que se carga cuando inicia"""
    
    def __init__(self, director):
        scene.Scene.__init__(self, director)
        # Cargando las imagenes de la escena inicio
        self.backgroundImage = pygame.image.load('ZeldaImgs/ZeldaLogo.png').convert_alpha()
        self.rescaledBackground = pygame.transform.scale(self.backgroundImage, (640, 480))
        self.fontSuperior = pygame.font.SysFont("Verdana", 24, False, True)
        self.fontInferior = pygame.font.SysFont("comicsansms", 18)

        # Inicializando musica de escena
        pygame.mixer.music.load('ZeldaAudios/title.ogg')
        # Reproducimos la musica
        pygame.mixer.music.play(-1, 0.0)
       
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
                    time.sleep(1)
                    # Reproduciendo la musica del estage 1
                    pygame.mixer.music.load('ZeldaAudios/stage1.ogg')
                    enemies_scene = scene_stage1.SceneStage1(self.director)
                    self.director.change_scene(enemies_scene)
                    pygame.mixer.music.play(-1)


    def on_draw(self, screen):
        screen.fill((255, 255, 255))
        pygame.draw.rect(screen, (0, 50, 5), pygame.Rect(0, 0, self.director.get_width(), self.director.get_height()))
        # Dibujando la imagen de fondo en la pantalla
        screen.blit(self.rescaledBackground, (0, 0))
        # Dibujando los textos complementarios de la pantalla de inicio
        self.drawText('Proyecto Computacion Grafica', self.fontSuperior, screen, (640 / 4)-15, 100, (200, 55, 255))
        self.drawText('Presiona Enter para jugar', self.fontInferior, screen, (640 / 3) - 10, 350, (55, 55, 255))

    def drawText(self, text, font, surface, x, y, color):
        textobj = font.render(text, 1, color)
        textrect = textobj.get_rect()
        textrect.topleft = (x, y)
        surface.blit(textobj, textrect)





