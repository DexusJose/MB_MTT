/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadrosArchivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ing. Dexus José Pérez <jose_perezmiranda@outlook.com>
 */
public class nuevoDb extends JFrame{

    private JFileChooser nuevoDB;
    private FileNameExtensionFilter filtro;
    
    public void nuevodb() throws IOException{
        
        nuevoDB = new JFileChooser();
        
        filtro = new FileNameExtensionFilter("Archivo de datos .mdb*",".mdb");
        File nuevodb = new File("Nueva base de datos");
        
        int state;
        nuevoDB.setDialogTitle("Nueva Base de datos");
        
        nuevoDB.setFileFilter(filtro);
        nuevoDB.setFileSelectionMode(JFileChooser.FILES_ONLY);
        nuevoDB.addChoosableFileFilter(filtro);
        nuevoDB.setSelectedFile(nuevodb);
        
        state = nuevoDB.showSaveDialog(this);
        
        FileWriter NDB;
        
        File ndb;
        
        switch(state){
            case JFileChooser.APPROVE_OPTION:
                
                ndb = new File(nuevoDB.getSelectedFile() + ".mdb");
                
                if(!ndb.exists()){
                    
                    NDB =new FileWriter(ndb);
                    JOptionPane.showMessageDialog(null, "Guardado en: "+ndb);
                    NDB.close();
                }else{
                    
                    JOptionPane.showMessageDialog(null, "El archivo: \n"+ndb+"\nya existe!");
                    
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
