package br.edu.ufcg.computacao.si1.model;

import java.util.Date;

public class AnuncioEmprego extends Anuncio {
	
	public AnuncioEmprego(String titulo, double preco, String tipo, String emailUsuario){
		super(titulo,preco,tipo,emailUsuario);
	}
	
	public AnuncioEmprego(String titulo, Date dataDeCriacao, double preco, String nota, String tipo){
		super(titulo, dataDeCriacao, preco, nota, tipo);
	}
	
	public AnuncioEmprego(){
		super();
	}
	

}
