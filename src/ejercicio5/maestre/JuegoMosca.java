
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
    
    /* NOTA:
    
        Dentro del método jugar() hay una línea que hace referencia a un método 
        privado para mostrar la cuadrícula, haciendo más fácil la tarea de realizar 
        pruebas. Está señalado en un comentario.
        Si no se desea ver la cuadrícula basta con comentarlo. De momento lo he 
        dejado sin comentar para facilitar la corrección.
    */
    
    
    // -------------- DECLARACIÓN DE VARIABLES -----------------
    
    private int array[][] ;
    private int rondas ;
    private int longitudColumnas ;
    private int longitudFilas ;
    private int numeroMoscas ;
    
    
    // -------------- MÉTODOS -----------------
    
        // ------ CONSTRUCTOR -----
    
    /**
     * Constructor con parámetros de la clase JuegoMosca.
     * 
     * @param array Array bidimensional de tipo entero.
     * @param rondas Número de rondas que tendrá la partida.
     * @param longitudFilas Longitud de las filas del array.
     * @param longitudColumnas Longitud de las columnas de array.
     * @param numeroMoscas Número de moscas a encontrar.
     */
    public JuegoMosca(int[][] array, int rondas, int longitudFilas, int longitudColumnas, int numeroMoscas){
        
        this.longitudColumnas = longitudColumnas ;
        this.longitudFilas = longitudFilas ;
        this.array = new int[longitudFilas][longitudColumnas] ;
        this.rondas = rondas ;
        this.numeroMoscas = numeroMoscas ;
    }
    
        // ------- GETTERS & SETTERS -------
    
    /**
     * Método que devuelve el array de dos dimensiones.
     * 
     * @return Devuelve un array de dos dimensiones.
     */
    public int[][] getArray() {
        return array;
    }
    
    
        // ------ MÉTODOS PERSONALIZADOS --------
    
    /**
     * Método que resetea el array y posiciona la mosca (valor 1) en una posición aleatoria.
     * 
     * @param array Array de dos dimensiones de tipo entero.
     */
    public void posicionarMosca(int array[][]){
        
        int posicionMoscaFilas ;
        int posicionMoscaColumnas ;
        int contador = 0 ;
        
        while(contador < numeroMoscas) // Cuando el contador sea menor que el número de moscas ejecuta el código
        {
            posicionMoscaFilas = Utilidades.numeroAleatorioDesdeoCero(array.length) ; // Selecciona un número aleatorio para la posición de la mosca en la primera dimensaión del array
            posicionMoscaColumnas = Utilidades.numeroAleatorioDesdeoCero(array[0].length) ; // Selecciona un número aleatorio para la posición de la mosca en la segunda dimensión del array
        
            if (array[posicionMoscaFilas][posicionMoscaColumnas] != 1) // Si la posición aleatoria no es ya 1...
            {
                array[posicionMoscaFilas][posicionMoscaColumnas] = 1 ; // ...dale el valor 1 entonces.
                contador++ ; // De ser así suma el contador.
            }
        }
    }
    
    
    /**
     * Método que resetea el array cuando se falla para que se puedan dar valores nuevos.
     * 
     * @param array Array de dos dimensiones de tipo entero.
     */
    public void resetearArray(int array[][]){
        
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < array[i].length; j++) 
            {
                array[i][j] = 0 ;
            }
        }
    }
    
    
    
    /**
     * Método privado que muestra un casillero horizontal con las posiciones 
     * usado para pruebas. Comentar si se va a jugar una partida como usuario.
     * 
     * @param array Array de dos dimensiones de tipo entero.
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
     * Sobrecarga del método muestraArray() para las dos dimensiones.
     * 
     * @param array Array de dos dimensiones de tipo entero.
     */
    private void muestraArray(int array[][]){
        
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

    
    /**
     * Método que ejecuta el juego.
     * 
     * @param array Array de dos dimensiones de tipo entero.
     * @return Devuelve true si la mosca ha sido encontrada y false si no.
     */
    public boolean jugar(int array[][]){
        
        int contador = 1 ;
        int posicionJugadorFilas = 0 ;
        int posicionJugadorColumnas = 0 ;
        
        boolean encontrado = false ;
        
        posicionarMosca(array);
        
        while ((contador <= this.rondas) && (!encontrado)) // Si no se ha llegado a la última ronda y la mosca no ha sido encontrada
            {
                muestraArray(array); // ---------------- COMENTAR SI NO SE QUIERE VER LA CUADRÍCULA ------------------
            
                System.out.println("\nRONDA " + contador);
                System.out.println("----------------------");
            
                System.out.println("\n¿En qué posición está la mosca?");
                posicionJugadorFilas = Utilidades.leerEntero("\nDa el valor para las filas:") ;
                posicionJugadorColumnas = Utilidades.leerEntero("\nDa el valor para las columnas:") ;
                
                if ((posicionJugadorFilas <= (this.array.length)) && (posicionJugadorColumnas <= this.array[0].length) && (posicionJugadorFilas > 0) && (posicionJugadorColumnas > 0)) // Si la posición está dentro de los valores permitidos sigue la ejecución.
                {
                    if (array[posicionJugadorFilas - 1][posicionJugadorColumnas - 1] == 1) // Si la posición elegida por el jugador es igual a 1, mosca encontrada.
                        {
                            encontrado = true ;
                        }
                    else // En caso de no ser encontrada pueden darse dos casos:
                        {
                            // CASO 1: la mosca está a una posición de distancia en el casillero
                        
                            if ( ((posicionJugadorFilas - 1) == 0) && (array[1][posicionJugadorColumnas - 1]) == 1 )
                            // Si la posición del jugador está ARRIBA del todo y la mosca está justo debajo
                            {
                                resetearArray(array);
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            
                            else if ( ( posicionJugadorFilas == array.length ) && ( array[posicionJugadorFilas - 2][posicionJugadorColumnas - 1] == 1) )
                            // Si la posición del jugador está a la ABAJO del todo y la mosca está justo arriba.
                            {
                                resetearArray(array);
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            
                            else if ( (( posicionJugadorColumnas -1 ) == 0 ) && ( array[posicionJugadorFilas - 1][1] == 1) )
                            // Si la posición del jugador está a la IZQUIERDA del todo y la mosca está justo a la derecha.
                            {
                                resetearArray(array);
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            
                            else if ( ( posicionJugadorColumnas == array[0].length ) && ( array[posicionJugadorFilas - 1][array[0].length - 2] == 1) )
                            // Si la posición del jugador está a la DERECHA del todo y la mosca está justo a la izquierda.
                            {
                                resetearArray(array);
                                posicionarMosca(array);
                                System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                contador++ ;
                            }
                            
                            else if ( (0 < ( posicionJugadorFilas - 1 )) && (0 < ( posicionJugadorColumnas - 1 )) && 
                                    (( posicionJugadorFilas - 1 ) < ( array.length - 1 ))  && ((posicionJugadorColumnas - 1) < (array[0].length - 1)) )
                            // Si la posición del jugador no es un extremo
                            {
                                if ( ((array[posicionJugadorFilas - 1][posicionJugadorColumnas - 2]) == 1) || // Si la mosca está a la IZQUIERDA...
                                        ((array[posicionJugadorFilas - 1][posicionJugadorColumnas]) == 1) || // ...o está a la DERECHA...
                                        ((array[posicionJugadorFilas - 2][posicionJugadorColumnas -1]) == 1) || // ...o está a ARRIBA...
                                        ((array[posicionJugadorFilas][posicionJugadorColumnas - 1]) == 1) ) // ...o si está ABAJO.
                                { 
                                    // RESUMEN: para arriba, abajo, izquierda o derecha
                                    
                                    resetearArray(array);
                                    posicionarMosca(array);
                                    System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                    contador++ ;
                                }
                                
                                else if ( ((array[posicionJugadorFilas - 2][posicionJugadorColumnas - 2]) == 1) || // Si la mosca está a ARRIBA/IZQUIERDA...
                                        ((array[posicionJugadorFilas - 2][posicionJugadorColumnas]) == 1) || // ...o está a la ARRIBA/DERECHA...
                                        ((array[posicionJugadorFilas][posicionJugadorColumnas -2]) == 1) || // ...o está a ABAJO/IZQUIERDA...
                                        ((array[posicionJugadorFilas][posicionJugadorColumnas]) == 1) ) // ...o si está ABAJO/DERECHA.
                                {
                                    // RESUMEN: para las cuatro diagonales
                                    
                                    resetearArray(array);
                                    posicionarMosca(array);
                                    System.out.println("\n¡Vaya! La mosca ha revoloteado y ha cambiado de posición.");
                                    contador++ ;
                                }
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
                    System.out.println("\nEl número que has introducido no corresponde con el tamaño del casillero. Recuerda que puede tener un tamaño de " + longitudFilas + "x" + longitudColumnas + " como máximo.");
                }
            }
                
        return encontrado ;
        }
    }
