
package ejercicio4.maestre;

import java.util.ArrayList;
import java.util.List;
import utilidades.Utilidades;

/**
 * Lanzador para la clase CuerpoCeleste de la tarea 7.
 * 
 * @author Adrián Arjona
 * @version 1.1 Marzo 2023
 */
public class Lanzador {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    private static List<CuerpoCeleste> cuerposCelestes = new ArrayList<>() ;
    

    // ------------------------------------------------------------
    // -------------------- MÉTODO MAIN ---------------------------
    // ------------------------------------------------------------
    
    
    public static void main(String[] args) {
        
        int opcion ;
        boolean salir = false ;
        
        System.out.println("Bienvenido/a al archivo de Cuerpos Celestes.\n");
        
        do 
        {
            aniadirCuerpoCeleste() ;
            
            salir = Utilidades.secuenciaSalida("\n¿Quieres introducir alguno más?") ;          
            
        } while (!salir);
        
        System.out.println("\nDe acuerdo. A continuación se mostrarán los datos recogidos:\n");
        
        listarCuerpoCeleste();
        
        System.out.println("\nGracias por utilizar el programa.");
    }
    
    
// ------------------ MÉTODOS DEL MENÚ ------------------------------
    
    private static void aniadirCuerpoCeleste(){
        
        short codigoCuerpo ;
        String nombre ;
        String tipoObjeto ;
        int diametro ;
        
        boolean validador ;
        
        do // Pide y comprueba el código hasta que sea válido
        {
            codigoCuerpo = Utilidades.leerShortBuffer("\nIntroduce el código del cuerpo celeste (3 dígitos max.):") ;
            validador = UtilidadesCuerpoCeleste.compruebaCodigo(codigoCuerpo) ;
            
        } while (!validador);
        
        validador = false ;
        
        do // Pide y comprueba el nombre hasta que sea válido
        {
            nombre = Utilidades.leerStringBuffer("\nIntroduce en el nombre del cuerpo celeste (15 caracteres max.):") ;
            validador = UtilidadesCuerpoCeleste.compruebaNombre(nombre) ;
            
        } while (!validador);
        
        validador = false ;
        
        // Pedimos el tipo de objeto
        
        tipoObjeto = Utilidades.leerStringBuffer("\nIntroduce el tipo de cuerpo celeste:") ;
        
        do // Pide y comprueba el diámetro hasta que sea válido
        { 
            diametro = Utilidades.leerEnteroBuffer("\nIntroduce el diámetro (6 dígitos max.):") ;
            validador = UtilidadesCuerpoCeleste.compruebaDiametro(diametro) ;
            
        } while (!validador);
        
        /*
            Hemos terminado de pedir los datos y han sido comprobados. Si son 
            válidos continuamos almacenándolos.
        */
        
        if (cuerposCelestes.isEmpty()) // Si el array está vacío...
        {
            cuerposCelestes = new ArrayList<CuerpoCeleste>() ; // ... créalo.
        }
        
        try
        {
            cuerposCelestes.add(new CuerpoCeleste(codigoCuerpo, nombre, tipoObjeto, diametro)) ;
        }
        catch(ExcepcionCuerpoCeleste e){
            
            System.out.println(e.getMessage());
        }
        
    }
    
    
    /**
     * Método que nos permite visualizar todos los datos almacenador.
     * Primero comprobamos que el fichero exista.
     * Si existe, lo abrimos y comprobamos que no esté vacío recorriendo todo su contenido.
     */
    private static void listarCuerpoCeleste(){
      
                int contador = 1 ;
                
                for (CuerpoCeleste objeto: cuerposCelestes) 
                {
                    System.out.println("Registro nº " + contador + " - "  + objeto.toString());
                    contador++ ;
                }
    }
         
}
