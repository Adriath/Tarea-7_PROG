
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
    
    private int array[] ;
    private int rondas ;
    private int longitud ;
    
    public JuegoMosca(int[] array, int rondas, int longitud){
        
        this.array = new int[longitud] ;
        this.rondas = rondas ;
    }
    
//    public int[] crearArray(int longitud){ // MÉTODO QUE CREA UNA ARRAY DE LA LONGITUD DESEADA
//        
//        return new int[longitud] ;
//    }
    
    
    public void posicionarMosca(int array[]){ // MÉTODO QUE RESETEA EL ARRAY Y POSICIONA LA MOSCA (VALOR 1) EN UNA POSICIÓN ALEATORIA
        
        int posicionMosca ;
        
        posicionMosca = Utilidades.numeroAleatorio((array.length - 1)) ; // Selecciona un núemro aleatorio para la posición de la mosca en el array
        
        for (int i = 0; i < array.length; i++) // Primero vamos a dar el valor 0 a todas las posiciones
        {
             array[i] = 0 ;
        }
        
        array[posicionMosca] = 1 ; // Luego le damos el valor 1 (donde está la mosca) a la posición aleatoria escogida anteriormente
    }
    
    public void muestraArray(int array[]){ // MÉTODO QUE MUESTRA UN CASILLERO HORIZONTAL CON LAS POSICIONES (SÓLO PARA PRUEBAS)
        
        for (int i = 0; i < array.length; i++) 
        {
            if (i<(array.length - 1)) // Si la posición no es la última no cerrará la celda
            {
                System.out.print("| " + array[i] + " ");
            }
            else // Si la posición es la última cerrará la celda
            {
                System.out.print("| " + array[i] + " |");
            }
        }
        
    }

    public int[] getArray() {
        return array;
    }
    
    public static void main(String[] args) { // MAIN DE PRUEBAS
        
        JuegoMosca partida = new JuegoMosca();
        
        int array[] = partida.crearArray(8) ;
        
        partida.muestraArray(array);
        
        partida.posicionarMosca(array);
        
        System.out.println("\nOtra interacción: \n");
        
        partida.muestraArray(array);
        
        partida.posicionarMosca(array);
        
        System.out.println("\nOtra interacción: \n");
        
        partida.muestraArray(array);
        
        partida.posicionarMosca(array);
        
        
        
    }
    
}
