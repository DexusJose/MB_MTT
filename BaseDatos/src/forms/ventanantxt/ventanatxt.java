/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms.ventanantxt;

import forms.ventanaPrincipal;
import static forms.ventanaPrincipal.panelPrincipal;
import static forms.ventanaPrincipal.ventanaPadre;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Almacen
 */
public class ventanatxt extends JInternalFrame{
    
    JInternalFrame ventanaTxt;
    
    
    
    public void abrirventanatxt(){
        
        JOptionPane.showMessageDialog(null, "internal frame creado");
        ventanaTxt =new JInternalFrame();
        ventanaTxt.setTitle("texto");
        ventanaTxt.setSize(800,600);
        ventanaTxt.setPreferredSize(new Dimension(800,600));
        ventanaTxt.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ventanaTxt.setClosable(true);
        ventanaTxt.setMaximizable(true);
        ventanaTxt.setVisible(true);
        ventanaPadre.add(ventanaTxt);
        
    }
    
}
