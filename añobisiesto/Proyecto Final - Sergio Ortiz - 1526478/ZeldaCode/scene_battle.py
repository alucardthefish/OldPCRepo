#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Sergio Ortiz Paz
# 1526478

# Módulos
import scene
import scene_game_over
import scene_win
import pygame
from pygame.locals import *
import random
import time


# Clases
# ---------------------------------------------------------------------

class SceneBattle(scene.Scene):
    """Escena de la batalla contra Ganon"""
    
    def __init__(self, director):
        scene.Scene.__init__(self, director)
        # Cargando imagenes a usar
        self.fondo = pygame.image.load("ZeldaImgs/battle1bg.jpg").convert()
        self.fondoajustado = pygame.transform.scale(self.fondo, (640, 480))
        
        self.link = pygame.image.load("ZeldaImgs/LinkBattle.png").convert_alpha()
        self.linkajustado = pygame.transform.scale(self.link, (115+60, 115+60))
        
        self.ganon = pygame.image.load("ZeldaImgs/Ganon_FSA.png").convert_alpha()
        self.ganonajustado = pygame.transform.scale(self.ganon, (186, 156))

        self.btn1 = pygame.image.load("ZeldaImgs/button1.png").convert_alpha()
        self.btn1rect = self.btn1.get_rect(center=(120+30,450))

        self.btn2 = pygame.image.load("ZeldaImgs/button2.png").convert_alpha()
        self.btn2rect = self.btn2.get_rect(center=(200+30,450))

        self.btn3 = pygame.image.load("ZeldaImgs/button3.png").convert_alpha()
        self.btn3rect = self.btn3.get_rect(center=(285+30,450))

        self.btn1rectorig = self.btn1.get_rect(center=(120+30,450))
        self.btn2rectorig = self.btn2.get_rect(center=(200+30,450))
        self.btn3rectorig = self.btn3.get_rect(center=(285+30,450))

        # Constantes
        self.JUGADOR = 1
        self.MAQUINA = 2
        self.SANGREMAQUINA = 150
        self.SANGREJUGADOR = 100
        
        # Dano que causa Link
        self.DAMAGE1 = 15
        self.DAMAGE2 = 25

        # Propiedades
        self.turno = self.JUGADOR

        self.sangre_jugador = self.SANGREJUGADOR
        self.sangre_maquina = self.SANGREMAQUINA

        # Variable de estado del juego
        self.juego_activo = True

        # Diccionario de ataques de Ganon
        self.ataques = {'ataque1': 15, 'ataque2': 20, 'noataque': 0}
       
    def on_update(self):
        if not self.juego_activo:
            if self.sangre_jugador > 0:
                print("Victory")
                win = scene_win.SceneWin(self.director)
                pygame.mixer.music.stop()
                win.playSound()
                self.turno = self.JUGADOR
                time.sleep(1)
                self.director.change_scene(win)
            else:
                print("GameOver")
                loose = scene_game_over.SceneGameOver(self.director)
                pygame.mixer.music.stop()
                loose.playSound()
                time.sleep(1)
                self.director.change_scene(loose)

        if self.turno == self.MAQUINA:
            pygame.mouse.set_visible(False)
            self.maquina_ataca()
        else:
            pygame.mouse.set_visible(True)

    def on_event(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                self.director.quit()
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_ESCAPE:
                    self.director.quit()

            if self.turno == self.JUGADOR:
                if event.type == pygame.MOUSEBUTTONDOWN and event.button == 1:
                    click_pos = pygame.mouse.get_pos()
                    self.juagador_ataca(click_pos)

    def on_draw(self, screen):
        screen.fill((255, 255, 255))
        # Dibujando la imagen de fondo en la pantalla
        screen.blit(self.fondoajustado, (0, 0))

        # Dibujando la imagen de link en la pantalla
        screen.blit(self.linkajustado, (0, 360-40))

        # Dibujando la imagen de Ganon en pantalla
        screen.blit(self.ganonajustado, (449, 0))

        if self.turno == self.JUGADOR:
            self.btn1rect = screen.blit(self.btn1, self.btn1rectorig)
            self.btn2rect = screen.blit(self.btn2, self.btn2rectorig)
            self.btn3rect = screen.blit(self.btn3, self.btn3rectorig)
        else:
            self.btn1rect = screen.blit(self.btn1, (700, 600))
            self.btn2rect = screen.blit(self.btn2, (700, 600))
            self.btn3rect = screen.blit(self.btn3, (700, 600))

        # Contenedor vacio de sangre Maquina
        pygame.draw.rect(screen, (0, 0, 0), pygame.Rect(143, 10, self.SANGREMAQUINA * 2, 20))
        pygame.draw.rect(screen, (0, 255, 0), pygame.Rect(143, 10, self.sangre_maquina * 2, 20))
        self.drawText("Ganon: "+str((self.sangre_maquina*2)/3)+"%", pygame.font.SysFont("comicsansms", 18), screen, 145, 30, (255, 0, 0))

        # Contenedor vacio de sangre jugador
        pygame.draw.rect(screen, (0, 0, 0), pygame.Rect(113, 330, self.SANGREJUGADOR * 3, 20))
        pygame.draw.rect(screen, (0, 255, 0), pygame.Rect(113, 330, self.sangre_jugador * 3, 20))
        self.drawText("Link: "+str(self.sangre_jugador)+"%", pygame.font.SysFont("comicsansms", 18), screen, 120, 350, (255, 0, 0))

        # Indicador de turno
        oponente = ""
        if self.turno == self.JUGADOR:
            oponente = "Link"
        else:
            oponente = "Ganon"
        self.drawText("Ataca: "+oponente, pygame.font.SysFont("Verdana", 18), screen, self.director.get_width()-150, self.director.get_height()-20, (255, 34, 129))

    def juagador_ataca(self, pos):
        if self.btn1rect.collidepoint(pos):
            print("ATAQUE 1")
            self.apply_damage(self.DAMAGE1)
        elif self.btn2rect.collidepoint(pos):
            print("ATAQUE 2")
            self.apply_damage(self.DAMAGE2)
        elif self.btn3rect.collidepoint(pos):
            print("CEDIO TURNO")
            self.apply_damage(0)

    def apply_damage(self, valor):
        '''Resta a la sangre de Ganon el valor de daño'''
        self.sangre_maquina -= valor
        if valor != 0:
            painsoundganon = pygame.mixer.Sound("ZeldaAudios/ganonpain2.ogg")
            painsoundganon.play()
        if self.sangre_maquina <= 0:
            self.sangre_maquina = 0
            self.juego_activo = False
        self.turno = self.MAQUINA


    def maquina_ataca(self):
        '''Metodo que aplica el daño aleatorio a la sangre del jugador'''
        print("Juega la maquina")
        ataque = random.choice(list(self.ataques.keys()))
        time.sleep(3)
        if ataque != 'noataque':
            self.sangre_jugador -= self.ataques[ataque]
            #sonido de dolor de link
            painsoundlink = pygame.mixer.Sound("ZeldaAudios/linkoof2.ogg")
            painsoundlink.play()
            if self.sangre_jugador <= 0:
                self.sangre_jugador = 0
                self.juego_activo = False
        self.turno = self.JUGADOR

    def drawText(self, text, font, surface, x, y, color):
        '''Metodo para dibujar texto en la pantalla'''
        textobj = font.render(text, 1, color)
        textrect = textobj.get_rect()
        textrect.topleft = (x, y)
        surface.blit(textobj, textrect)


