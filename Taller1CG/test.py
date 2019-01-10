################################################################################
######### IMPORT DE LIBRERIAS Y FUNCIONES #########
################################################################################

# importamos cosas de pygame
import pygame
from pygame.locals import *

# importamos cosas de OpenGL
from OpenGL.GL import *
from OpenGL.GLU import *

################################################################################
######### METODOS PARA INICIAR PYGAME Y OPENGL #########
################################################################################
def init_pygame((w,h), title=""):
	pygame.init()
	pygame.display.set_mode((w,h), OPENGL | DOUBLEBUF)
	pygame.display.set_caption(title)
# END INIT_PYGAME

def init():
	glClearColor(0.0, 0.0, 0.0, 0.0)
	glClearDepth(1.0)
	glDisable(GL_DEPTH_TEST)
	glShadeModel(GL_SMOOTH)
	glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST)
	glEnable (GL_BLEND)
	glBlendFunc (GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
	glHint (GL_LINE_SMOOTH_HINT, GL_NICEST)
# END INIT

def reshape((width, height)):
	if height == 0:
		height = 1
	glMatrixMode(GL_PROJECTION)
	glLoadIdentity()
	gluOrtho2D(0.0, width, 0.0, height);
	glMatrixMode(GL_MODELVIEW)
	glLoadIdentity()
# END RESHAPE

def init_opengl((w,h)):
# INICIAMOS LA SUPERFICIE OPENGL Y LA CONFIGURAMOS
	reshape((w,h))
	init()
# END INIT_OPENGL

################################################################################
######### CON ESTE METODO DIBUJAREMOS LOS ELEMENTOS #########
################################################################################
def display():
	glClear(GL_COLOR_BUFFER_BIT)
# AQUI EJECUTAMOS COMANDOS OPENGL PARA DIBUJAR
	glBegin(GL_TRIANGLES)
	glColor4f(1.0, .0 , .0 , .0)
	glVertex2d(100, 100)
	glColor4f(.0, 1.0 , .0 , 1.0)
	glVertex2d(700, 100)
	glColor4f(.0, .0 , 1.0 , 1.0)
	glVertex2d(400, 500)
	glEnd()
# END DISPLAY

################################################################################
######### ESTE ES NUESTRO METODO PRINCIPAL #########
################################################################################
def main((w,h)):
# GENERAMOS LA VENTANA DE PYGAME
	init_pygame((w,h), "Test PyGame / OpenGL")
# INCIAMOS OPENGL
	init_opengl((w,h))

# DISPLAYLISTS. LOS DEJAMOS GLOBALES PARA QUE ESTEN DISPONIBLES EN DISPLAY
	continuar = True
	while continuar:
# 1: MANEJAMOS EVENTOS DE ENTRADA (TECLADO, MOUSE, ETC.)
		for event in pygame.event.get():
			if event.type == QUIT:
				continuar = False
			if event.type == KEYDOWN:
				if event.key == K_ESCAPE:
					continuar = False

# 2: EJECUTAMOS LOGICA DE LA APLICACION PARA UN SIGUIENTE ESTADO

# 3: DIBUJAMOS LOS ELEMENTOS
	display()
	pygame.display.flip()
# END MAIN

################################################################################
######### TAMBIEN PODEMOS HACER FUNCIONES PARA TENER #########
######### UN CODIGO MAS ORDENADO #########
################################################################################

################################################################################
######### EJECUTAMOS EL METODO PRINCIPAL #########
################################################################################
if __name__ == "__main__" :
	main ((800,600))