
package ejercicio4.maestre;


import java.io.Serializable;

/**
 * Clase de la tarea 6 de programación reutilzado para la tarea 7.
 * 
 * @author Adrián Arjona
 * @version 1.1 Marzo 2023
 */
public class CuerpoCeleste implements Serializable{
    
    /* Francisco Adrián Arjona Bravo
        UNIDAD 7: aplicación de las estructuras de almacenamiento.
    */
    
    // DECLARACIÓN DE VARIABLES
    
    private short codigoCuerpo ;
    private String nombre ;
    private String tipoObjeto ;
    private int diametro ;

    
    // CONSTRUCTORES
    
    public CuerpoCeleste() { // CONSTRUCTOR POR DEFECTO
        codigoCuerpo = 0 ;
        nombre = "" ;
        tipoObjeto = "" ;
        diametro = 0 ;
    }
    
    public CuerpoCeleste(short codigoCuerpo, String nombre, String tipoObjeto, int diametro) throws ExcepcionCuerpoCeleste{ // CONSTRUCTOR CON PARÁMETROS
        
        this.setCodigoCuerpo(codigoCuerpo); // El código tiene que ser de tres dígitos como máximo.
        this.setNombre(nombre); // El nombre puede tener 15 caracteres como máximo
        this.tipoObjeto = tipoObjeto;
        this.setDiametro(diametro); // El diámetro no puede ser superior a 6 dígitos.
    }
    
    
    // GETTERS & SETTERS
    

    public int getDiametro() { // GET DE DIÁMETRO
        return diametro;
    }

    public void setDiametro(int diametro) throws ExcepcionCuerpoCeleste{ // CONTROLA QUE EL DIÁMTRO NO SEA SUPERIOR A 6 DÍGITOS
        
        if ((diametro >= 0) && (diametro <= 999999) ) 
        {
            this.diametro = diametro;
        }
        else
        {
            throw new ExcepcionCuerpoCeleste("El diámetro no puede tener más de 6 dígitos. No son necesarias decimales.") ;
        }
    }

    public String getNombre() { // GET DE NOMBRE
        return nombre;
    }

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

    public String getTipoObjeto() { // GET DE TIPO OBJETO
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) { // SET DE TIPO OBJETO
        this.tipoObjeto = tipoObjeto;
    }

    public short getCodigoCuerpo() { // GET DE CÓDIGO CUERPO
        return codigoCuerpo;
    }

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
    
    @Override
    public String toString() {
        return "CÓDIGO = " + codigoCuerpo + "  \tNOMBRE = " + nombre + "    " + " \t\tTIPO = " + tipoObjeto + "  \tDIÁMETRO = " + diametro ;
    }
    
}
