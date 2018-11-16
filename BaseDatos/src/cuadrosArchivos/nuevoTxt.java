/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadrosArchivos;

import basedatos.BaseDatos;
import creadorArchivos.crearTxt;
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
    
    public void archivotxt(){
        
        nuevoArchivo = new JFileChooser();
        
        filtro = new FileNameExtensionFilter("Archivo de texto .txt*",".txt");
        
        int estado;
        
        nuevoArchivo.setDialogTitle("Nuevo txt");
        nuevoArchivo.setFileFilter(filtro);
        nuevoArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        nuevoArchivo.addChoosableFileFilter(filtro);
        
        estado = nuevoArchivo.showSaveDialog(this);
        
        switch(estado){
            case JFileChooser.APPROVE_OPTION:
//                crearTxt tex = new crearTxt();
//                conCrAr();
//                tex.crearNtxt();
                if(BaseDatos.debugTexto)
                    JOptionPane.showMessageDialog(null, nuevoArchivo.getSelectedFile());
                
            break;
            case JFileChooser.CANCEL_OPTION:
                dispose();
            break;
            case JFileChooser.ERROR_OPTION:
                
            break;
        }
        
    }
}
