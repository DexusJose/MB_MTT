/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import BaseDatos.*;
import basedatos.BaseDatos;
import com.sun.prism.Image;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Almacen
 */
public class ventanaPrincipal {
    JFrame ventana;
    public Color fondoBarra = new Color(51, 204, 204);
    public Color fondoVentana = new Color(102, 179, 255);
    public JMenuBar menuBar;
    public JMenu m_Archivo;
    public JMenuItem m_salir,m_nuevo,m_abrir;
    
    public final ImageIcon icono = new ImageIcon(BaseDatos.class.getResource("/recursos/icono/AUV.png"));
    public  void crearventana(){
        configurarVentana();
    }

    private void configurarVentana()  {
        ventana = new JFrame();
        menuBar = new JMenuBar();
        
        // declaracion de menu
        m_Archivo = new JMenu("Archivo"); 
        m_salir = new JMenuItem("Salir");
        m_nuevo = new JMenuItem("Nuevo archivo");
        m_abrir = new JMenuItem("Abrir");
        
        //agregado deitems del menu
        m_Archivo.add(m_nuevo);
        
        m_Archivo.add(m_abrir);
        
        m_Archivo.add(m_salir);
        
        menuBar.add(m_Archivo);
        menuBar.setBackground(fondoBarra);
        
        m_abrir.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        SelectorArchivo selector;
                        selector = new SelectorArchivo();
                        try {
                            selector.archivoSelector();
                        } catch (IOException ex) {
                            Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
        });
        
        m_salir.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        //System.exit(EXIT_ON_CLOSE);
                        ventana.dispose();      //cambio sobre el metodo de cerrar la ventana.
                    }
                }
        );
        
        
        ventana.setTitle("Administración MTTO");
        
        ventana.setSize(MAXIMIZED_BOTH, MAXIMIZED_BOTH);
        ventana.setExtendedState(MAXIMIZED_BOTH);
        ventana.getContentPane().setBackground(fondoVentana);
        ventana.setIconImage(icono.getImage());
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setJMenuBar(menuBar);
        
        
        
    }
    
    
}
