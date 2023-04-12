
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
    
    private int array[] ;
    private int rondas ;
    private int longitud ;
    
    public JuegoMosca(int[] array, int rondas, int longitud){
        
        this.array = new int[longitud] ;
        this.rondas = rondas ;
    }
    
//    public int[] crearArray(int longitud){ // MÉTODO QUE CREA UNA ARRAY DE LA LONGITUD DESEADA
//        
//        return new int[longitud] ;
//    }
    
     public int[] getArray() { // GETTER DE ARRAY
        return array;
    }
    
    public void posicionarMosca(int array[]){ // MÉTODO QUE RESETEA EL ARRAY Y POSICIONA LA MOSCA (VALOR 1) EN UNA POSICIÓN ALEATORIA
        
        int posicionMosca ;
        
        posicionMosca = Utilidades.numeroAleatorio((array.length - 1)) ; // Selecciona un núemro aleatorio para la posición de la mosca en el array
        
        for (int i = 0; i < array.length; i++) // Primero vamos a dar el valor 0 a todas las posiciones
        {
             array[i] = 0 ;
        }
        
        array[posicionMosca] = 1 ; // Luego le damos el valor 1 (donde está la mosca) a la posición aleatoria escogida anteriormente
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
    
    
    public boolean jugar(int array[]){
        
        int contador = 1 ;
        int posicionJugador = 0 ;
        
        boolean encontrado = false ;
        
        posicionarMosca(array);
        
        while ((contador <= this.rondas) && (!encontrado)) // Si no se ha llegado a la última ronda y la mosca no ha sido encontrada
            {
                muestraArray(array); // ---------------- ESTO ES PROVISIONAL, LO TENGO QUE QUITAR ------------------
            
                System.out.println("\nRONDA " + contador);
                System.out.println("----------------------");
            
                posicionJugador = Utilidades.leerEntero("\n¿En qué posición está la mosca?") ;
                
                if ((posicionJugador <= (this.array.length)) && (posicionJugador > 0)) // Si la posición está dentro de los valores permitidos sigue la ejecución.
                {
                    if (array[posicionJugador - 1] == 1) // Si la posición elegida por el jugador es igual a 1, mosca encontrada.
                        {
                            encontrado = true ;
                        }
                    else // En caso de no ser encontrada pueden darse dos casos:
                        {
                        
                            if (((posicionJugador - 1) == array[0]) && (array[1] == 1)) // Si la posición del jugador está a la izquierda del todo y su lado derecho es igual a 1
                            {
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            else if (((posicionJugador) == array.length) && array[array.length - 2] == 1) // Si la posición del jugador está al final y su lado izquierdo es igual a 1
                            {
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            
                            /*
                            Si la posición del jugador no es un extremo y la posición izquierda o derecha es igual a 1
                            */
                            else if ( (0 < ( posicionJugador - 1 ) && ( posicionJugador - 1 ) < ( array.length - 1 ) ) && ( ( array[posicionJugador - 2] == 1) || ( array[posicionJugador] == 1) ) ) 
                            {
                                 posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            
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
