/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;


import basedatos.BaseDatos;
import cuadrosArchivos.nuevoTxt;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Ing. Dexus José Pérez.
 */
public class ventanaPrincipal {
    
    //Variables Globales para su uso en las diferentes clases.
    
    //********* Variables de las ventanas y contenedores. ***********
    
    public static JFrame ventana;   // Ventana principal del programa.
    
    // Variables de los paneles de las ventanas.
    public static JPanel panelPrincipal,m_panelLateral,panelTabs; 
    
    public static JDesktopPane ventanaPadre;
    
    //Declaracion de los botones.
    public JButton b_Refacciones,b_Proveedores;
    
    //Barra de menu.
    public JMenuBar menuBar;
            
    //Menus de la barra superior.
    public JMenu m_Archivo;
    
    //Submenus de la barra superior.
    public JMenuItem m_salir,m_nuevo,m_abrir;
    
    //Subsubmenu de la barra superior
    public JMenuItem sm_nuevoTxt;
    
    //Menus de la barra lateral izquierda.
    public JMenu Catalogo,Producto;
    
    //******* Variables de los colores y fuentes del programa. *********
    
    public static final Color   fondoBarra          = new Color(51, 204, 204);
    
    public static final Color   fondoVentana        = new Color(102, 179, 255);
    
    public static final Color   fondoPLateral       = new Color(171,194,194);
    
    public static final Color   fondoBtLateral      = new Color(235,230,222);
    
    public static final Font    FuenteTitulos14     = new Font("Arial",Font.PLAIN,14);
    
    public static final Font    FuenteSubtitulo12   = new Font("Arial",Font.PLAIN,12);
    
    public static final Font    FuenteSubtitulo10   = new Font("Arial",Font.PLAIN,10);
    
    
    //Variable contenedora del icono del programa
    public final ImageIcon icono = new ImageIcon(BaseDatos.class.getResource("/recursos/icono/icon.png"));
    
    //Metodo para la creacion de la ventana principal
    public void crearventana(){
        
        configurarVentana();    //Llamada a la funcion de creacion de la ventana
        
    }

    private void configurarVentana()  {
        
        final int colpanPrin  = 2;
        final int filpanPrin  = 0;
        final int seppanPrinV = 20;
        final int seppanPrinH = 20;
        
        ventana         = new JFrame();
        menuBar         = new JMenuBar();
        panelPrincipal  = new JPanel();
        m_panelLateral  = new JPanel();
        ventanaPadre    = new JDesktopPane();
                
        panelPrincipal.setLayout(new GridLayout(filpanPrin,colpanPrin,seppanPrinH,seppanPrinV));
        
        //**** Codigo para el panel Lateral.
        final int columnas      =  1;
        final int filas         = 26;
        final int separacionV   =  1;
        final int separacionH   =  0;
        
        m_panelLateral.setLayout(new GridLayout(filas,columnas,separacionH,separacionV));
        m_panelLateral.setBackground(fondoPLateral);
        
        //Botones del panel lateral.
        
        b_Refacciones   = new JButton("Refacciones");
        b_Proveedores   = new JButton("Proveedores");
        
        // Creación del botón Refacciones.
        
        b_Refacciones.setFont(FuenteSubtitulo12);
        b_Refacciones.setForeground(Color.BLACK);
        b_Refacciones.setBackground(fondoBtLateral);
        m_panelLateral.add(b_Refacciones);
        
        //Creación del botón Proveedores.
        b_Proveedores.setFont(FuenteSubtitulo12);
        b_Proveedores.setForeground(Color.BLACK);
        b_Proveedores.setBackground(fondoBtLateral);
        m_panelLateral.add(b_Proveedores);
        
        //***** Codigo de la ventana principal
        ventana.getContentPane().setLayout(new BorderLayout());
        ventana.getContentPane().add(menuBar,BorderLayout.NORTH);
        ventana.getContentPane().add(m_panelLateral,BorderLayout.WEST);
        
        //Declaracion de menu superior
        m_Archivo = new JMenu("Archivo"); 
        m_Archivo.setFont(FuenteTitulos14);
        
        //declaracion del menu lteral izquierdo
        Catalogo = new JMenu("Catalogo");
        Producto = new JMenu("Producto");
        
        //creacion de los items del menu;
        m_nuevo = new JMenu("Nuevo archivo...");
        m_abrir = new JMenuItem("Abrir archivo");
        m_salir = new JMenuItem("Salir");
        
        //Creación de los Subsubmenus del la barra.
        sm_nuevoTxt = new JMenuItem("Nuevo archivo .TXT");
        
        //Asignacion de la fuente Global
        m_nuevo.setFont(FuenteSubtitulo12);
        m_abrir.setFont(FuenteSubtitulo12);
        m_salir.setFont(FuenteSubtitulo12);
        
        //Asignacion de las fuentes para submenu nuevo archivo
        sm_nuevoTxt.setFont(FuenteSubtitulo12);
        
        
        //Creacion de la seccion del menu
        menuBar.add(m_Archivo);
        
        //Creación de los submenus
        m_nuevo.add(sm_nuevoTxt);
        
        //agregado de items del menu superior
        m_Archivo.add(m_nuevo);
        
        m_Archivo.add(m_abrir);
        
        m_Archivo.add(m_salir);
        
                
        menuBar.setBackground(fondoBarra);
        
        //***** Listeners de los menus ********
        
        sm_nuevoTxt.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(BaseDatos.debugTexto)
                        JOptionPane.showMessageDialog(null, "Click en nuevo txt");
                    
                    nuevoTxt ntxt = new nuevoTxt();
                    ntxt.archivotxt();
                } catch (IOException ex) {
                    Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        }
        );
        
//        m_nuevo.addActionListener(
//                new ActionListener(){
//                    public void actionPerformed(ActionEvent e){
//                        InternalText editorMini;
//                        editorMini = new InternalText();
//                        editorMini.textEditIn();
//                        ventanaPadre.add(editorMini.ventanaEdit);
//                        crearArchivo nCArchivo;
//                        nCArchivo = new crearArchivo();
//                        
//                        nCArchivo.selectorNArchivo();
//
//                    }
//                }
//        );
        
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
                        
                        ventana.dispose();      //cambio sobre el metodo de cerrar la ventana.
                    
                    }
                }
        );
        
        
        ventana.setTitle("Administración MTTO");
        ventanaPadre.add(panelPrincipal);
        ventana.add(ventanaPadre,BorderLayout.CENTER);
        ventana.getContentPane().add(ventanaPadre).setBackground(fondoVentana);
        ventana.setPreferredSize(new Dimension(800,600));
        ventana.getContentPane().setBackground(fondoVentana);
        ventana.setIconImage(icono.getImage());
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        if(BaseDatos.debugTexto){
            ventana.setExtendedState(ICONIFIED);
        }else{
            ventana.setExtendedState(MAXIMIZED_BOTH);
        }
        ventana.setResizable(true);
        
        
        if(BaseDatos.debugTexto)
            
            System.out.println(m_Archivo.getSize() + "\n" + "Height:" + panelPrincipal.getHeight());
        
    }
    
    
}
