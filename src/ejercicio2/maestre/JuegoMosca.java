
package ejercicio2.maestre;

import utilidades.Utilidades;

/**
 * Operaciones con arrays unidimensionales.
 * Vamos a realizar un juego en el que se debe atrapar una mosca que está alojada 
 * en una posición aleatoria de un array.
 * 
 * @author Adrián Arjona
 * @version Marzo 2023
 */
public class JuegoMosca {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    
    /*
    NOTA IMPORTANTE:
    
    HE DEJADO HABILITADA LA VISIBILIDAD DEL CASILLERO PARA FACILITAR LA CORRECCIÓN.
    SI SE QUIERE OCULTAR BASTA CON COMENTAR LA LÍNEA QUE HACE ALUSIÓN AL MÉTODO 
    muestraArray() DENTRO DEL MÉTODO jugar().
    */
    
    
    // ---------- DECLARACIÓN DE VARIABLES --------------
    
    private int array[] ;
    private int rondas ;
    private int longitud ;
    
    
    // ------------ MÉTODOS --------------
    

        // ------------ CONSTRUCTOR --------------
    
    
    /**
     * Constructor del juego de la mosca.
     * 
     * @param array Array que alojará la mosca.
     * @param rondas Número de rondas que tendrá la partida.
     * @param longitud Longitud del array para determinar la dificultad.
     */
    public JuegoMosca(int[] array, int rondas, int longitud){
        
        this.array = new int[longitud] ;
        this.rondas = rondas ;
    }
    
        // ------------ GETTERS & SETTERS --------------
    
    /**
     * Devuelve el array.
     * 
     * @return Array unidimensional de tipo entero.
     */
    public int[] getArray() {
        return array;
    }
    
    
        // ------------ PERSONALIZADOS --------------
     
    /**
    * Método que resetea el array cuando se falla para que se puedan dar valores nuevos.
    * 
    * @param array Array de dos dimensiones de tipo entero.
    */
    public void resetearArray(int array[]){
        
        for (int i = 0; i < array.length; i++) 
        {
            array[i] = 0 ;
        }
    }
     
    
    /**
     * Método que resetea el array y posiciona la mosca (valor 1) en una posición aleatoria.
     * 
     * @param array Array de tipo entero.
     */
    public void posicionarMosca(int array[]){
        
        int posicionMosca ;
        
        resetearArray(array) ;
        
        posicionMosca = Utilidades.numeroAleatorioDesdeoCero((array.length)) ; // Selecciona un núemro aleatorio para la posición de la mosca en el array
        
        array[posicionMosca] = 1 ; // Luego le damos el valor 1 (donde está la mosca) a la posición aleatoria escogida anteriormente
    }
    
    
    
    /**
     * Método privado que muestra un casillero horizontal con las posiciones
     * SÓLO PARA PRUEBAS Y CORRECCIÓN. COMENTAR SI SE QUIERE JUGAR COMO USUARIO/A
     * 
     * @param array Array de tipo entero.
     */
    private void muestraArray(int array[]){
        
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
    
    
    /**
     * Método que secuencia una partida del juego de la mosca.
     * 
     * @param array Array tipo entero.
     * @return Devuelve true si la mosca ha sido encontrada y false si no.
     */
    public boolean jugar(int array[]){
        
        int contador = 1 ;
        int posicionJugador = 0 ;
        
        boolean encontrado = false ;
        
        posicionarMosca(array);
        
        while ((contador <= this.rondas) && (!encontrado)) // Si no se ha llegado a la última ronda y la mosca no ha sido encontrada
            {
                muestraArray(array); // ---------------- COMENTAR EN CASO DE NO QUERER VER EL CASILLERO ------------------
            
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
    

