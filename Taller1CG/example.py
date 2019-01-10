from OpenGL.GL import *
from OpenGL.GLUT import *
from OpenGL.GLU import *

def InitGL(Width, Height):
  glClearColor(0.5, 0.5, 0.5, 0.0)
  glMatrixMode(GL_PROJECTION)

def mostrarEscena():
  glClear(GL_COLOR_BUFFER_BIT)
  
  glBegin(GL_TRIANGLES)
  glColor3f(1, 0.5, 0.7)
  glVertex2f(0.0, 0.25)
  glVertex2f(0.25, -0.25)
  glVertex2f(-0.25, 0.25)
  glEnd()
  
  glutSwapBuffers()

def keyPressed(*args):
  key = args[0]
  if(key == "r" or key == "R"):
    glRotatef(30, 0, 0, 1)

def main():
  global window

  glutInit(sys.argv)
  glutInitDisplayMode(GLUT_SINGLE|GLUT_RGB)
  glutInitWindowSize(500, 500)
  glutInitWindowPosition(200, 200)
  
  window = glutCreateWindow('Prueba')
  
  glutDisplayFunc(mostrarEscena)
  glutIdleFunc(mostrarEscena)
  glutKeyboardFunc(keyPressed)
  InitGL(500, 500)
  glutMainLoop()

if __name__ == "__main__":
  main()