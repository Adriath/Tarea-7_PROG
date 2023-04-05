
package ejercicio3.maestre;

import utilidades.Utilidades;

/**
 *
 * @author Adrián Arjona
 */
public class Lanzador {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
       public static void main(String[] args) {
        
        int longitudX = 0 ;
        int longitudY = 0 ;
        int array[][] = new int[longitudX][longitudY] ;
        
        System.out.println("Bienvenido/a al calculador de medias en matrices");
        System.out.println("-------------------------------------------------");
        System.out.println("\nINSTRUCCIONES:");
        System.out.println("Vamos a crear una matriz de dos dimensiones. Tendrás que aportar la longitud y el sistema se encargará "
                + "de mostrar los valores máximos de cada fila y la media de esos valores máximos. ¡Vamos allá!");
           
        longitudX = Utilidades.leerEntero("\n\t¿Cuántas filas quieres que tenga?") ;
        longitudY = Utilidades.leerEntero("\n\t¿Y cuántas columnas?") ;
        
        String seguimos = Utilidades.leerString("\nDe acuerdo, vamos a procesar los datos. Pulsa una tecla.") ;
        
        OperacionesArraysMultidimensionales operacion1 = new OperacionesArraysMultidimensionales(array, longitudX, longitudY) ;
        
        array = operacion1.getArray() ;
        
        operacion1.darValores(array) ;
        
        operacion1.muestraArray(array);
        
        operacion1.calculaMaximosYMedia(array);
        
    }
    
}
