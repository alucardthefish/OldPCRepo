#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Módulos
import scene
import pygame
import time
from pygame.locals import *
import scene_battle

# Clases
# ---------------------------------------------------------------------

class SceneGanon(scene.Scene):
    """Escena de encuentro con Ganon"""
    
    def __init__(self, director):
        scene.Scene.__init__(self, director)
        # Carga de imagenes a usar
        self.bgImage = pygame.image.load('ZeldaImgs/Scene2Bground1.png').convert()
        self.link = pygame.image.load("ZeldaImgs/linkback.gif").convert_alpha()
        self.ganon = pygame.image.load("ZeldaImgs/GanonALttPTrident.png").convert_alpha()

        # Posicion de link en escena, coordenadas X,Y
        self.link_pos_x = 323
        self.link_pos_y = 420

        # Objeto rect del personaje Link y Ganon
        self.linkRect = self.link.get_rect(center=(self.link_pos_x, self.link_pos_y))
        
        self.ganonRect = self.ganon.get_rect(center=(self.director.get_width()/2 + 25, self.director.get_height()/2 - 100))
       
    def on_update(self):
        if self.linkRect.colliderect(self.ganonRect):
            print("Tocaste a ganon, lo has retado a duelo")
            self.reproducir_musica()
            batalla_scene = scene_battle.SceneBattle(self.director)
            self.director.change_scene(batalla_scene)

    def on_event(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                self.director.quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    self.director.quit()
            if event.type == pygame.MOUSEBUTTONDOWN:
                if event.button == 1:
                    coord_raton = pygame.mouse.get_pos()
                    if self.ganonRect.collidepoint(coord_raton):
                        self.reproducir_musica()
                        batalla_scene = scene_battle.SceneBattle(self.director)
                        self.director.change_scene(batalla_scene)

        pressed = pygame.key.get_pressed()
        if pressed[pygame.K_UP] and self.link_pos_y > 15:
            self.link_pos_y -= 2
        if pressed[pygame.K_DOWN] and self.link_pos_y < self.director.get_height() - 60:
            self.link_pos_y += 2
        if pressed[pygame.K_LEFT] and self.link_pos_x > 25:
            self.link_pos_x -= 2
        if pressed[pygame.K_RIGHT] and self.link_pos_x < self.director.get_width() - 51:
            self.link_pos_x += 2

    def on_draw(self, screen):
        screen.fill((255, 255, 255))
        screen.blit(self.bgImage, (0, 0))

        # Dibujando a Ganon
        screen.blit(self.ganon, self.ganonRect)

        # Dibujando a link en la escena
        self.linkRect = screen.blit(self.link, (self.link_pos_x, self.link_pos_y))

    def reproducir_musica(self):
        pygame.mixer.music.stop()
        time.sleep(1)
        # Reproduciendo la musica del estage 1
        pygame.mixer.music.load('ZeldaAudios/battleganon.ogg')
        pygame.mixer.music.play(-1)




