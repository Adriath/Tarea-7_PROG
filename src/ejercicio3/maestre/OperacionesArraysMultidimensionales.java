
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
    
    public OperacionesArraysMultidimensionales (int[][] array, int longitudX, int longitudY){
        
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
            for (int j = 0; j < array[0].length; j++) 
            {
                array[i][j] = Utilidades.numeroAleatorio(9) ;
            }
        }
        
        return array ;
    }
    
    private void muestraArray(int array[][]){ // MÉTODO QUE MUESTRA UN CASILLERO HORIZONTAL CON LAS POSICIONES (SÓLO PARA PRUEBAS, tendrá que ser private luego)
        
        for (int i = 0; i < array.length; i++) 
        {
//            if (i<(array.length - 1)) // Si la posición no es la última no cerrará la celda
//            {
//                System.out.print("| " + array[i] + " ");
//            }
//            else // Si la posición es la última cerrará la celda
//            {
//                System.out.print("| " + array[i] + " |\n");
//            }
            
            for (int j = 0; j < array[0].length; j++) 
            {
                if (j<(array.length - 1)) // Si la posición no es la última no cerrará la celda
                {
                System.out.print("| " + array[j][i] + " ");
                }
                else // Si la posición es la última cerrará la celda
                {
                System.out.print("| " + array[j][i] + " |\n");
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        int longitudX = 0 ;
        int longitudY = 0 ;
        int array[][] = new int[longitudX][longitudY] ;
        
        
        
        OperacionesArraysMultidimensionales operacion1 = new OperacionesArraysMultidimensionales(array, 3, 3) ;
        
        array = operacion1.getArray() ;
        
        operacion1.darValores(array) ;
        
        operacion1.muestraArray(array);
        
        
    }
    
}
