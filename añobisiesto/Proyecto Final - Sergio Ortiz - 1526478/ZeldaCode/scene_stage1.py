#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Sergio Ortiz Paz
# 1526478

# Módulos
import scene
import pygame
import time
from pygame.locals import *
import scene_game_over
import scene_ganon

class SceneStage1(scene.Scene):
	"""Escena inicial del juego."""
	def __init__(self, director):
		scene.Scene.__init__(self, director)
		# Posicion de link en escena, coordenadas X,Y
		self.link_pos_x = 345
		self.link_pos_y = 420

		# Variable Flag que representa si la puerta para enfrentar a Ganon esta abierta
		self.pasar_nivel = False
		# Objeto Rect de la puerta
		self.puerta_rect = pygame.Rect(345, 20, 25, 25)
		
		# Carga de imagenes a usar
		self.backgroundImage = pygame.image.load('ZeldaImgs/Scene1Bground3.png').convert()
		self.link = pygame.image.load("ZeldaImgs/linkback.gif").convert_alpha()
		self.oct1 = pygame.image.load("ZeldaImgs/OctorokRed.gif").convert_alpha()
		self.oct2 = pygame.image.load("ZeldaImgs/OctorokBlue.gif").convert_alpha()
		self.mobl = pygame.image.load("ZeldaImgs/MoblinBlackFront.gif").convert_alpha()

		# Creando diccionario de enemigos
		enemigo1 = {'surface': self.oct1, 'rect': self.oct1.get_rect(center=(250, 60))}
		enemigo2 = {'surface': self.oct2, 'rect': self.oct2.get_rect(center=(300, 120))}
		enemigo3 = {'surface': self.oct1, 'rect': self.oct1.get_rect(center=(450, 60))}
		enemigo4 = {'surface': self.oct2, 'rect': self.oct2.get_rect(center=(400, 120))}
		enemigo5 = {'surface': self.mobl, 'rect': self.mobl.get_rect(center=(350, 190))}

		# Arreglo que contendra los enemigos en pantalla
		self.enemigosArray = [enemigo1, enemigo2, enemigo3, enemigo4, enemigo5]

		# Objeto rect del personaje Link
		self.linkRect = self.link.get_rect(center=(self.link_pos_x, self.link_pos_y))

		

	def fueAtacadoLink(self, enemigos):
		'''Metodo que devuelve True si el personaje Link colisiona contendra
		alguno de los enemigos de la escena'''
		for enemyRect in self.enemigosArray:
			if self.linkRect.colliderect(enemyRect['rect']):
				return True
		return False

	def on_update(self):
		if self.fueAtacadoLink(self.enemigosArray):
			print("Toco Enemigo, Link muere")
			# Inicializamos escena de Game Over, en el caso de que toque un enemigo
			gameover_scene = scene_game_over.SceneGameOver(self.director)
			pygame.mixer.music.stop()
			gameover_scene.playSound()
			time.sleep(1)
			#Colocar cambio de escena de Game Over
			self.director.change_scene(gameover_scene)

		if len(self.enemigosArray) == 0 and self.linkRect.colliderect(self.puerta_rect):
			print("Pasas a enfrentar Ganon")
			# Inicializamos escena de ganon
			the_ganon_scene = scene_ganon.SceneGanon(self.director)
			#Colocar cambio de escena a Ganon
			self.director.change_scene(the_ganon_scene)

	def on_event(self):
		for event in pygame.event.get():
			if event.type == pygame.QUIT:
				self.director.quit()
			if event.type == pygame.KEYDOWN:
				if event.key == pygame.K_ESCAPE:
					self.director.quit()
			if event.type == pygame.MOUSEBUTTONDOWN:
				if event.button == 1:
					punto_ataque = pygame.mouse.get_pos()
					self.golpear_enemigo(self.enemigosArray, punto_ataque)

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
		screen.blit(self.backgroundImage, (0, 0))
		
		# Dibujando los enemigos en la escena
		for enemies in self.enemigosArray:
			screen.blit(enemies['surface'], enemies['rect'])

		# Dibujando a link en la escena
		self.linkRect = screen.blit(self.link, (self.link_pos_x, self.link_pos_y))

	def drawText(self, text, font, surface, x, y):
		textobj = font.render(text, 1, (55, 55, 255))
		textrect = textobj.get_rect()
		textrect.topleft = (x, y)
		surface.blit(textobj, textrect)

	def golpear_enemigo(self, enemigos, pos_golpe):
		'''Metodo que elimina un enemigo del arreglo de enemigos si la posicion del 
		mouse al momento de hacer click esta dentro de dicho enemigo'''
		for enemigo in enemigos:
			if enemigo['rect'].collidepoint(pos_golpe):
				# Inicializamos sonido de escena
				dyingSound = pygame.mixer.Sound('ZeldaAudios/hithurtenemies.ogg')
				dyingSound.play()
				enemigos.remove(enemigo)
		