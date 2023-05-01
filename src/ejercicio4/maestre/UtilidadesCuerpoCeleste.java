
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
    
      
    
    /**
     * Comprueba si el código tiene 3 dígitos.
     * 
     * @param codigo Código del cuerpo celeste.
     * @return Devuelve true si el código es válido, false si no.
     */
    public static boolean compruebaCodigo(short codigo){
        
        boolean valido = false ;
        
        if (codigo >= 0 && codigo <= 999) // Si el código es positivo y tiene 3 dígitos como máximo será válido
            valido = true ;        
        
        return valido ;
    }
    
    
    /**
     * Comprueba si el nombre tiene como máximo 15 caracteres.
     * 
     * @param nombre Nombre del cuerpo celeste.
     * @return Devuelve true si es válido y false si no.
     */
    public static boolean compruebaNombre(String nombre){
        
        boolean valido = false ;
        
        if (nombre.length() <= 15)
            valido = true ;
        
        return valido ;
    }
    
    
    /**
     * Comprueba si el diámetro del cuerpo celeste es válido.
     * 
     * @param diametro Diámetro del cuerpo celeste.
     * @return Devuelve true si el diámetro es válido, false si no.
     */
    public static boolean compruebaDiametro(int diametro){
        
        boolean valido = false ;
        
        if (diametro >= 0 && diametro <= 999999) // Si el diámetro es positivo y tiene 6 dígitos como máximo será válido
            valido = true ;
        
        return valido ;
    }
}
