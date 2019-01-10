##Interfaz grafica
import sys

version = sys.version_info

if version[0] < 3:
	from Tkinter import *
	from tkMessageBox import *
	print("Version 2")
else:
	from tkinter import *
	from tkinter import messagebox
	print("Version 3")


ventana = Tk()
nombre = StringVar()
app = StringVar()
apm = StringVar()
correo = StringVar()
telefono = StringVar()
conteliminar = StringVar()
ventana.title("Optimizacion Cultivo de Papa")
ventana.geometry("700x500")
#ventana.configure(background=colorFondo)

mainloop()