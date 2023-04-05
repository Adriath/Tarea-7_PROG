
package ejercicio3.maestre;

import utilidades.Utilidades;

/**
 *
 * @author Adrián Arjona
 */
public class OperacionesArraysMultidimensionales {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    // ---------- DECLARACIÓN DE ATRIBUTOS ----------------
    
    private int array[][] ;
    private int longitudX ;
    private int longitudY ;
    
    
    // -------------- MÉTODOS -----------------
    
        // --- CONSTRUCTOR ---
    
    public OperacionesArraysMultidimensionales (int[] array, int longitudX, int longitudY){
        
        this.array = new int[longitudX][longitudY] ;
        this.longitudX = longitudX ;
        this.longitudY = longitudY ;
    }
    
        // --- GETTERS & SETTERS ---

            // ARRAY
    
    public int[][] getArray() {
        return array;
    }
    
        // --- MÉTODOS PERSONALIZADOS ---
    
    public int[][] darValores(int array[][]){
        
        for (int i = 0; i < array.length; i++) 
        {
            i = Utilidades.numeroAleatorio(9) ;
            
            for (int j = 0; j < array.length; j++) 
            {
                j = Utilidades.numeroAleatorio(9) ;
            }
        }
        
        return array ;
    }
    
}
