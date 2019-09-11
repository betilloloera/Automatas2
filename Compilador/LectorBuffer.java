/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alberto Loera
 */
public class LectorBuffer 
{
    String cadena = "";
    
    FileReader lectura;
    File archivo;
    JFileChooser buscador ;
     

      public LectorBuffer(JTextPane areaTexto) throws FileNotFoundException, IOException 
    {
        String lineas = "";
        buscador = new JFileChooser();
        buscador.setCurrentDirectory(new File("C:\\Users\\Alberto Loera\\Desktop\\Loker"));
        buscador.addChoosableFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt"));
        buscador.showOpenDialog(buscador);
        archivo = (buscador.getSelectedFile());
        try
        {
        lectura = new FileReader(archivo);
        BufferedReader bufer = new BufferedReader(lectura);
       
        if(archivo.canRead())
        {
            areaTexto.setText("");
            while((lineas = bufer.readLine()) != null)
            {
                areaTexto.setText(areaTexto.getText()+lineas+"\n");
            }     
        }
        else
        {
            JOptionPane.showConfirmDialog(null,"Este archivo no se puede abrir elija un .txt");
        }
        }
        catch(IOException e)
        {
            System.out.println("Hubo un error en el archivo al quererlo leer");
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"No se eligio ningun arhcivo");
        }
    }
    
    
}    

