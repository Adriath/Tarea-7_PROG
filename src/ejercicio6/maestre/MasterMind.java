
package ejercicio6.maestre;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utilidades.Utilidades;

/**
 * EJERCICIO 6
 * Juego del MasterMind.
 * 
 * @author Adrián Arjona
 * @version 1.0 Marzo 2023
 */
public class MasterMind {
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    
    // ---------------- DECLARACIÓN DE VARIABLES -----------------
    
    private int array[] ;
    private int arrayUsuario[] ;
    
    // ------------------ MÉTODOS -----------------------------
    
        // ------ CONSTRUCTOR ---------
    
        public MasterMind(){ // CONSTRUCTOR CON PARÁMETROS
        
            this.array = new int[3];
            this.arrayUsuario = new int[3] ;
        }
    
        // ------- GETTERS & SETTERS ---------

        public int[] getArray() { // GETTER DE ARRAY
            
            return array;
        }
        
        public int[] getArrayUsuario() { // GETTER DE ARRAY USUARIO
            
            return arrayUsuario;
        }
    
        
        // ------ PERSONALIZADOS -------
        
        public void generaValoresAleatorios(int[] array){
            //MÉTODO QUE GENERA TRES NÚMEROS ALEATORIOS Y LOS GUARDA EN EL ARRAY
            
            array[0] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la primera posición.
            array[1] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la segunda posición.
            array[2] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la tercera posición.
            
            this.array = array ;
        }
        
        
        public int[] pideValoresAUsuario(){
            //MÉTODO QUE PIDE LOS VALORES AL USUARIO PARA LUEGO ALMACENARLOS COMO ARRAY DE TIPO ENTERO
            
            String combinacion ;
            boolean validador = false ;
            
            int[] arrayUsuario = new int[3];
            String[] valoresExtraidos = new String[3] ;
            
            do // Ejecuta mientras el valor no sea de 3 dígitos exactos.
            {
                combinacion = String.format("%03d", Utilidades.leerEnteroConDigitosExactos("\nEscribe la combinación de 3 dígitos: ", 3)) ;
                
                if (combinacion.length() < 3) 
                {
                    System.out.println("\nLa combinación debe ser de 3 dígitos.") ;
                }
                else
                {
                    validador = true ;
                }
                
            } while (!validador);
            
            valoresExtraidos = combinacion.split("") ;
            
            for (int i = 0; i < this.arrayUsuario.length; i++) 
            {
                arrayUsuario[i] = Integer.parseInt(valoresExtraidos[i]) ;
            }
            
            return arrayUsuario ;
        }
        
        
        public boolean comparaArrays(int[] array, int[] arrayUsuario){
            // MÉTODO QUE COMPARA LOS ARRAYS
            
            int contadorVerde = 0 ;
            boolean encontrado = false ;
            
            String[] pista = new String[3] ;
            
            List<Integer> resultado = Arrays.stream(array).boxed().collect(Collectors.toList()) ;
            
            for (int i = 0; i < arrayUsuario.length; i++) 
            {
                if (resultado.contains(arrayUsuario[i]) && ( array[i] == arrayUsuario[i]) )
                    /* Si los valores de la combinación introducida están contenidos en 
                    la combinación a adivinar y, además, coinciden las posiciones.
                    
                    Suma al contador para contabilizar si se ha adivinado todo.
                    */
                {
                    pista[i] = Utilidades.coloreaCadena("v", Utilidades.verde) ;
                    
                    contadorVerde++ ;
                }
                
                else if (resultado.contains(arrayUsuario[i]) && ( array[i] != arrayUsuario[i]) ) 
                    /* Si los valores de la combinación introducida están contenidos en
                    la combincación a adivinar pero no coinciden las posiciones.
                    */
                {
                    pista[i] = Utilidades.coloreaCadena("a", Utilidades.amarillo) ;
                }
                
                else
                    // En caso de que no haya coincidencia de ningún tipo.
                {
                    pista[i] = Utilidades.coloreaCadena("r", Utilidades.rojo) ;
                }
            }
            
            if (contadorVerde == 3) 
            {
                encontrado = true ;
            }
            
            for (String i : pista) // Muestra las pistas recogidas.
            {
                System.out.print(i + " ");
            }
            
            contadorVerde = 0 ;
                /* El contador vuelve a ser 0 porque este método está pensado para ser ejecutado en un bucle.
                Siguiendo esta lógica, si no reiniciamos el valor, se va a acumular el conteo de los aciertos (verde) 
                de un intento a otro. Al reiniciarlo se comienza a 0 en cada interacción por lo que solamente se puede 
                llegar a 3 si se adivina en el mismo intento.
                */
            
            return encontrado ;
        }
        
        public boolean jugar(){
            // MÉTODO PARA JUGAR UNA PARTIDA AL MASTERMIND.
            
            int intentos = 1 ;
            boolean encontrado = false ;
            
            String[] pista = new String[3] ;
            
            generaValoresAleatorios(this.array) ; // Genera y asigna los dígitos aleatorios que habrá que adivinar
            
            while (intentos <= 7 && !encontrado) {
                // Si no se han superado los intentos y no se ha adivinado la combinación, ejecuta el código
                
                System.out.println("\nINTENTO " + intentos); // Indica por pantalla el intento en curso
                System.out.println("---------------");
                
                for (int i : array) { // -------- BUCLE FOR PARA PRUEBAS. COMENTAR PARA QUE NO APAREZCA EL RESULTADO -------------
                    
                    System.out.print(i + " ");
                }
                
                this.arrayUsuario = pideValoresAUsuario() ; // Pide los valores y los almacena
                
                encontrado = comparaArrays(this.array, this.arrayUsuario) ; // Compara las combinaciones, imprime las pistas y evualúa si se ha adivinado.                
                
            }
            
            return encontrado ;
        }
        
        // --------------------------------------------------------------------------------------------------
        
        public static void main(String[] args) { // -------- MAIN DE PRUEBAS --------------
        int array[] = new int[3];
        int arrayUsuario[] = new int[3] ;
        String pista[] = new String[3] ;
        
        boolean encontrado = false ;
        
        MasterMind partida1 = new MasterMind() ;
        
        array = partida1.getArray() ;
        
        
        partida1.generaValoresAleatorios(array);
        
            for (int i : array) {
                System.out.print(i + " ");
            }
            
        arrayUsuario = partida1.pideValoresAUsuario() ;
        
        partida1.comparaArrays(array, arrayUsuario);
        
    }
}
