#!/usr/bin/env python
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

class Application(Frame):
	"""docstring for Application"""
	def __init__(self, master=None):
		Frame.__init__(self, master)
		self.grid()
		self.createWidgets()

	def createWidgets(self):
		top=self.winfo_toplevel()
		top.rowconfigure(0, weight=1)
		top.columnconfigure(0, weight=1)
		self.rowconfigure(0, weight=1)
		self.columnconfigure(0, weight=1)
		self.quitButton = Button(self, text='Salir', command=self.ofei)
		self.quitButton.grid(row=0, column=0, sticky=N+S+E+W)

		self.menuBar = Menu(top)
		top['menu'] = self.menuBar

		self.subMenu = Menu(self.menuBar)
		self.menuBar.add_cascade(label='Ayuda', menu=self.subMenu)
		# self.menuBar.add_cascade(label='inicio', menu=self.subMenu)
		# self.menuBar.add_cascade(label='salir', menu=self.subMenu)


		self.subMenu.add_command(label='Acerca de', command=self.imprimir)
		self.subMenu.add_command(label='Informacion', command=self.imprimir)
		self.subMenu.add_command(label='Accesorios', command=self.imprimir)
		self.subMenu.add_command(label='Pagos', command=self.imprimir)
#-----------------------------------------------------------------------------------
		self.mb = Menubutton(self, text="condiments", relief=RAISED)
		self.mb.grid()

		self.mb.menu2 = Menu(self.mb, tearoff=0)
		self.mb['menu'] = self.mb.menu2

		self.mayoVar = IntVar()
		self.ketchVar = IntVar()
		self.mb.menu2.add_checkbutton(label="mayo", variable=self.mayoVar)
		self.mb.menu2.add_checkbutton(label="ketchup", variable=self.ketchVar)

	def imprimir(self):
		print("Se presiono algun menu")

	def ofei(self):
		print("Le has dado a salir")
		print("Adios!")
		self.quit()

app = Application()
app.master.title("Aplicacion de Prueba")
app.master.geometry("700x500")
app.mainloop()
		