/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import forms.ventanaPrincipal;

/**
 *
 * @author Almacen
 */
public class BaseDatos {

    /**
     * @param args the command line arguments
     */
    
    public static boolean debugTexto = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
        ventanaPrincipal ventana;
        ventana = new ventanaPrincipal();
        ventana.crearventana();
        
        if(debugTexto)
            System.out.println("Ventana principal iniciada.");
    }
    
}
