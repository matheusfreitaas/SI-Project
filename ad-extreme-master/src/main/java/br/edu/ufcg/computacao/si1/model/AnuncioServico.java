package br.edu.ufcg.computacao.si1.model;

import java.util.Date;

public class AnuncioServico extends Anuncio {

	public AnuncioServico(String titulo, double preco, String tipo, String emailUsuario){
		super(titulo,preco,tipo,emailUsuario);
	}
	
	public AnuncioServico(String titulo, Date dataDeCriacao, double preco, String nota, String tipo){
		super(titulo, dataDeCriacao, preco, nota, tipo);
	}
	
	public AnuncioServico(){
		super();
	}
}