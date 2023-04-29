
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
            
            return arrayUsuario;
        }
    
        
        // ------ PERSONALIZADOS -------
        
        public int[] generaValoresAleatorios(int[] array){
            //MÉTODO QUE GENERA TRES NÚMEROS ALEATORIOS Y LOS GUARDA EN EL ARRAY
            
            array[0] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la primera posición.
            array[1] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la segunda posición.
            array[2] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la tercera posición.
            
            this.array = array ;
            
            return array ;
        }
        
        public String[] comparaArrays(int[] array, int[] arrayUsuario){
            // MÉTODO QUE COMPARA LOS ARRAYS
            
          
            
            return  ;
        }
        
        public static void main(String[] args) { // -------- MAIN DE PRUEBAS --------------
        int array[] ;
        int arrayUsuario[] ;
        boolean encontrado = false ;
        
        MasterMind partida1 = new MasterMind() ;
        
        array = partida1.getArray() ;
        
        
        array = partida1.generaValoresAleatorios(array);
        
            for (int i : array) {
                System.out.print(i + " ");
            }
            
        
        
        arrayUsuario = partida1.getArrayUsuario() ;
        
            System.out.println("Longitud arrayUsuario: ");
            System.out.println(arrayUsuario.length);
        
            
                
                for (int i = 0; i < arrayUsuario.length; i++) {
                    
                    arrayUsuario[i] = Utilidades.leerEnteroConLimiteDeDigitos("\nPosición " + (i+1), 1) ;
                    
                }
                
                String pista[] = new String[3] ;
        pista = partida1.comparaArrays(array, arrayUsuario) ;
        
                for (String i : pista) {
                    System.out.print(i + " ");
                }
    }
}
