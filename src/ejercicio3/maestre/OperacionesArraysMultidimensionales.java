
package ejercicio3.maestre;

import java.util.Arrays;
import utilidades.Utilidades;

/**
 *
 * @author Adrián Arjona
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
    
    public OperacionesArraysMultidimensionales (int[][] array, int longitudX, int longitudY){
        
        this.array = new int[longitudX][longitudY] ;
        this.longitudX = longitudX ;
        this.longitudY = longitudY ;
    }
    
        // --- GETTERS & SETTERS ---

            // ARRAY
    
    public int[][] getArray() { // DEVUELVE EL ARRAY
        return array;
    }
    
        // --- MÉTODOS PERSONALIZADOS ---
    
    public int[][] darValores(int array[][]){ // MÉTODO QUE DA VALORES DEL 1 AL 9 A TODAS LAS POSICIONES DEL ARRAY
        
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < array[i].length; j++) 
            {
                array[i][j] = Utilidades.numeroAleatorio(9) ;
            }
        }
        
        return array ;
    }
    
    public void muestraArray(int array[][]){ // MÉTODO QUE MUESTRA UNA TABLA CON LOS VALORES DEL ARRAY
        
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
    
    public void calculaMaximosYMedia(int array[][]){ // MÉTODO QUE CALCULA LOS MÁXIMOS
        
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
