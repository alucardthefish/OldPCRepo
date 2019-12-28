# Taller 2
# Punto 1: Clase servidor (El que corre la simulación)
# Punto 2: Clase data_test_generator (Generador de archivo con configuracion inicial del sistema)

# Integrantes:
# Sergio Ortiz      1526478
# Fabian A. Montaño #######
# Diego A. Borrero  #######

import random

class data_test_generator(object):
    def __init__(self, num_locales, num_parking, num_eventos):
        self.l = abs(num_locales)
        self.p = abs(num_parking)
        self.e = abs(num_eventos)
        
        self.distanceMatrix = [[random.randint(1, 1000) for j in range(num_parking)] for i in range(num_locales)]
    
    def run(self, nombre_archivo):
        f = open(nombre_archivo, "w")
        f.write(str(self.l) + " " + str(self.p) + "\n")
        for i in self.distanceMatrix:
            f.write(" ".join([str(i[j]) for j in range(len(i))]) + "\n")
        
        for i in range(self.e):
            f.write(self.events_generator())
        f.write("END")
        f.close()
    
    def events_generator(self):
        num_locales_visitar = random.randint(1, self.l)
        locales_visitar = random.sample(range(self.l), num_locales_visitar)
        locales_visitar = [str(i) for i in locales_visitar]
        event = str(random.randint(0, 1000000)) +" "+ str(random.randint(1, 1000000)) +" "+ str(num_locales_visitar) +" "+ " ".join(locales_visitar) + "\n"
        return event
    


class servidor(object):

    def __init__(self, k=1):
        self.locales = 0
        self.parqueaderos = 0
        self.k = k
        self.distanceMatrix = []
        self.list_of_events = []
        
        self.numParqueaderosUsados = 0
        
        self.espacios_libres = []
        self.clientes_parqueados = []
    
    def cargar_archivo(self, nombre_archivo):
        file = open(nombre_archivo, "r")
        lineas = file.readlines()
        self.locales, self.parqueaderos = self.cargar_linea(lineas,0)
        self.espacios_libres = range(self.parqueaderos)
        self.clientes_parqueados = [0 for i in range(self.parqueaderos)]
        
        for linea in range(1, self.locales+1):
            self.distanceMatrix.append(self.cargar_linea(lineas, linea))
        
        
        for linea in range(self.locales+1, len(lineas)-1):
            self.list_of_events.append(self.cargar_linea(lineas, linea))
        
        self.list_of_events.sort()

        print "Archivo cargado 100%...\n" + "Sistema compuesto por: parqueaderos: " + str(self.parqueaderos) + " y locales: " + str(self.locales)
    
    def cargar_linea(self, lista, linea):
        return [int(i) for i in lista[linea].split()]
    
    # Pensar en lista_distancias como una lista de listas donde el primer elemento de cada sublista es la suma y el segundo elemento es el indice
    def asignar_espacio(self, evento, estrategia):
        '''Devuelve una lista donde el primer elemento es la distancia minima y el segundo es el estacionamiento'''
        locales = evento[3:]
        lista_distancias = []
        for j in self.espacios_libres:
            val = 0
            for local in locales:
                val += self.distanceMatrix[local][j]
            lista_distancias.append([val, j])   #distancia, espacio del parqueadero
        
        if not estrategia:
            #return lista_distancias.index(min(lista_distancias)) # Estrategia 1
            return min(lista_distancias) # Estrategia 1
        else:
            dist_ordered = lista_distancias
            dist_ordered.sort()
            k_mejores = dist_ordered[:self.k]
            selected = random.sample(k_mejores, 1)
            #return lista_distancias.index(selected)
            return selected[0]
    
    def get_secuencia_eventos(self):
        secuencias = []
        indice = 1
        for evento in self.list_of_events:
            secuencias.append([evento[0], indice, "IN"])
            secuencias.append([evento[0]+evento[1], indice, "OUT"])
            indice += 1
        secuencias.sort()
        return secuencias
    
    def eliminar_evento_sec(self, sec, indice):
        i = 0
        a = 0
        for secuencia in sec:
            if secuencia[1] == indice:
                sec.pop(i)
                a += 1
            i += 1
            if a == 2:
                break
    
    def ocupar_parqueadero(self, numero, clienteId):
        self.espacios_libres.remove(numero)
        self.clientes_parqueados[numero] = clienteId
    
    def liberar_parqueadero(self, numero, clienteId):
        self.espacios_libres.append(numero)
        self.clientes_parqueados[numero] = 0
        
    def execute(self, estrategia):
        secuencias = self.get_secuencia_eventos()
        for secuencia in secuencias:
            
            if len(self.espacios_libres) > 0:
                if secuencia[2] == "IN":
                    espacio = []
                    if len(self.espacios_libres) < self.k or self.parqueaderos < self.k:
                        espacio = self.asignar_espacio(self.list_of_events[secuencia[1]-1], False)
                    else:
                        espacio = self.asignar_espacio(self.list_of_events[secuencia[1]-1], estrategia)
                    print "IN " + str(secuencia[0]) + " " + str(secuencia[1]) + " " + str(espacio[1]) + " " + str(espacio[0]) + "\n"
                    self.ocupar_parqueadero(espacio[1], secuencia[1])
                elif secuencia[2] == "OUT":
                    print "OUT " + str(secuencia[0]) + " " + str(secuencia[1]) + " " + str(self.clientes_parqueados.index(secuencia[1])) + "\n"
                    self.liberar_parqueadero(self.clientes_parqueados.index(secuencia[1]), secuencia[1])
            else:
                if secuencia[2] == "IN":
                    print "UNAVAILABLE\n"
                elif secuencia[2] == "OUT":
                    print "OUT " + str(secuencia[0]) + " " + str(secuencia[1]) + " " + str(self.clientes_parqueados.index(secuencia[1])) + "\n"
                    self.liberar_parqueadero(self.clientes_parqueados.index(secuencia[1]), secuencia[1])

if __name__ == "__main__":
    
    simulation = servidor(2)
    simulation.cargar_archivo("prueba.txt")
    simulation.execute(True)
        