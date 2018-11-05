/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import static forms.ventanaPrincipal.ventana;
import static forms.ventanaPrincipal.ventanaPadre;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;
import static javax.swing.text.StyleConstants.Size;

/**
 *
 * @author JosePerez
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
        
        System.out.println(
                //ventanaEdit.getFont()
        );
        
        ventanaEdit.setSize(new Dimension(ventana.getMaximumSize())); //a modificar
        ventanaEdit.setClosable(true);
        ventanaEdit.setIconifiable(true);
        ventanaEdit.setMaximizable(true);
        //ventanaEdit.setMaximumSize(ventanaEdit.getSize());
        ventanaEdit.setFont(ventanaPrincipal.FuenteSubtitulo);
        ventanaEdit.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ventanaEdit.setVisible(true);
        ventanaEdit.setBackground(fondo);
        
        System.out.println("Ventana interna creada");
        System.out.println(
                //ventanaEdit.getFont()
                //ventanaEdit.getSize()
                ventanaPrincipal.panelPrincipal.getSize()
        );
        
        
    } 
    
}
