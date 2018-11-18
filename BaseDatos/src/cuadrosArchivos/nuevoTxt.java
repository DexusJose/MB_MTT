/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadrosArchivos;

import basedatos.BaseDatos;
import forms.ventanaPrincipal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Almacen
 */
public class nuevoTxt extends JFrame {
    
    public JFileChooser nuevoArchivo;
    
    public FileNameExtensionFilter filtro;
    
    public static final ImageIcon icono = new ImageIcon(BaseDatos.class.getResource("/recursos/icono/icon.png"));
    
    public void archivotxt() throws IOException{
        
        nuevoArchivo = new JFileChooser();
        
        
        filtro = new FileNameExtensionFilter("Archivo de texto .txt*",".txt");
        File archivoDef = new  File("Nuevo");
        
        int estado;
        
        
        nuevoArchivo.setDialogTitle("Nuevo txt");
        
        nuevoArchivo.setFileFilter(filtro);
        nuevoArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        nuevoArchivo.addChoosableFileFilter(filtro);
        nuevoArchivo.setSelectedFile(archivoDef);
        
        estado = nuevoArchivo.showSaveDialog(this);
        FileWriter Ntxt;
        
        File ntxt;
        
        switch(estado){
            case JFileChooser.APPROVE_OPTION:

                if(BaseDatos.debugTexto)
                    JOptionPane.showMessageDialog(null,nuevoArchivo.getSelectedFile()+".txt");
                ntxt = new File(nuevoArchivo.getSelectedFile()+".txt");
                if(BaseDatos.debugTexto)
                    System.out.print("Boleano de archivo existente: " + ntxt.exists());
                
                if(!ntxt.exists()){
                
                    Ntxt = new FileWriter(ntxt);
                    JOptionPane.showMessageDialog(null, "Guardado en:" + ntxt);
                    Ntxt.close();
                }else{
                    JOptionPane.showMessageDialog(null, "El archivo:\n" +ntxt+ "\nya existe!");
                }
                
                dispose();
                
            break;
            case JFileChooser.CANCEL_OPTION:
                dispose();
            break;
            case JFileChooser.ERROR_OPTION:
                
            break;
        }
        
    }
}
