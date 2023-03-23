
package ejercicio1.maestre;

import utilidades.Utilidades;

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
     * Para evitar incomtabilidades haremos toda la operación con minúsculas.
     * 
     * @param cad Cadena tipo String en la que se va a buscar la letra.
     * @param letra La letra que queremos comprobar de tipo char.
     * @return Devuelve las veces que aparece la letra en la cadena.
     */
    public static short cuantasVecesApareceLetra(String cad, char letra){
        
        short veces = 0 ;
        letra = Character.toLowerCase(letra) ; // Pasamos la letra a minúscula
        
        for (int i = 0; i < cad.length(); i++) 
        {
            if (cad.toLowerCase().charAt(i) == letra) // Si el caracter i (el que toque) de la cadena en minúsuclas es igual a la letra...
            {
                veces++ ; // ... aumenta el contador de veces en uno.
            }
        }
        
        return veces ;
    }
    
    
    /**
     * c) Reciba una cadena y diga si es palíndroma. (si tiene espacios se eliminan dentro del 
     * método, antes de decidir si es palíndroma. Para eliminar espacios se utiliza el método 
     * que tiene la clase String para ello.)
     * 
     * Método que evalúa una cadena pasada por parámetros para comprobar si es 
     * palíndroma (se lee igual hacia delante que hacia atrás).
     * 
     * @param cadena La cadena tipo String a evaluar.
     * @return Devuelve un valor booleano para indicar si la cadena es palíndroma (true) o no (false).
     */
    public static boolean compruebaPalidromo(String cadena){
        
        boolean palidromo = false ;
        
        String cadenaSinEspacios = cadena.replaceAll("\\s", "") ;
        
        StringBuilder sbCadena = new StringBuilder(cadenaSinEspacios) ;
        
        cadena = sbCadena.reverse().toString() ;
        
        if (cadenaSinEspacios.equalsIgnoreCase(cadena)) 
        {
            palidromo = true ;
        }
        
        return palidromo ;
    }
   
   
}
