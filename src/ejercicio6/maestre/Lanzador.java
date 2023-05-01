
package ejercicio6.maestre;

import utilidades.Utilidades;

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
        
        System.out.println("-----------------------------------");
        System.out.println("--- ¡BIENVENIDO/A A MASTERMIND! ---");
        System.out.println("-----------------------------------\n");
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("-----------------");
        System.out.println("Tendrás 7 intentos para adivinar la combinación de tres dígitos propuesta.");
        System.out.println("En cada intento se aportará una pista:\n");
        System.out.println("\t- " + Utilidades.coloreaCadena("Verde", Utilidades.verde) + ": Has acertado ese dígito.");
        System.out.println("\t- " + Utilidades.coloreaCadena("Amarillo", Utilidades.amarillo) + ": Ese dígito forma parte de la combinación pero en otra posición.");
        System.out.println("\t- " + Utilidades.coloreaCadena("Rojo", Utilidades.rojo) + ": Ese dígito no está en la combinación.");
        System.out.println("\n¡COMENCEMOS!\n");
        
        encontrado = partida1.jugar() ;
        
        if (!encontrado) 
        {
            System.out.println("\nSe han agotado los intentos y no has adivinado la combinación, lo siento mucho.");
        }
        
        System.out.println("\n¡GRACIAS POR JUGAR!") ;
    }
    
}
