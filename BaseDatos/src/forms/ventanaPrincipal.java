/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import BaseDatos.*;
import basedatos.BaseDatos;
import com.sun.prism.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Almacen
 */
public class ventanaPrincipal {
    public static JFrame ventana;
    public static JPanel panelPrincipal;
    public static JDesktopPane ventanaPadre;
    public static final Color fondoBarra = new Color(51, 204, 204);
    public Color fondoVentana = new Color(102, 179, 255);
    
    public static final Font FuenteTitulos = new Font("Arial",Font.BOLD,14);
    public static final Font FuenteSubtitulo = new Font("Arial",Font.BOLD,13);
    
    public JMenuBar menuBar;
    
    public JMenu barLateral;
    
    //Menus de la barra superior.
    public JMenu m_Archivo;
    
    //Submenus de la barra superior.
    public JMenuItem m_salir,m_nuevo,m_abrir;
    
    //Menus de la barra lateral izquierda.
    public JMenu Catalogo,Producto;
    
    //Submenus de la barra lateral izquierda.
    //public JMenuItem m_Catalogo;
    
    
    
    
    public final ImageIcon icono = new ImageIcon(BaseDatos.class.getResource("/recursos/icono/AUV.png"));
    public  void crearventana(){
        configurarVentana();
    }

    private void configurarVentana()  {
        ventana         = new JFrame();
        panelPrincipal  = new JPanel();
        ventanaPadre    = new JDesktopPane();
        menuBar         = new JMenuBar();
        barLateral      = new JMenu();
        
        ventana.getContentPane().setLayout(new BorderLayout());
        ventana.getContentPane().add(menuBar,BorderLayout.NORTH);
        ventana.getContentPane().add(barLateral,BorderLayout.WEST);
        
        // declaracion de menu superior
        m_Archivo = new JMenu("Archivo"); 
        m_Archivo.setFont(FuenteTitulos);
        
        //declaracion del menu lteral izquierdo
        Catalogo = new JMenu("Catalogo");
        Producto = new JMenu("Producto");
        
        //creacion de los items del menu;
        m_nuevo = new JMenuItem("Nuevo archivo");
        m_abrir = new JMenuItem("Abrir");
        m_salir = new JMenuItem("Salir");
        
        //Asignacion de la fuente Global
        m_nuevo.setFont(FuenteSubtitulo);
        m_abrir.setFont(FuenteSubtitulo);
        m_salir.setFont(FuenteSubtitulo);
        
        //Creacion de la seccion del menu
        menuBar.add(m_Archivo);
        
        //agregado de items del menu superior
        m_Archivo.add(m_nuevo);
        
        m_Archivo.add(m_abrir);
        
        m_Archivo.add(m_salir);
        
        //Creacion de la seccion del menu lateral        
        barLateral.add(Catalogo);
        barLateral.add(Producto);
        
        menuBar.setBackground(fondoBarra);
        
        m_nuevo.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        InternalText editorMini;
                        editorMini = new InternalText();
                        editorMini.textEditIn();
                        ventanaPadre.add(editorMini.ventanaEdit);
                    }
                }
        );
        
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
        ventana.add(panelPrincipal);
        ventana.getContentPane().add(ventanaPadre).setBackground(fondoVentana);
        ventana.setSize(MAXIMIZED_BOTH, MAXIMIZED_BOTH);
        ventana.setExtendedState(MAXIMIZED_BOTH);
        ventana.getContentPane().setBackground(fondoVentana);
        ventana.setIconImage(icono.getImage());
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.pack();
        
        ventana.setVisible(true);
        //ventana.setJMenuBar(menuBar);
        //ventana.setJMenuBar(barLateral);
        
        if(BaseDatos.debugTexto)
            System.out.println(m_Archivo.getSize());
        
    }
    
    
}
