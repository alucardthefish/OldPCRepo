##Calentando con una programadita en python
from contacto import Contacto

flag = False

selection = "name" # Default selection is 'name'

# Instancia del objeto Contacto
contacto = Contacto()

# Programa sencillo que simplemente muestra la interactividad con el usuario por consola
def runner():
	'''
	Function which executes the program always
	'''

	print("Welcome to my warm-up program")
	print("Please tell me your name")
	user_name = raw_input("type your name: ")

	


	#print("La longitud de la cadena ingresada por nombre es: " + str(len(user_name)))

	while flag == False:
		# Opciones de flujo
		opciones = {
			"name" : actioner,
			"last" : actioner,
			"index" : actioner,
			"field" : actioner,
			"description" : actioner
		}
		opciones[selection]()


	# print("Bye!! have fun!")
	print(contacto.showContacto())



def validateLength(input):
	if len(input) == 0:
		return False
	else:
		return True

def validIndex(input):
	if input >= 0 and input < 3:
		return True
	return False

def actioner():
	global selection, contacto, flag
	msg = ""
	userInput = ""
	if selection == "name":
		msg = "Type the contact's name: "
		userInput = raw_input(msg)
		if validateLength(userInput):
			contacto.setNombre(userInput)
			selection = "last"
	elif selection == "last":
		msg = "Type the lastname of your contact: "
		userInput = raw_input(msg)
		if validateLength(userInput):
			contacto.setLastname(userInput)
			selection = "index"
	elif selection == "index":
		msg = "Enter type  of contact:\n"
		msg += "0) Telephone\n"
		msg += "1) Address\n"
		msg += "2) Email\n"
		userInput = raw_input(msg)
		if validateLength(userInput) and validIndex(int(userInput)):
			contacto.setTipoIndex(int(userInput))
			selection = "field"
	elif selection == "field":
		msg = "Type the data of your contact: "
		userInput = raw_input(msg)
		if validateLength(userInput):
			contacto.setCampoTipo(userInput)
			selection = "description"
	else:
		msg = "Enter any description which help you understand better the context of your contact: "
		userInput = raw_input(msg)
		if validateLength(userInput):
			contacto.setDescripcion(userInput)
			flag = True






def main():
	runner()



if __name__ == "__main__":
  main()


