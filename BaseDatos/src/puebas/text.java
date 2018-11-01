/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puebas;

import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Almacen
 */
public class text {
    
//    public void main(String[] args) throws IOException{
//    
//    /**
//     *
//     * @throws FileNotFoundException
//     * @throws IOException
//     */
//    text tx = new text();
//    tx.texto();
//    }
    public void texto() throws FileNotFoundException, IOException{
    //cargar el fichero
            String ruta = "C:\\Users\\Almacen\\Desktop\\n.txt";
            File f = new File(ruta);
            System.out.println("OK");
            FileInputStream fis = new FileInputStream(f);
            byte[] c = new byte[fis.available()];
            fis.read(c);
            fis.close();
            String tutexto = new String(c);
//Insertar el texto del fichero en un objeto de texto.
//Tambien puedes utilizar un JEditorPane y otros
            JTextArea textArea = new JTextArea(5, 10);
            textArea.setFont(new Font("Serif", Font.ITALIC, 16));
            textArea.setText(tutexto);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane areaScrollPane = new JScrollPane(textArea);
            areaScrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            areaScrollPane.setPreferredSize(new Dimension(250, 250));
        }
    

}
