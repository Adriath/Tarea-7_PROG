
package ejercicio4.maestre;

/**
 * Excepción para la clase CuerpoCeleste. Reutilizada del ejercicio 6 para que 
 * funcione correctamente al portarlo al ejercicio 7.
 * @author Adrián Arjona
 * @version 1.1 Marzo 2023
 */
public class ExcepcionCuerpoCeleste extends Exception {
    
    
     /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    /**
     * Excepeción del cuerpo celeste.
     * 
     * @param msj Mensaje para el/la usuario/a.
     */
    public ExcepcionCuerpoCeleste (String msj){
        
        super(msj) ;
    }
    
}
