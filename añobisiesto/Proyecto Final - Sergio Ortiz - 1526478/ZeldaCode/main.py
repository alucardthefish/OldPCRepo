#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Módulos
import pygame
import director
import scene_home
import scene_stage1
import time

def main():
    dir = director.Director(640, 480)
    scene = scene_home.SceneHome(dir)
    dir.change_scene(scene)
    dir.loop()

if __name__ == '__main__':
	pygame.init()
	main()

