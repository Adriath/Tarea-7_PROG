
package ejercicio5.maestre;

import utilidades.Utilidades;

/**
 * Lanzador del juego de la mosca. Esta clase contiene el método main que servirá 
 * para ejecutar la partida.
 * 
 * @author Adrián Arjona
 * @version 2.0 Marzo 2023
 */
public class Lanzador {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    /**
     * Mëtodo main del juego de la mosca 2.0.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        int rondas = 0;
        int longitudFilas = 0;
        int longitudColumnas = 0;
        int array[][] = new int[longitudFilas][longitudColumnas];
        int posicionJugadorFilas = 0 ;
        int posicionJugadorColumnas = 0 ;
        int numMoscas = 0;
        int numeroMoscas = 0;
        
        boolean validador = false ;
        boolean moscaEncontrada = false ;
        
        
        System.out.println("¡Bienvenido/a al juego de la mosca!\n");
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("-----------------");
        System.out.println("Tendrás que adivinar la posición de la mosca en un número límite de intentos. ¡Vamos allá!\n");
        
        rondas = Utilidades.leerEntero("\n¿Cuántos rondas quieres jugar? Serán los intentos de los que dispongas.") ;
        System.out.println("\n¿Cuál es el número de casillas que tendrá la mosca para esconderse? Ten en cuenta que a mayor casillero, mayor dificultad.");
        longitudFilas = Utilidades.leerEntero("\nIntroduce el tamaño de las filas:") ;
        longitudColumnas = Utilidades.leerEntero("\nIntroduce el tamaño de las columnas:") ;
        
        do 
        {
            numMoscas = Utilidades.leerEntero("\nY por último, ¿cuántas moscas quieres que aparezcan?") ;
            
            if (numMoscas > 0 && ( numMoscas <= ((longitudFilas * longitudColumnas) - 1)) ) 
                // Si el número de moscas es mayor a cero y no deja al menos un hueco libre en la cuadrícula...
            {
                numeroMoscas = numMoscas ; // ...guarda la variable como válida.
                validador = true ;
            }
            else // ... si no se cumple avisará con un mensaje y volverá a ejecutarse
            {
                System.out.println("\nEl número de moscas no puede ser igual o inferior a 0 ni rellenar el casillero completo.");
            }
            
        } while (!validador);
        
        
        JuegoMosca partida1 = new JuegoMosca(array, rondas, longitudFilas, longitudColumnas, numeroMoscas);
        array = partida1.getArray() ;
        
        moscaEncontrada = partida1.jugar(array) ;
        
        if (moscaEncontrada) 
        {
            System.out.println("\n¡Enhorabuena, has encontrado la mosca!");
        }
        else
        {
            System.out.println("\nSe agotaron las rondas y no has encontrado la mosca, mala suerte.");
        }
    }
    
}
