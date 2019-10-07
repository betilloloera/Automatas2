/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

/**
 *
 * @author Alberto Loera
 */
public class Simbolos 
{
	private String desc,token;
	private int tipo,columna,fila;
        
        String type;
        String identificador;
        String valor;
        
	

    public Simbolos(String tipo,String identifi,String valor,int fila)
    {
        type = tipo;
        identificador = identifi;
        this.valor = valor;
        this.fila = fila;
    }

    public String getDesc() {
        return desc;
    }

    public String getToken() {
        return token;
    }

    public int getTipo() {
        return tipo;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public String getType() {
        return type;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getValor() {
        return valor;
    }
    public void setValor(String valor)
    {
        this.valor = valor;
    }
    
    
    
}
