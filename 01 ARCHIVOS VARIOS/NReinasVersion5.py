# Sergio Ortiz Paz - 1526478

import random

class Maestro:
    
    def __init__(self):
        pass
    
    def checkDiagonal(self, col, lista, n, tipo=135):
        '''Verifica si la diagonal 45 o 135 de una columna no tiene reinas atacando
        
        Devuelve una variable booleana indicando True si la diagonal esta
        libre y False si la diagonal esta siendo atacada por otra reina
        
        Parametros:
        col: columna a verificar
        lista: lista de numeros de columnas donde cada posicion determina la fila del tablero de ajedrez
        n: dimension del tablero
        tipo: especifica que diagonal verificar. La diagonal 135 esta por default sino es especificada (la diagonal
        esta determinada como en un plano cartesiano no como en las diapositivas de clase. Es decir invertidas)
        
        '''
        sublista = []
        if tipo == 135:
            x = col - 1
            if len(lista) >= col:
                sublista = reversed(lista[-x:])
            else:
                sublista = reversed(lista)
            for i in sublista:
                if i == x:
                    return False
                else:
                    x = x - 1
            return True
        else:
            x = col + 1
            rango = n - col
            if rango <= len(lista):
                sublista = reversed(lista[-rango:])
            else:
                sublista = reversed(lista)
            
            for i in sublista:
                if i == x:
                    return False
                else:
                    x = x + 1
            return True
    
    def validar(self, col, solucion, n):
        '''Valida la posicion de una reina de acuerdo a como va el tablero solucion hasta el momento
        
        Devuelve True si la posicion no esta siendo atacada por ninguna reina
        
        Parametros:
        col: columna a verificar
        solucion: lista de numeros de columnas donde cada posicion determina la fila del tablero de ajedrez
        n: dimension del tablero, solo para tableros de dimensiones mayores a 3 hay solucion
        
        '''
        if len(solucion) == 0:
            return True
        if col in solucion:
            return False
        diag135 = self.checkDiagonal(col, solucion, n)
        diag45 = self.checkDiagonal(col, solucion, n, 45)
        return diag135 and diag45
    
    def columnasValidas(self, solucion, n):
        validas = []
        for col in range(1, n+1):
            if self.validar(col, solucion, n):
                validas.append(col)
        return validas
    
    def nReinasLasVegas(self, n):
        '''Busca aleatoriamente una solucion en un tablero n x n
        
        Devuelve una lista donde el primer elemento es una variable booleana que denota con True
        si hubo exito encontrando la solucion o False en caso contrario. El segundo elemento de la
        lista es la solucion parcial encontrada antes de fallar o toda la solucion en el caso de exito.
        El tercer elmento representa la unidad de tiempo como iteracion del programa
        
        Parametros:
        n: dimension del tablero, solo para tableros de dimensiones mayores a 3 hay solucion
        
        '''
        listaResultado = []
        listaCols = range(1, n+1)
        columnaInicial = random.sample(listaCols, 1)[0]
        listaResultado.append(columnaInicial)
        t = 1
        for i in range(n-1):
            posicionesValidas = self.columnasValidas(listaResultado, n)
            if len(posicionesValidas) != 0:
                aleatorio = random.sample(posicionesValidas, 1)[0]
                listaResultado.append(aleatorio)
            else:
                return False, listaResultado, t
            t = t + 1
        
        return True, listaResultado, t
    
    
    def nReinasLVSolver(self, n):
        '''Repite el algoritmo de las vegas nReinasLasVegas hasta encontrar solucion
        
        Devuelve una lista done el primer elemento es una lista almacenando la solucion al tablero de n reinas. Donde cada
        posicion de la lista representa filas y el valor almacenado en esa posicion la columna donde se ubica una reina. 
        El segundo elemento es el tiempo que le tomo al algoritmo encontrar solucion
        
        Parametros:
        n: dimension del tablero, solo para tableros de dimensiones mayores a 3 hay solucion
        
        '''
        found = False
        exito, solucion, tiempo = 0, 1, 2
        resultado = []
        t = 0
        while not found:
            resultado = self.nReinasLasVegas(n)
            found = resultado[exito]
            t = t + resultado[tiempo]
        return resultado[solucion], t


    def nReinasDeterminista(self, fila, n, solucion, t):
        '''Encuentra una solucion al problema de las n reinas a traves de una busqueda por profundidad
        
        Devuelve una lista donde el primer elemento es un booleano que indica si tuvo exito encontrando una solucion
        (este es utilizado como parada de recursion). El segundo elemento muestra la lista de solucion encontrada
        
        Parametros:
        fila: representa un flag que denota en que fila se esta almacenando la columna
        n: dimension del tablero, solo para tableros de dimensiones mayores a 3 hay solucion
        solucion: lista donde se va almacenando la solucion
        t: almacena el tiempo de ejecucion del algoritmo como unidades de iteracion
        
        '''
        if fila >= n: return False
        exito = False
        col = 0
        while True:
            col = col + 1
            t = t + 1
            if self.validar(col, solucion, n):
                solucion.append(col)
                if fila != n-1:
                    rec = self.nReinasDeterminista(fila+1, n, solucion, t)
                    exito = rec[0]
                    t = rec[2]
                    if exito == False:
                        solucion.pop()
                else:
                    exito = True
            if col == n or exito == True:
                break
        return exito, solucion, t

    def nReinas(self, n):
        '''Hace uso del metodo nReinasDeterminista para encontrar una solucion por busqueda por amplitud
        solo pasandole las dimensiones del tablero n
        
        Devuelve una lista almacenando la solucion al tablero de n reinas. Donde cada
        posicion de la lista representa filas y el valor almacenado en esa posicion la
        columna donde se ubica una reina
        
        Parametros:
        n: dimension del tablero, solo para tableros de dimensiones mayores a 3 hay solucion
        
        '''
        filaInicial = 0 # Se asume la fila inicial como 0 antes de asignar una columna al arreglo o lista solucion
        solucionInicial = [] # la lista de solucion inicia vacia
        return self.nReinasDeterminista(filaInicial, n, solucionInicial, 0)#[1]
    
    def analisisAlgoritmoProb(self, numMuestras,numRepeticiones):
      s = 8
      t = 0
      pt = 0
      nm = numMuestras+0.0
      nr = numRepeticiones+0.0
      for b in range(numRepeticiones):
        for i in range(numMuestras):
          x = self.nReinasLVSolver(s)
          t=t+x[1]
        pt = pt + (t / nm)
      ptt = pt/nr
      
      y = self.nReinas(s)
      
      return ptt, y[2]
    
    def analisisHipotesis(self,numMuestras):
      s=8
      arrayresultado=[]
      for muestras in range(100,numMuestras,100):
        totalP=0
        totalF=0
        p=0
        f=0
        for i in range(muestras):
          sol=self.nReinasLasVegas(s)
          if sol[0]:
            totalP=totalP+1
          else:
            totalF= totalF+sol[2]
        p=totalP/float(muestras)
        f=totalF/float(muestras-totalP)
        arrayresultado.append([muestras,p,f])
      return arrayresultado
          
      


class Simulador():
    
    def __init__(self):
        self.m = Maestro()
    
    def generarTiempoEntreLLegada(self, tiempo, desviacion):
        tiempo_min = tiempo - desviacion
        if desviacion > tiempo:
            tiempo_min = 0
        tiempo_max = tiempo + desviacion
        return random.randint(tiempo_min, tiempo_max)
    
    def generarTiempoSolucion(self, n):
        if random.random() >= 0.5:
            print("El maestro elige solucionar el tablero "+str(n)+"x"+str(n)+" de forma determinista")
            return self.m.nReinas(n)[2]
        print("El maestro elige solucionar el tablero "+str(n)+"x"+str(n)+" de forma probabilista")
        return self.m.nReinasLVSolver(n)[1]
    
    def actualizarCola(self, tLlegada, listaSalidas):
        iterador = 1
        cola = 0
        while True:
            if tLlegada < listaSalidas[-iterador]:
                cola = cola + 1
            else:
                break
            if iterador == len(listaSalidas): break
            iterador = iterador + 1
        return cola
    
    def empezar(self, retadores, n, tiempo, desviacion, mostrarTabla = False):
        t_entre_llegada = [0]
        t_llegada = [0]
        inicial = self.generarTiempoSolucion(n)
        t_solucion = [inicial]
        t_salida = [inicial]
        cola = [0]
        promedio_cola = 0
        max_cola = 0
        iteracion = 1
        
        while iteracion <= retadores-1:
            # Generando tiempo entre llegada
            t_entre_llegada.append(self.generarTiempoEntreLLegada(tiempo, desviacion))
            # Transformando los tiempos entre llegadas a tiempo cronologico de llegada
            t_llegada.append(t_llegada[iteracion-1] + t_entre_llegada[iteracion])
            # Generando tiempo que tarda el maestro resolviendo el tablero
            t_solucion.append(self.generarTiempoSolucion(n))
            # Calculando la cola por cada evento ocurrido
            cola.append(self.actualizarCola(t_llegada[iteracion], t_salida))
            # Transformando el tiempo de solucion a tiempos de finalizacion
            t_salida.append(t_salida[iteracion-1] + t_solucion[iteracion])
            iteracion = iteracion + 1
        
        if mostrarTabla:
            print("\nt_entre_llegadas\tt_llegada\tt_solucion\tt_salida\tcola\n")
            for i in range(retadores):
                print("\t"+str(t_entre_llegada[i])+"\t\t"+str(t_llegada[i])+"\t\t"+str(t_solucion[i])+"\t\t"+str(t_salida[i])+"\t\t"+str(cola[i])+"\n")
        
        #Calcular promedio de la cola y devolverlo
        for i in cola:
            promedio_cola = promedio_cola + i
        max_cola = max(cola)
        return promedio_cola/retadores, max_cola
      
    def analisisDeTiempoVsCola(self,n,retadores,desviacion,timpoI,tiempoF,numRepeticiones ):
        
        matrizColaVsTiempo=[]
        promCola=0
        for x in range(timpoI,tiempoF+1,100):
          cola=0
          for i in range(numRepeticiones):
            cola = cola+self.empezar(retadores,n,x,desviacion)[1]
          promCola=cola/float(numRepeticiones)
          matrizColaVsTiempo.append([x,promCola])
        return matrizColaVsTiempo 
      
    def analisisComportamientoCola(self,n,retadores,desviacion,tiempo,arrayRepeticiones):
        
        arrayPromColaMax=[]
        
        for rep in arrayRepeticiones:
          colaMax=0
          for i in range(rep):
            colaMax = colaMax + self.empezar(retadores,n,tiempo,desviacion)[1]
          arrayPromColaMax.append([rep,colaMax/float(rep)])    
        return arrayPromColaMax 
     
        

if __name__ == "__main__":
    simulacion = Simulador()
    retadores = 0
    dimension = 0
    tiempo = 0
    desviacion = 0
    print("Bienvenido al simulador del maestro del problema de las n reinas")
    print("Para iniciar la simulacion es necesario definir los siguietes parametros:\n\tNumero de retadores"+
    "\n\tDimension del tablero de ajedrez\n\tTiempos entre llegadas\n\tDesviacion de los tiempos entre llegadas")
    ''''
    try:
        retadores = input("Cantidad de retadores: ")
        dimension = input("Numero de reinas: ")
        while dimension < 3:
            dimension = input("(el numero de reinas debe ser mayor a 3) Numero de reinas: ")
        tiempo = input("Tiempo de llegadas: ")
        desviacion = input("Desviacion del tiempo: ")
        print("--------------------------------------------Iniciando-Simulacion------------------------------------------\n")
        desempeno = simulacion.empezar(retadores, dimension, tiempo, desviacion)
        print("La cola promedio de la simulacion fue: " + str(desempeno[0]) + " y la cola maxima alcanzada fue: " + str(desempeno[1]))
    except Exception:
        print("Alguno de los campos son de tipo invalido. Todas las entradas son valores enteros")
    
    '''
    m=Maestro()
    #x = m.analisisAlgoritmoProb(100,10)
    #print(str(x))
    
    print(m.analisisHipotesis(1000))
    
    #print(simulacion.analisisComportamientoCola(8,100,7,30,[10,20,30,40,50,60,70,80,90,100]))
    
    #print(simulacion.analisisDeTiempoVsCola(8,100,10,100,900,100))
    