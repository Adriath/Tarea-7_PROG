
package ejercicio6.maestre;

/**
 * Lanzador del programa MasterMind.
 * 
 * @author Adrián Arjona
 * @version 1.0 Marzo 2023
 */
public class Lanzador {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean encontrado = false ;
        
        MasterMind partida1 = new MasterMind() ;
        
        encontrado = partida1.jugar() ;
        
        if (!encontrado) 
        {
            System.out.println("\nSe han agotado los intentos y no has adivinado la combinación, lo siento mucho.");
        }
        
        System.out.println("\n¡GRACIAS POR JUGAR!") ;
    }
    
}
