/*
 * Esta es la clase principal del programa.
 *
 */
package basedatos;

import forms.ventanaPrincipal;

/**
 *
 * @author Ing. Dexus José Pérez.
 */
public class BaseDatos {

    /**
     * @param args the command line arguments
     */
    
    public static boolean debugTexto = true;   //Boleano de control para debug
    
    public static void main(String[] args) {
        
        
        ventanaPrincipal ventana;
        ventana = new ventanaPrincipal();
        ventana.crearventana();
        
        if(debugTexto)
            System.out.println("Ventana principal iniciada.");
    }
    
}
