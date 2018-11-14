/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creadorArchivos;

import creadorArchivoN.crearArchivo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Ing. Dexus José Pérez <jose_perezmranda@outlook.com>
 */
public class crearTxt {
    public void crearNtxt(){
        try {
            //String ruta = crearArchivo.path;
            String contenido = "Contenido de ejemplo";
            File file = crearArchivo.path;
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file+".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
