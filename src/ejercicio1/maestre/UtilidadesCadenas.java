
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
     * a) Reciba 2 cadenas y devuelve una cadena resultado de unir las dos anteriores.
     * 
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
    
    
    /**
     * b) Reciba una cadena y una letra, y devuelva cuántas veces está dicha letra en la cadena.
     * 
     * Método que recibe una cadena y una letra por parámetros. Comprobará si la letra 
     * está contenida en la cadena y cuántas veces.
     * 
     * @param cad Cadena tipo String en la que se va a buscar la letra.
     * @param letra La letra que queremos comprobar de tipo char.
     * @return Devuelve las veces que aparece la letra en la cadena.
     */
    public static short cuantasVecesApareceLetra(String cad, char letra){
        
        short veces = 0 ;
        
        for (int i = 0; i < cad.length(); i++) 
        {
            if (cad.charAt(i) == letra)
            {
                veces++ ;
            }
        }
        
        return veces ;
    }
    
    public static void main(String[] args) {
        
    }
}
