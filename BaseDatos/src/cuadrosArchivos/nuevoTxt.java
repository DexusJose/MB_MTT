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
        
        switch(estado){
            case JFileChooser.APPROVE_OPTION:

                if(BaseDatos.debugTexto)
                    JOptionPane.showMessageDialog(null, nuevoArchivo.getSelectedFile()+".txt");
                
                File ntxt = nuevoArchivo.getSelectedFile();
                
                if(!ntxt.exists()){
                
                    FileWriter Ntxt = new FileWriter(ntxt + ".txt");
                    JOptionPane.showMessageDialog(null, nuevoArchivo.getSelectedFile()+".txt");
                }else{
                    JOptionPane.showMessageDialog(null, "El archivo ya existe!");
                }
                
            break;
            case JFileChooser.CANCEL_OPTION:
                dispose();
            break;
            case JFileChooser.ERROR_OPTION:
                
            break;
        }
        
    }
}
