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
public class AnlSemantico {

    ArrayList<Componente> tokens;
    ArrayList<Simbolos> simbolos;
    Simbolos aux;
    String tipo, identificador, valor, salida;
    int posicion, indice, tamaño;
    Componente componente;
    boolean error = true;

    public AnlSemantico(ArrayList<Componente> tokens) {
        this.tokens = tokens;
        componente = tokens.get(indice);
        simbolos = new ArrayList<Simbolos>();
        salida = "";
        simbolos.clear();

    }

    public void getArraySimbolos() {

    }

    public void motorSemantico() {

        do {
            if(componente.getTipo() == Componente.PALABRA_RESERVADA && componente.getToken().equals("class"))
            {
                tipo = "clase";
                nexToken();
                posicion = componente.getFila();
                identificador = componente.getToken();
                error = false;
                añadirATabla();
            }
            else if (componente.getTipo() == Componente.TIPO)
            {
                tipo = componente.getToken();
                nexToken();
                posicion = componente.getFila();
                identificador = componente.getToken();
                if (!buscarCoincidencia(identificador)) 
                {
                    error = false;
                    nexToken();
                    if (componente.getToken().equals("=")) 
                    {
                        nexToken();
                        if (tipo.equals("int")) 
                        {
                            try 
                            {
                                int val = Integer.parseInt(componente.getToken());
                                valor = String.valueOf(val);
                                tamaño = 1;
                                error = false;
                                
                            } 
                            catch (NumberFormatException e) 
                            {
                                salida += ("\tError Semantico en la linea " + posicion + " en el token " + componente.getToken()
                                        + " Se esperaba un valor entero");
                            }
                        } 
                        else if (tipo.equals("boolean")) 
                        {
                            if (componente.getToken().matches("(true|false)")) 
                            {
                                valor = componente.getToken();
                                tamaño = 1;
                                
                            } 
                            else 
                            {
                                salida
                                        += "\tError Semantico en la linea, linea: " + posicion
                                        + " en el token:" + componente.getToken() + " Se esperba un dato boolean";
                                

                            }
                        } 
                        else if (tipo.equals("String")) 
                        {
                            if (componente.getToken().charAt(0) == '\"' && componente.getToken().charAt(componente.getToken().length() - 1) == '\"') {
                                valor = componente.getToken();
                                tamaño = componente.getToken().length();
                                error = false;
                            } else{
                                salida
                                        += "\tError Semantico en la linea, linea: " + posicion
                                        + " en el token: " + componente.getToken() + " Se esperaba el token \"";                               
                            }
                        }
                    } 
                    añadirATabla();            
                }             
                else
                {
                    error  = true;
                    salida += ("\tError semantico en la linea " + posicion + " en el token \""
                           + componente.getToken()+ "\" la variable ya esta declarada anteriormente");
                }
            }
            else if (componente.getTipo() == Componente.IDENTIFICADOR ) 
            {
                
                if (buscarCoincidencia(componente.getToken())) 
                {
                 
                }
                else
                {
                    error = true;
                    salida += ("\tError semantico en la linea " + posicion + " en el token \""
                           + componente.getToken()+ "\" la variable no esta declarada anteriormente");
                }
            }
            error = true;
            valor = "";

            nexToken();

        } while (componente != null);
        System.out.println(salida);
        for (Simbolos s : simbolos) {
            System.out.println("Token " + s.getIdentificador() + " tipo " + s.getType() + " valor " + s.getValor());
        }
    }

    public void nexToken() {
        try {
            indice++;
            componente = tokens.get(indice);
        } catch (IndexOutOfBoundsException e) {
            componente = null;
        }
    }

    public String getSalida() {
        return salida;
    }

    public boolean buscarCoincidencia(String identificador) {
        boolean bandera = false;
        for (Simbolos c : simbolos) {
            if (c.getIdentificador().equals(identificador)) {
                bandera = true;
                aux = c;
                break;
            }
        }
        return bandera;
    }
    public void añadirATabla()
    {
        if (error == false) 
            {
                simbolos.add(new Simbolos(tipo, identificador, valor, posicion));
            }
    }
    public ArrayList getTablaSimbolos()
    {
        return simbolos;
    }
}
