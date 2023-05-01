
package ejercicio1.maestre;

import utilidades.Utilidades;

/**
 * Clase para operaciones con cadenas de la tarea 7 de programación.
 * Marzo 2023.
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
   
    /**
     * d) Reciba una cadena, y la devuelva girada, es decir al revés.
     * 
     * Método que recibe una cadena por parámetros y la devuelve girada.
     * 
     * @param cad Cadena de caracteres tipo String.
     * @return Devuelve la cadena girada como un String.
     */
    public static String giraCadena(String cad){
       
       StringBuilder sbCadena = new StringBuilder(cad) ;
       
       cad = sbCadena.reverse().toString() ;
       
       return cad ;
   }
    
    
    // ------------------------------------------------------------
    // -------------------- MÉTODO MAIN ---------------------------
    // ------------------------------------------------------------
    
    /**
     * Método main del ejercicio 1.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        char letra ;
        boolean validador = false ;
        
        
        System.out.println("Vamos a hacer un pequeño recorrido por los apartados "
                + "de este ejercicio para mostrarlos mediante su ejecución.\n");
        
        // APARTADO A
        
        System.out.println("\nAPARTADO A") ;
        System.out.println("-------------\n") ;
        
        System.out.println("Recibe dos cadenas y devuelve una cadena resultado de unir las dos anteriores.");
        
        String cadena1 = Utilidades.leerString("\nIntroduce la primera cadena:") ;
        String cadena2 = Utilidades.leerString("\nIntroduce la segunda cadena:") ;
        
        System.out.println("\nAhora vamos a unirlas y a mostrar el resultado.\n") ;
        System.out.println("La cadena resultante es: ") ;
        System.out.println(unirCadenas(cadena1, cadena2));
        
        // APARTADO B
        
        System.out.println("\nAPARTADO B") ;
        System.out.println("-------------\n") ;
        
        System.out.println("Recibe una cadena y una letra, y devuelva cuántas veces está dicha letra en la cadena.");
        
        String cadena = Utilidades.leerString("\nIntroduce la cadena con la que quieres hacer la comprobación:") ;
        
        do 
        {
            letra = Utilidades.leerCaracter("\nAhora introduce la letra que quieres contar dentro de la cadena:") ;
            
            if (Character.isLetter(letra)) 
            {
                validador = true ;
            }
            else
            {
                System.out.println("\nDebes introducir una letra.") ;
            }
            
        } while (!validador);
        
        int conteoLetra = cuantasVecesApareceLetra(cadena, letra) ;
        
        if (conteoLetra == 0) 
        {
            System.out.println("\nLa letra \"" + letra + "\" no aparece en la cadena.") ;
        }
        else if (conteoLetra == 1) 
        {
            System.out.println("\nLa letra \"" + letra + "\" aparece 1 vez.") ;
        }
        else
        {
            System.out.println("\nLa letra \"" + letra + "\" aparece " + conteoLetra + " veces.") ;
        }
        
        
        // APARTADO C
        
        System.out.println("\nAPARTADO C") ;
        System.out.println("-------------\n") ;
        
        System.out.println("Reciba una cadena y diga si es palíndroma.") ;
        
        String cadenaPalindroma = Utilidades.leerString("\nIntroduce la cadena para comprobar si es palíndroma:") ;
        
        boolean esPalindroma = compruebaPalidromo(cadenaPalindroma) ;
        
        if (esPalindroma) 
        {
            System.out.println("\nLa cadena " + cadenaPalindroma + " es palíndroma.") ;
        }
        else
        {
            System.out.println("\nLa cadena " + cadenaPalindroma + " no es palíndroma.") ;
        }
        
        
         // APARTADO D
        
        System.out.println("\nAPARTADO D") ;
        System.out.println("-------------\n") ;
        
        System.out.println("Reciba una cadena, y la devuelva girada, es decir al revés.") ;
        
        String cadenaGirada = Utilidades.leerString("\nIntroduce la cadena que quieres girar:") ;
        System.out.println("\nAquí tienes la cadnea girada:") ;

        System.out.println("\n" + giraCadena(cadenaGirada)) ;
    }
}
