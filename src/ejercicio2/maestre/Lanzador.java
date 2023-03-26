
package ejercicio2.maestre;

import utilidades.Utilidades;

/**
 * Lanzador del juego de la mosca. Esta clase contiene el método main que servirá 
 * para ejecutar la partida.
 * 
 * @author Adrián Arjona
 */
public class Lanzador {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    public static void main(String[] args) {
        
        int rondas = 0;
        int longitud = 0;
        int array[] = new int[longitud];
        
        System.out.println("¡Bienvenido/a al juego de la mosca!\n");
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("-----------------");
        System.out.println("Tendrás que adivinar la posición de la mosca en un número límite de intentos. ¡Vamos alla!\n");
        
        rondas = Utilidades.leerEntero("\n¿Cuántos rondas quieres jugar? Serán los intentos de los que dispongas.") ;
        longitud = Utilidades.leerEntero("\n¿Cuál es el número de casillas que tendrá la mosca para esconderse? Ten en cuenta que a mayor casillero, mayor dificultad.") ;
        
        JuegoMosca partida1 = new JuegoMosca(array, rondas, longitud) ;
        array = partida1.getArray() ;
        
        partida1.muestraArray(array);
    }
    
}
