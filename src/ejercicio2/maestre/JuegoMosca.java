/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.maestre;

import utilidades.Utilidades;

/**
 * Operaciones con arrays unidimensionales.
 * Vamos a realizar un juego en el que se debe atrapar una mosca que está alojada 
 * en una posición aleatoria de un array.
 * 
 * @author Adrián Arjona
 */
public class JuegoMosca {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    private int longitud ;
    private int rondas ;
    private int array[] ;
    
      
    public int[] crearArray(int longitud){ // MÉTODO QUE CREA UNA ARRAY DE LA LONGITUD DESEADA
        
        return new int[longitud] ;
    }

    public int[] getArray() {
        
        return array;
    }

    
    public void posicionarMosca(int array[]){
        
        int posicionMosca ;
        
        posicionMosca = Utilidades.numeroAleatorio(array.length) ; // Selecciona un núemro aleatorio para la posición de la mosca en el array
        
        for (int i = 0; i < array.length; i++) // Primero vamos a dar el valor 0 a todas las posiciones
        {
             array[i] = 0 ;
        }
        
        array[posicionMosca] = 1 ; // Luego le damos el valor 1 (donde está la mosca) a la posición aleatoria escogida anteriormente
    }
    
    public static void main(String[] args) { // MAIN DE PRUEBAS
        
        JuegoMosca partida = new JuegoMosca();
        
        int array[] = partida.crearArray(8) ;
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posición " + (i+1) + " = " + array[i]);
        }
        
        partida.posicionarMosca(array);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posición " + (i+1) + " = " + array[i]);
        }
        
         partida.posicionarMosca(array);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posición " + (i+1) + " = " + array[i]);
        }
        
         partida.posicionarMosca(array);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posición " + (i+1) + " = " + array[i]);
        }
    }
    
}
