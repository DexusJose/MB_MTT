/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Almacen
 */
public class SelectorArchivo extends javax.swing.JFrame {
    
    public void archivoSelector() throws FileNotFoundException, IOException{
        
        JFrame textWin = new JFrame();
        textWin.setTitle("Texto");
        textWin.setSize(800,600);
        textWin.setExtendedState(NORMAL);
        textWin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //textWin.setLocationRelativeTo(null);
        //textWin.setResizable(false);
        //textWin.setLayout(null);
        //textWin.pack();
        textWin.setVisible(true);
        
//        JScrollPane scroll = new JScrollPane();
//        textWin.add(scroll,BorderLayout.CENTER);
        
        
        
        //String ruta = "C:\\Users\\Almacen\\Desktop\\n.txt";
        String ruta = "C:\\Users\\sangr\\Desktop\\n.txt";
        File f = new File(ruta);
        System.out.println(f);
        FileInputStream fis = new FileInputStream(f);
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
        //areaScrollPane.setVisible(true);
        
//        JFileChooser selectDialog ;
//        selectDialog = new JFileChooser();
//        
//        selectDialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//        
//        int resultado;
//        resultado = selectDialog.showOpenDialog(this);
//        this.dispose();
    }
}
