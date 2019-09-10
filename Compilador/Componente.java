/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

public class Componente 
{
        final static int PALABRA_RESERVADA=0;
	final static int SIMBOLO_ESPECIAL = 1;
	final static int OPERADOR = 2;
	final static int TIPO  = 3;
	final static int MODIFICADOR = 4;
	final static int DIGITO = 5;
	final static int VALOR = 6;
	final static int IDENTIFICADOR = 7;
	
	
	private String desc,token;
	private int tipo,columna,fila;
	private String [] significado = {"Palabra reservada","Simbolo especial","Operador","Tipo","Modificador","Digito","Valor","Identificador"};


	public Componente(int tp,String t,int col,int fila){
		tipo = tp;
		token = t;
                columna = col;
		this.fila = fila;
		if(tipo < 9)
			desc = significado[tipo];
		else
			desc ="";
	}

	public String getDesc() {
		return desc;
	}

	public String getToken() {
		return token;
	}
	
	public int getColumna() {
		return columna;
	}

	public int getFila() {
		return fila;
	}
	public int getTipo(){
		return tipo;
	}
}
/**
 *
 * @author Alberto Loera
 */
