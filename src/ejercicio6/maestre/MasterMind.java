
package ejercicio6.maestre;

/**
 * EJERCICIO 6
 * Juego del MasterMind.
 * 
 * @author Adrián Arjona
 * @version 1.0 Marzo 2023
 */
public class MasterMind {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    
    // ---------------- DECLARACIÓN DE VARIABLES -----------------
    
    private int array[] ;
    
    // ------------------ MÉTODOS -----------------------------
    
        // CONSTRUCTOR
    
        public MasterMind(int[] array){ // CONSTRUCTOR CON PARÁMETROS
        
            this.array = array ;
        }
    
        // GETTERS & SETTERS

        public int[] getArray() { // GETTER DE ARRAY
            
            return array;
        }
    
        
}
