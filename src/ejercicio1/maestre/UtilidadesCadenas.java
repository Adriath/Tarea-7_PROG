
package ejercicio1.maestre;

/**
 *
 * @author Adrián Arjona
 */
public class UtilidadesCadenas {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    /**
     * Método que recibe dos cadenas por parámetros y devuelve el resultado de 
     * la unión de ambas. Para mayor eficiencia se usará la clase StringBuilder 
     * en su interior.
     * 
     * @param cad1 Cadena 1 que facilita el/la usuario/a.
     * @param cad2 Cadena 2 que facilita el/la usuario/a.
     * @return Devuelve la unión de las dos cadenas pasadas por parámetros de tipo String.
     */
    public static String unirCadenas(String cad1, String cad2){
        
        StringBuilder cadena = new StringBuilder() ;
        
        cadena.append(cad1) ;
        cadena.append(cad2) ;
        
        return cadena.toString() ;
    }
    
    
    public static short cuantasVecesApareceLetra(String cad, char letra){
        
        short veces ;
        
        
    }
}
