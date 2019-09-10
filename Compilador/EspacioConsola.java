/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Alberto Loera
 */
public class EspacioConsola extends JScrollPane 
{
    JTextPane textoConsola;
    
    public EspacioConsola() 
    {
        
     textoConsola = new JTextPane();
     setViewportView(textoConsola);
 
     updateUI();
    }
    public JTextPane getTextPaneConsola()
    {
        return textoConsola;
    }
    public void setTextoConola(String s)
    {
        textoConsola.setText(s);
    }
  
            
    
}
