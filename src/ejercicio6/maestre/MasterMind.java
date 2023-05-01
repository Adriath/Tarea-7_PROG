
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
    
    /* 
        NOTA IMPORTANTE:
        -----------------------------------------------------------
        He dejado habilitado un método dentro de jugar() llamado muestraArray().
        Sirve para que la combincación sea visible y así facilitar tanto las pruebas 
        como la corrección.
        Si se quiere desactivar basta con comentar esa línea de código.
        -----------------------------------------------------------
    */ 
    
    
    // ---------------- DECLARACIÓN DE VARIABLES -----------------
    
    private int array[] ;
    private int arrayUsuario[] ;
    
    // ------------------ MÉTODOS -----------------------------
    
        // ------ CONSTRUCTOR ---------
    
        
        /**
         * Constructor por defecto.
         */
        public MasterMind(){
        
            this.array = new int[3];
            this.arrayUsuario = new int[3] ;
        }
    
        
        // ------- GETTERS & SETTERS ---------

        
        /**
         * Método que devuelve el array.
         * 
         * @return Devuelve un array de tipo entero.
         */
        public int[] getArray() {
            
            return array;
        }
        
        /**
         * Método que devuelve el array del usuario.
         * 
         * @return Devuelve el array del usuario.
         */
        public int[] getArrayUsuario() {
            
            return arrayUsuario;
        }
    
        
        // ------ PERSONALIZADOS -------
        
        
        /**
         * Método que gene4ra tres números aleatorios y los guarda en el array.
         * 
         * @param array Array que guarda la combinación a adivinar.
         */
        public void generaValoresAleatorios(int[] array){
                        
            array[0] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la primera posición.
            array[1] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la segunda posición.
            array[2] = Utilidades.numeroAleatorioDesdeoCero(10) ; // Genera número del 0 al 9 y lo guarda en la tercera posición.
            
            this.array = array ;
        }
        
        
        /**
         * Método que pide los valres al usuario para luego almacenarlos com oarray de tipo entero.
         * 
         * @return Devuelve un array de tipo entero.
         */
        public int[] pideValoresAUsuario(){
                        
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
        
        
        /**
         * Método que compara los arrays. Contará los aciertos (color verde). Se 
         * considera encontrado si se han adivinado los tres dígitos.
         * 
         * @param array Array con la combinación a adivinar.
         * @param arrayUsuario Array del usuario.
         * @return Duvuelve true si los tres dígitos coinciden, false si no.
         */
        public boolean comparaArrays(int[] array, int[] arrayUsuario){
            
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
            
            System.out.println("");
            for (String i : pista) // Muestra las pistas recogidas.
            {
                System.out.print(i + " ");
            }
            System.out.println("");
            
            contadorVerde = 0 ;
                /* El contador vuelve a ser 0 porque este método está pensado para ser ejecutado en un bucle.
                Siguiendo esta lógica, si no reiniciamos el valor, puede que se acumule el conteo de los aciertos (verde) 
                de un intento a otro. Al reiniciarlo se comienza a 0 en cada interacción por lo que solamente se puede 
                llegar a 3 si se adivina en el mismo intento.
                */
            
            return encontrado ;
        }
        
        
        /**
         * Método privado que muestra el array. Pensado para pruebas y corrección.
         * 
         * @param array Array que se quiere mostrar.
         */
        private void muestraArray(int array[]){
            
            for (int i : array) 
            {
                System.out.print(i + " ");
            }
        }
        
        
        /**
         * Método que planifica una partida a MasterMind.
         * 
         * @return Devuelve true si se ha conseguido dentro de los intentos permitidos y false si no.
         */
        public boolean jugar(){
            
            int intentos = 1 ;
            boolean encontrado = false ;
            
            String[] pista = new String[3] ;
            
            generaValoresAleatorios(this.array) ; // Genera y asigna los dígitos aleatorios que habrá que adivinar
            
            while (intentos <= 7 && !encontrado) {
                // Si no se han superado los intentos y no se ha adivinado la combinación, ejecuta el código
                
                System.out.println("\nINTENTO " + intentos); // Indica por pantalla el intento en curso
                System.out.println("---------------");
                
                muestraArray(array); // -------- BUCLE FOR PARA PRUEBAS. COMENTAR PARA QUE NO APAREZCA EL RESULTADO -------------                    

                
                this.arrayUsuario = pideValoresAUsuario() ; // Pide los valores y los almacena
                
                encontrado = comparaArrays(this.array, this.arrayUsuario) ; // Compara las combinaciones, imprime las pistas y evualúa si se ha adivinado
                
                intentos++ ;
                
                if (encontrado) 
                {
                    System.out.println("\n¡Enhorabuena, has adivinado la combinación!") ;
                    System.out.println("Has utilizado " + (intentos - 1) + " intento/s.") ;
                }
                
            }
            
            return encontrado ;
        }
        
}
