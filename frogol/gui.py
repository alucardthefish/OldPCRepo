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

lista = []

def guardar():
	n = nombre.get()
	ap = app.get()
	am = apm.get()
	c = correo.get()
	t = telefono.get()
	lista.append(n+"$"+ap+"$"+am+"$"+t+"$"+c)
	escribirContacto()
	if version[0]==2:
		showinfo("Guardado", "El contacto ha sido guardado en la agenda")
	else:
		messagebox.showinfo("Guardado", "El contacto ha sido guardado en la agenda")
	limpiarCampos()
	consultar()

def eliminar():
	eliminado = conteliminar.get()
	removido = False
	for elemento in lista:
		arreglo = elemento.split("$")
		if eliminado == arreglo[4]:
			lista.remove(elemento)
			removido = True
	escribirContacto()
	consultar()
	if removido:
		if version[0]==2:
			showinfo("Eliminar", "Elemento eliminado: " + eliminado)
	else:
		messagebox.showinfo("Eliminar", "Elemento eliminado: " + eliminado)

def consultar():

	r = Text(ventana, width=80, height=15)
	
	lista.sort()
	valores = []
	r.insert(INSERT, "Nombre\t\tApellido Paterno\t\tApellido Materno\t\tTelefono\t\tCorreo\n")
	for elemento in lista:
		arreglo = elemento.split("$")
		valores.append(arreglo[4])
		#r.insert(INSERT, arreglo[0]+"\t\t"+arreglo[1]+"\t\t"+arreglo[2]+"\t\t"+arreglo[3]+"\t\t"+arreglo[4]+"\t\n")
		r.insert(INSERT, arreglo[0]+"\t\t"+arreglo[1]+"\t\t"+arreglo[2]+"\t\t"+arreglo[3]+"\t\t"+arreglo[4]+"\t\n")
		spinTelefono = Spinbox(ventana, value=(valores), textvariable=conteliminar).place(x=450, y=50)
		if lista==[]:
			spinTelefono = Spinbox(ventana, value=(valores)).place(x=450, y=50)
			r.config(state=DISABLED)
	r.config(state=DISABLED)
	r.place(x=20, y=230)

def limpiarCampos():
	nombre.set("")
	app.set("")
	apm.set("")
	correo.set("")
	telefono.set("")

def iniciarArchivo():
	archivo = open("ag.txt", "a")
	archivo.close()

def cargar():
	archivo = open("ag.txt", "r")
	
	print ("kdjoooooooooooooo")
	linea = archivo.readline()
	if linea:
		while linea:
			if linea[-1] == '\n':
				linea = linea[:-1]
			lista.append(linea)
			linea = archivo.readline()
	archivo.close()


def escribirContacto():
	archivo = open("ag.txt", "w")
	lista.sort()
	for elemento in lista:
		archivo.write(elemento+"\n")
	archivo.close()


ventana = Tk()
nombre = StringVar()
app = StringVar()
apm = StringVar()
correo = StringVar()
telefono = StringVar()
conteliminar = StringVar()
colorFondo = "#006"
colorLetra = "#FFF"
ventana.title("Agenda con archivos")
ventana.geometry("700x500")
ventana.configure(background=colorFondo)

etiquetaTitulo = Label(ventana, text="Agenda con archivos", bg=colorFondo, fg=colorLetra, font=("Helvetica", 16)).place(x=230, y=10)

etiquetaN = Label(ventana, text="Nombre", bg=colorFondo, fg=colorLetra).place(x=50, y=50)
cajaN = Entry(ventana, textvariable=nombre).place(x=150, y=50)

etiquetaN2 = Label(ventana, text="Apellido paterno", bg=colorFondo, fg=colorLetra).place(x=50, y=75)
cajaN2 = Entry(ventana, textvariable=app).place(x=150, y=75)

etiquetaN3 = Label(ventana, text="Apellido materno", bg=colorFondo, fg=colorLetra).place(x=50, y=100)
cajaN3 = Entry(ventana, textvariable=apm).place(x=150, y=100)

etiquetaN4 = Label(ventana, text="Correo", bg=colorFondo, fg=colorLetra).place(x=50, y=125)
cajaN4 = Entry(ventana, textvariable=correo).place(x=150, y=125)

etiquetaN5 = Label(ventana, text="Telefono", bg=colorFondo, fg=colorLetra).place(x=50, y=150)
cajaN5 = Entry(ventana, textvariable=telefono).place(x=150, y=150)

etiquetaEliminar = Label(ventana, text="Telefono: ", bg=colorFondo, fg=colorLetra).place(x=370, y=50)
spinTelefono = Spinbox(ventana, textvariable=conteliminar).place(x=450, y=50)

botonGuardar = Button(ventana, text="Guardar", command=guardar, bg="#009", fg="white").place(x=189, y=200)

botonEliminar = Button(ventana, text="Eliminar", command=eliminar, bg="#009", fg="white").place(x=470, y=80)

iniciarArchivo()
cargar()
consultar()

mainloop()

