/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import basedatos.BaseDatos;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;


/**
 *
 * @author Ing. Dexus José Pérez.
 */
public class InternalText {
    
    public JInternalFrame ventanaEdit;
    private Color fondo = new Color(199,192,224);
    
    public void textEditIn(){
        crearInternalEdit();
    }
    
    public void crearInternalEdit(){
        
        ventanaEdit = new JInternalFrame();
        ventanaEdit.setTitle("Editor mini");
        if(BaseDatos.debugTexto){
            System.out.println(ventanaEdit.getFont() + "\n" + ventanaEdit.getSize() );
        }
        
        ventanaEdit.setSize(new Dimension(500,500)); //a modificar
        ventanaEdit.setClosable(true);
        ventanaEdit.setIconifiable(true);
        ventanaEdit.setMaximizable(true);
        ventanaEdit.setFont(ventanaPrincipal.FuenteSubtitulo12);
        ventanaEdit.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaEdit.setVisible(true);
        ventanaEdit.setBackground(fondo);
        if(BaseDatos.debugTexto){
        System.out.println("Ventana interna creada");
        System.out.println(
                //ventanaEdit.getFont()
                //ventanaEdit.getSize()
                ventanaPrincipal.panelPrincipal.getSize()
        );
        }
        
    } 
    
}
