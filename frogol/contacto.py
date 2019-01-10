# Calentamiento de programacion orientada a objetos
#
# Represantacion de un contacto de cualquier tipo

class Contacto(object):
	"""Clase que representa un contacto de cualquier
	tipo"""

	nombre_contacto = ""
	apellido_contacto = ""
	tipo = ['telefonico', 'direccion', 'email']
	tipoIndex = 1 # indice por defecto: telefonico
	campoTipo = ""
	descripcion = ""
	
	def __init__(self):
		super(Contacto, self).__init__()

	def setNombre(self, name):
		self.nombre_contacto = name

	def setLastname(self, last):
		self.apellido_contacto = last

	def setTipoIndex(self, tipo):
		self.tipoIndex = tipo

	def setCampoTipo(self, campo):
		self.campoTipo = campo

	def setDescripcion(self, desc):
		self.descripcion = desc

	def showContacto(self):
		msg = "\n-------------CONTACTS-----------------"
		msg += "\nInformation received \n"
		msg += "Name: " + self.nombre_contacto
		msg += "\nLast Name: " + self.apellido_contacto + "\n"
		msg += self.tipo[self.tipoIndex] + ": " + self.campoTipo + "\n"
		msg += "Descripcion: " + self.descripcion + "\n"
		msg += "\n-------------CONTACTS-----------------"
		return msg


