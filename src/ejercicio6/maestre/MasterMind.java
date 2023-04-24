
package ejercicio6.maestre;

import utilidades.Utilidades;

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
    private int arrayUsuario[] ;
    
    // ------------------ MÉTODOS -----------------------------
    
        // ------ CONSTRUCTOR ---------
    
        public MasterMind(){ // CONSTRUCTOR CON PARÁMETROS
        
            this.array = new int[3];
            this.arrayUsuario = new int[3] ;
        }
    
        // ------- GETTERS & SETTERS ---------

        public int[] getArray() { // GETTER DE ARRAY
            
            return array;
        }
        
        public int[] getArrayUsuario() { // GETTER DE ARRAY USUARIO
            
            return array;
        }
    
        
        // ------ PERSONALIZADOS -------
        
        public void generaValoresAleatorios(int[] array){
            //MÉTODO QUE GENERA TRES NÚMEROS ALEATORIOS Y LOS GUARDA EN EL ARRAY
            
            array[0] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la primera posición.
            array[1] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la segunda posición.
            array[2] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la tercera posición.
        }
        public static void main(String[] args) {
        int array[] ;
        
        MasterMind partida1 = new MasterMind() ;
        
        array = partida1.getArray() ;
        
        partida1.generaValoresAleatorios(array);
        
            for (int i : array) {
                System.out.println(i);
            }
    }
}
