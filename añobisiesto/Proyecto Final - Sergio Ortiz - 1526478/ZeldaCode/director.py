# -*- encoding: utf-8 -*-

# Sergio Ortiz Paz
# 1526478

# Módulos
import pygame
import sys

class Director:
    """Representa el objeto principal del juego.

    El objeto Director mantiene en funcionamiento el juego, se
    encarga de actualizar, dibuja y propagar eventos.

    Tiene que utilizar este objeto en conjunto con objetos
    derivados de Scene."""

    def __init__(self, width, height):
        self.width = width
        self.height = height
        # Cargando icono del juego
        self.icon = pygame.image.load("ZeldaImgs/zeldaicon.jpg")
        pygame.display.set_icon(self.icon)
        #Iniciando la pantalla
        self.screen = pygame.display.set_mode((width, height))
        pygame.display.set_caption("The Legend of Zelda")
        self.scene = None
        self.fullscreen = False
        self.quit_flag = False
        self.clock = pygame.time.Clock()

    def loop(self):
        "Bucle principal del juego."

        while not self.quit_flag:
            time = self.clock.tick(60)
            
            # Eventos de Salida
            self.scene.on_update()

            # detecta eventos
            self.scene.on_event()

            # actualiza la escena
            #self.scene.on_update()

            # dibuja la pantalla
            self.scene.on_draw(self.screen)
            pygame.display.flip()

    def change_scene(self, scene):
        "Altera la escena actual."
        self.scene = scene

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def quit(self):
        self.quit_flag = True
