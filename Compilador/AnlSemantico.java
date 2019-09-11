/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

import java.util.ArrayList;

/**
 *
 * @author Alberto Loera
 */
public class AnlSemantico 
{
    ArrayList<Componente> tokens;
    ArrayList<Simbolos> simbolos;
    String tipo,identificador,valor,salida;
    int posicion,indice;
    Componente componente ;
    boolean error = true;
    public AnlSemantico(ArrayList<Componente> tokens) 
    {
     this.tokens = tokens;
     componente = tokens.get(indice);
     simbolos = new ArrayList<Simbolos>();
     salida = "";
     
    }
    public void getArraySimbolos()
    {
        
    }
    public void tablaDeSimbolos()
    {
        do {
            if (componente.getTipo() == 3) 
            {
                tipo = componente.getToken();
                nexToken();
                posicion = componente.getFila();
                identificador = componente.getToken();
                nexToken();
                if(componente.getToken().equals("="))
                {
                    nexToken();
                  if(tipo.equals("int"))
                  {
                      try
                      {
                      int val = Integer.parseInt(componente.getToken());
                      valor = String.valueOf(val);
                      error = false;
                      }
                      catch(NumberFormatException e)
                      {
                          salida += ("Error Semantico en la linea "+posicion+"\nen el token "+componente.getToken()+
                                    " Se esperaba un valor entero");
                      }
                  }
                  else if(tipo.equals("boolean"))
                  {
                      if(componente.getToken().matches("(true|false)"))
                      {
                          valor = componente.getToken();
                      }
                      else
                      {
                          salida += 
                          "Error Semantico en la linea, linea: "+posicion+"\n"+
                          "en el token:"+componente.getToken()+"Se esperba un dato boolean";
                          
                          error = false;
                      }
                          
                  }
                }
               
               /* posicion = componente.getFila();
                identificador = componente.getToken();
                
                nexToken();
                if(componente.getToken().equals("="))
                {
                    nexToken();
                    valor = componente.getToken();
                }
                System.out.println(tipo +"  "+identificador+"  "+valor+"  "+posicion);
            */}
            if(error == false)
            {
                simbolos.add(new Simbolos(tipo, identificador, valor, posicion));
            }
            error = true;
            
            nexToken();

        } 
      while (componente != null);
        System.out.println(salida);
    }
    public void nexToken()
     {
         try
         {
         indice++;
         componente = tokens.get(indice);
         }catch(IndexOutOfBoundsException e)
         {
             componente = null;
         }
         
     }
    }
  
