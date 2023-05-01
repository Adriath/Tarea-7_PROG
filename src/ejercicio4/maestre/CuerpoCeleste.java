
package ejercicio4.maestre;

/**
 * Clase de la tarea 6 de programación reutilzado para la tarea 7.
 * 
 * @author Adrián Arjona
 * @version 1.1 Marzo 2023
 */
public class CuerpoCeleste{
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    // DECLARACIÓN DE VARIABLES
    
    private short codigoCuerpo ;
    private String nombre ;
    private String tipoObjeto ;
    private int diametro ;

    
    // CONSTRUCTORES
    
    
    /**
     * Constructor por defecto.
     */
    public CuerpoCeleste() {
        codigoCuerpo = 0 ;
        nombre = "" ;
        tipoObjeto = "" ;
        diametro = 0 ;
    }
    
    
    /**
     * Constructor con parámetros.
     * 
     * @param codigoCuerpo Código del cuerpo celeste.
     * @param nombre Nombre del cuerpo celeste.
     * @param tipoObjeto Tipo de objeto.
     * @param diametro Diámetro del cuerpo celeste.
     * 
     * @throws ExcepcionCuerpoCeleste Lanza excepción del cuerpo celeste.
     */
    public CuerpoCeleste(short codigoCuerpo, String nombre, String tipoObjeto, int diametro) throws ExcepcionCuerpoCeleste{
        
        this.setCodigoCuerpo(codigoCuerpo); // El código tiene que ser de tres dígitos como máximo.
        this.setNombre(nombre); // El nombre puede tener 15 caracteres como máximo
        this.tipoObjeto = tipoObjeto;
        this.setDiametro(diametro); // El diámetro no puede ser superior a 6 dígitos.
    }
    
    
    // GETTERS & SETTERS
    

    /**
     * Método que devuelve el diámetro.
     * 
     * @return Diámetro del cuerpo celeste.
     */
    public int getDiametro() {
        return diametro;
    }

    
    /**
     * Controla que el diámetro no sea superior a 6 dígitos y lo modifica.
     * 
     * @param diametro Diámetro del cuerpo celeste.
     * 
     * @throws ExcepcionCuerpoCeleste Excepción del cuerpo celeste.
     */
    public void setDiametro(int diametro) throws ExcepcionCuerpoCeleste{
        
        if ((diametro >= 0) && (diametro <= 999999) ) 
        {
            this.diametro = diametro;
        }
        else
        {
            throw new ExcepcionCuerpoCeleste("El diámetro no puede tener más de 6 dígitos. No son necesarias decimales.") ;
        }
    }

    /**
     * Método que devuelve el nombre del cuerpo celeste.
     * 
     * @return Nombre del cuerpo celeste.
     */
    public String getNombre() {
        return nombre;
    }
    
    
    /**
     * Controla que el nombre tenga 15 caracteres como máximo y lo modifica.
     * 
     * @param nombre Nombre del cuerpo celeste.
     * 
     * @throws ExcepcionCuerpoCeleste Excepeción del cuerpo celeste.
     */
    public void setNombre(String nombre) throws ExcepcionCuerpoCeleste{ // CONTROLA QUE EL NOMBRE TENGA 15 CARACTERES COMO MÁXIMO
        
        if (nombre.length() <= 15) 
        {
            this.nombre = nombre;
        }
        else
        {
            throw new ExcepcionCuerpoCeleste("El nombre puede tener un máximo de 15 caracteres.") ;
        }
    }

    
    /**
     * Devuelve el tipo de objeto.
     * 
     * @return Tipo de objeto.
     */
    public String getTipoObjeto() {
        return tipoObjeto;
    }

    
    /**
     * Modifica el tipo de objeto.
     * 
     * @param tipoObjeto Tipo de objeto.
     */
    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }
    

    /**
     * Devuelve el código del cuerpo celeste.
     * 
     * @return Código del cuerpo celeste.
     */
    public short getCodigoCuerpo() {
        return codigoCuerpo;
    }

    
    /**
     * Control que el código sea de 3 dígitos y lo modifica.
     * 
     * @param codigoCuerpo Código del cuerpo celeste.
     * 
     * @throws ExcepcionCuerpoCeleste Excepción del cuerpo celeste.
     */
    public void setCodigoCuerpo(short codigoCuerpo)throws ExcepcionCuerpoCeleste{ // CONTROLA QUE EL CÓDIGO SEA DE 3 DÍGITOS
        
        if (codigoCuerpo >= 0 && codigoCuerpo <= 999) 
        {
            this.codigoCuerpo = codigoCuerpo;
        }
        else
        {
            throw new ExcepcionCuerpoCeleste ("El código tiene que ser de tres dígitos como máximo.");
        }
    }

    // MÉTODO TO STRING
    
    /**
     * Método toString() de la clase Cuerpo Celeste.
     * 
     * @return Los elementos del cuerpo celeste.
     */
    @Override
    public String toString() {
        return "CÓDIGO = " + codigoCuerpo + "  \tNOMBRE = " + nombre + "    " + " \t\tTIPO = " + tipoObjeto + "  \tDIÁMETRO = " + diametro ;
    }
    
}
