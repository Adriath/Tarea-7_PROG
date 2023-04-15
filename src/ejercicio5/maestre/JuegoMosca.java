
package ejercicio5.maestre;

import utilidades.Utilidades;

/**
 * Operaciones con arrays bidimensionales.
 * Vamos a realizar un juego en el que se debe atrapar varias moscas que están alojadas
 * en una posición aleatoria de un array de dimensiones indeterminadas.
 * 
 * @author Adrián Arjona
 * @version 2.0 Marzo 2023
 */
public class JuegoMosca {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    private int array[][] ;
    private int rondas ;
    private int longitudX ;
    private int longitudY ;
    private int numeroMoscas ;
    
    
    public JuegoMosca(int[][] array, int rondas, int longitudX, int longitudY, int numeroMoscas){
        
        this.longitudX = longitudX ;
        this.longitudY = longitudY ;
        this.array = new int[longitudX][longitudY] ;
        this.rondas = rondas ;
        this.numeroMoscas = numeroMoscas ;
    }
    
     public int[][] getArray() { // GETTER DE ARRAY
        return array;
    }
    
    public void posicionarMosca(int array[][]){ // MÉTODO QUE RESETEA EL ARRAY Y POSICIONA LA MOSCA (VALOR 1) EN UNA POSICIÓN ALEATORIA
        
        int posicionMoscaX ;
        int posicionMoscaY ;
        int contador = 0 ;
        
        while(contador <= numeroMoscas) // Cuando el contador sea menor o igual que el número de moscas ejecuta el código
        {
            posicionMoscaX = Utilidades.numeroAleatorio((array.length - 1)) ; // Selecciona un número aleatorio para la posición de la mosca en la primera dimensaión del array
            posicionMoscaY = Utilidades.numeroAleatorio((array[0].length - 1)) ; // Selecciona un número aleatorio para la posición de la mosca en la segunda dimensión del array
        
            if (array[posicionMoscaX][posicionMoscaY] != 1) // Si la posición aleatoria no es ya 1...
            {
                array[posicionMoscaX][posicionMoscaY] = 1 ; // ...dale el valor 1 entonces.
                contador++ ; // De ser así suma el contador.
            }
        }
    }
    
    public void resetearArray(int array[][]){ // MÉTODO QUE RESETEA EL ARRAY CUADNO SE FALLA PARA QUE SE PUEDAN DAR VALORES NUEVOS
        
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < array[i].length; j++) 
            {
                array[i][j] = 0 ;
            }
        }
    }
    
    private void muestraArray(int array[]){ // MÉTODO QUE MUESTRA UN CASILLERO HORIZONTAL CON LAS POSICIONES (SÓLO PARA PRUEBAS, tendrá que ser private luego)
        
        for (int i = 0; i < array.length; i++) 
        {
            if (i<(array.length - 1)) // Si la posición no es la última no cerrará la celda
            {
                System.out.print("| " + array[i] + " ");
            }
            else // Si la posición es la última cerrará la celda
            {
                System.out.print("| " + array[i] + " |");
            }
        }
        
    }
    
      private void muestraArray(int array[][]){ // SOBRECARGA DEL MÉTODO muestraArray() PARA LAS DOS DIMENSIONES
        
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < array[i].length; j++) 
            {
                if (j<(array[i].length - 1)) // Si la posición no es la última no cerrará la celda
                {
                System.out.print("| " + array[i][j] + " ");
                }
                else // Si la posición es la última cerrará la celda y da un salto de línea
                {
                System.out.print("| " + array[i][j] + " |\n");
                }
            }
        }
        
    }
    
    
    public boolean jugar(int array[][]){
        
        int contador = 1 ;
        int posicionJugadorFilas = 0 ;
        int posicionJugadorColumnas = 0 ;
        
        boolean encontrado = false ;
        
        posicionarMosca(array);
        
        while ((contador <= this.rondas) && (!encontrado)) // Si no se ha llegado a la última ronda y la mosca no ha sido encontrada
            {
                muestraArray(array); // ---------------- ESTO ES PROVISIONAL, LO TENGO QUE QUITAR ------------------
            
                System.out.println("\nRONDA " + contador);
                System.out.println("----------------------");
            
                System.out.println("\n¿En qué posición está la mosca?");
                posicionJugadorFilas = Utilidades.leerEntero("\nDa el valor para las filas:") ;
                posicionJugadorColumnas = Utilidades.leerEntero("\nDa el valor para las columnas:") ;
                
                if ((posicionJugadorColumnas <= (this.array.length)) && (posicionJugadorFilas <= this.array[0].length) && (posicionJugadorFilas > 0) && (posicionJugadorColumnas > 0)) // Si la posición está dentro de los valores permitidos sigue la ejecución.
                {
                    if (array[posicionJugadorColumnas - 1][posicionJugadorFilas - 1] == 1) // Si la posición elegida por el jugador es igual a 1, mosca encontrada.
                        {
                            encontrado = true ;
                        }
                    else // En caso de no ser encontrada pueden darse dos casos:
                        {
                            // CASO 1: la mosca está a una posición de distancia en el casillero
                        
                            if (((posicionJugador - 1) == array[0]) && (array[1] == 1))
                            // Si la posición del jugador está a la izquierda del todo y su lado derecho es igual a 1
                            {
                                resetearArray(array);
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            else if (((posicionJugador) == array.length) && array[array.length - 2] == 1)
                            // Si la posición del jugador está al final y su lado izquierdo es igual a 1
                            {
                                resetearArray(array);
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            
                            else if ( (0 < ( posicionJugador - 1 ) && ( posicionJugador - 1 ) < ( array.length - 1 ) ) && ( ( array[posicionJugador - 2] == 1) || ( array[posicionJugador] == 1) ) ) 
                            // Si la posición del jugador no es un extremo y la posición izquierda o derecha es igual a 1
                            {
                                resetearArray(array);
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            
                            // CASO 2: la mosca está a más de 1 posición de distancia.
                            
                            else
                            {
                                System.out.println("\n¡Ups! Aquí no está. Sigue buscando.");
                                contador++ ;
                            }
                        }
                }
                else
                {
                    System.out.println("\nEl número que has introducido no corresponde con el tamaño del casillero. Recuerda que puede ser " + array.length + " como máximo.");
                }
            }
                
        return encontrado ;
        }
    }
