
package ejercicio3.maestre;

import java.util.Arrays;
import utilidades.Utilidades;

/**
 * EJERCICIO 3
 * Operaciones con arrays multidimensionales.
 * 
 * @author Adrián Arjona
 * @version 1.0 Marzo 2023
 */
public class OperacionesArraysMultidimensionales{
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    // ---------- DECLARACIÓN DE ATRIBUTOS ----------------
    
    private int array[][] ;
    private int longitudX ;
    private int longitudY ;
    
    
    // -------------- MÉTODOS -----------------
    
        // --- CONSTRUCTOR ---
    
    /**
     * Constructor con parámetros.
     * 
     * @param array Array de dos dimensiones y tipo entero.
     * @param longitudX Longitud array eje X.
     * @param longitudY Longitud array eje Y.
     */
    public OperacionesArraysMultidimensionales (int[][] array, int longitudX, int longitudY){
        
        this.array = new int[longitudX][longitudY] ;
        this.longitudX = longitudX ;
        this.longitudY = longitudY ;
    }
    
        // --- GETTERS & SETTERS ---

            // ARRAY
    
    /**
     * Método que muestra el array.
     * 
     * @return Devuelve un array de dos dimensiones.
     */
    public int[][] getArray() {
        return array;
    }
    
        // --- MÉTODOS PERSONALIZADOS ---
    
    /**
     * Método que da valores del 1 al 9 a todas las posiciones del array.
     * 
     * @param array Array de dos dimensiones de tipo entero.
     * @return Devuelve array de dos dimensiones.
     */
    public int[][] darValores(int array[][]){
        
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < array[i].length; j++) 
            {
                array[i][j] = Utilidades.numeroAleatorio(9) ;
            }
        }
        
        return array ;
    }
    
    
    
    /**
     * Método que muestra una tabla con los valores del array.
     * 
     * @param array Array de dos dimensiones de tipo entero.
     */
    public void muestraArray(int array[][]){
        
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
     * Método que calcula los máximos.
     * 
     * @param array Array de dos dimensiones de tipo entero.
     */
    public void calculaMaximosYMedia(int array[][]){
        
        /*
        Está ahora mimso como void. ¿Debería hacerlo de otro modo?
        */
        
        // Vamos a calcular los valores máximos
        
        int suma = 0 ;
        int media = 0 ;
        
        int maximos[] = new int[array.length] ; // Array que va a almacenar los valores máximos
        
        for (int i = 0; i < array.length; i++) 
        {
            int maximo = array[i][0] ; // Inicio variable maximo para la fila
            
            for (int j = 0; j < array[i].length; j++) 
            {                
                if (array[i][j] > maximo) // Si el valor es mayor al anterior ...
                {
                    maximo = array[i][j]; // ...lo almacena
                }
            }
            
            maximos[i] = maximo ; // Guardamos el valor en el array de los valores máximos
        }
        
        // Mostramos los valores máximos
        
        System.out.println("\nMáximos");
        System.out.println("-------");
        
        for (int i = 0; i < maximos.length; i++) 
        {
            System.out.println("   " + maximos[i]); // Imprime por pantalla 
        }
        
        // Ahora vamos a calcular la media
        
        for (int i = 0; i < maximos.length; i++) 
        {
            suma += maximos[i] ;
        }
        
        media = suma / maximos.length ;
        
        // Mostramos la media
        
        System.out.println("\nMedia");
        System.out.println("-------");
        System.out.println(media);
    }
    
}
