/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import basedatos.BaseDatos;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Almacen
 */
public class SelectorArchivo extends javax.swing.JFrame {
    public final ImageIcon icono = new ImageIcon(BaseDatos.class.getResource("/recursos/icono/AUV.png"));
    private final String RutaPorDefecto = "C:\\Users\\\\Desktop";
    
    JFileChooser selectDialog ;
    
    JFrame textWin;
    File f;
    FileInputStream fis;
    String ruta;
    
    public void archivoSelector() throws FileNotFoundException, IOException{
        
        
        //String ruta = "C:\\Users\\Almacen\\Desktop\\n.txt";
        //String ruta = "C:\\Users\\sangr\\Desktop\\n.txt";
        
        
        selectDialog = new JFileChooser(RutaPorDefecto);
        //selectDialog.showOpenDialog(this);
        selectDialog.setFileFilter(new FileNameExtensionFilter("Archivo de texto *.txt", "txt"));
        
        
        selectDialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int resultado;
        resultado = selectDialog.showOpenDialog(this);
        this.dispose();
        
        switch(resultado) {
            case JFileChooser.APPROVE_OPTION:
            //seleccionó abrir
                crearEditor();
            break;

            case JFileChooser.CANCEL_OPTION:
            //dio click en cancelar o cerro la ventana
                dispose();
             break;

            case JFileChooser.ERROR_OPTION:
            //llega aqui si sucede un error
            break;
        }


    }
    
    public void crearEditor() throws FileNotFoundException, IOException{
        File archivo = selectDialog.getSelectedFile(); // obtiene el archivo seleccionado
        ruta =  archivo.toString();
        System.out.println(archivo);
        // muestra error si es inválido
        if ((archivo == null) || (archivo.getName().equals(""))) {
        JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
        } // fin de if
        
        
        textWin = new JFrame();
        textWin.setTitle("Texto");
        textWin.setSize(800,600);
        textWin.setExtendedState(NORMAL);
        textWin.setIconImage(icono.getImage());
        textWin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        textWin.setLocationRelativeTo(null);
        textWin.setPreferredSize(new Dimension(800,600));
        //textWin.setResizable(false);
        //textWin.setLayout(null);
        //textWin.pack();
        textWin.setVisible(true);
      
        f = new File(ruta);
        System.out.println(f);
        fis= new FileInputStream(f);
        byte[] c = new byte[fis.available()];
        System.out.println(c);
        fis.read(c);
        fis.close();
        String tutexto = new String(c);
        System.out.println(tutexto);

        JTextArea textArea = new JTextArea(50, 100);
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setText(tutexto);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250));
        textWin.add(areaScrollPane);
    }
}
