from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *
import random

def InitGL(Width, Height):
  glClearColor(0.5, 0.5, 0.5, 0.0)
  glMatrixMode(GL_PROJECTION)
  glColor3f(0.0, 255.0, 255.0)

def mostrarEscena():
  glClear(GL_COLOR_BUFFER_BIT)
  glMatrixMode(GL_MODELVIEW);
  
  glLoadIdentity()
  
  glRotatef(20,1.0,0.0,0.0)
  glRotatef(10,1.0,1.0,0.0)
  glRotatef(0,1.0,0.0,1.0)
  
  glutWireCube(0.5);

  glFlush();

def keyPressed(*args):
  key = args[0]
  if(key == "r" or key == "R"):
    glColor3f(1.0, 0.0, 0.0)
  elif(key == "g" or key == "G"):
    glColor3f(0.0, 1.0, 0.0)
  elif(key == "b" or key == "B"):
    glColor3f(0.0, 0.0, 1.0)
  mostrarEscena()

def randomColor():
  glColor3f(random.uniform(0.0, 1.0), random.uniform(0.0, 1.0), random.uniform(0.0, 1.0))    

def clickPressed(btn, state, x, y):
  if(btn == GLUT_LEFT_BUTTON and state == GLUT_DOWN):
    randomColor()
    

def main():
  global window

  glutInit(sys.argv)
  glutInitDisplayMode(GLUT_SINGLE|GLUT_RGB)
  glutInitWindowSize(500, 500)
  glutInitWindowPosition(200, 200)
  
  window = glutCreateWindow('Punto 3-A Cubo')
  
  glutDisplayFunc(mostrarEscena)
  glutIdleFunc(mostrarEscena)
  glutKeyboardFunc(keyPressed)
  glutMouseFunc(clickPressed)
  InitGL(500, 500)
  glutMainLoop()

if __name__ == "__main__":
  main()