
package ejercicio4.maestre;

/**
 * Métodos útiles para la gestión de los cuerpos celestes.
 * 
 * @author Adrián Arjona
 * @version 1.1 Marzo 2023
 */
public class UtilidadesCuerpoCeleste {
    
     /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
      
    
    public static boolean compruebaCodigo(short codigo){ // COMPRUEBA SI EL CÓDIGO TIENE 3 DÍGITOS
        
        boolean valido = false ;
        
        if (codigo >= 0 && codigo <= 999) // Si el código es positivo y tiene 3 dígitos como máximo será válido
            valido = true ;        
        
        return valido ;
    }
    
    public static boolean compruebaNombre(String nombre){ // CPMPRUEBA SI EL NOMBRE TIENE COMO MÁXIMO 15 CARACTERES
        
        boolean valido = false ;
        
        if (nombre.length() <= 15)
            valido = true ;
        
        return valido ;
    }
    
    public static boolean compruebaDiametro(int diametro){
        
        boolean valido = false ;
        
        if (diametro >= 0 && diametro <= 999999) // Si el diámetro es positivo y tiene 6 dígitos como máximo será válido
            valido = true ;
        
        return valido ;
    }
}
