/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creadorArchivoN;

import archivos.crearTxt;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ing. Dexus José Pérez <jose_perezmranda@outlook.com>
 */
public class crearArchivo  extends javax.swing.JFrame{
    
    public JFileChooser n_Archivo;
    
    public FileNameExtensionFilter filtroArchivo;
    
    String texto= ".txt";
    
    public static File path;
    
    public void selectorNArchivo(){
        
        n_Archivo = new JFileChooser();
        filtroArchivo = new FileNameExtensionFilter("Archivo de texto *.txt",".txt");
        
        int estado;
        n_Archivo.setFileFilter(filtroArchivo);
        n_Archivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        estado = n_Archivo.showSaveDialog(this);
        
        this.dispose();
        
        switch(estado){
            case JFileChooser.APPROVE_OPTION:
                crearTxt tex = new crearTxt();
                conCrAr();
                tex.crearNtxt();
                
            break;
            case JFileChooser.CANCEL_OPTION:
                
            break;
            case JFileChooser.ERROR_OPTION:
                
            break;
        }
        
        
    }
    
    public void conCrAr(){
        
        String array[] = filtroArchivo.getExtensions();
        
        
        StringBuffer cadena = new StringBuffer();
        for (int x=0;x<array.length;x++){
            cadena =cadena.append(array[x]);
        }
        
        
        JOptionPane.showMessageDialog(null,"Guardado en: "+ n_Archivo.getSelectedFile()+cadena + "\n");
        path = n_Archivo.getSelectedFile();
//        try{
//            if(path !=null){
//            
//                FileWriter  save = new FileWriter(path + ".txt");
//                //save.write(areaDeTexto.getText());
//                //save.close();
//                JOptionPane.showMessageDialog(null,
//                "El archivo se a guardado Exitosamente",
//                "Información",JOptionPane.INFORMATION_MESSAGE);
//             }
//        }
//        catch(IOException ex){
//            JOptionPane.showMessageDialog(null,
//            "Su archivo no se ha guardado",
//            "Advertencia",JOptionPane.WARNING_MESSAGE);
//        }
    }
    
}
