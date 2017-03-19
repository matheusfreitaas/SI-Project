package br.edu.ufcg.computacao.si1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="AnuncioImovel")
@Table(name="tb_anuncio_imovel")
public class AnuncioImovel extends Anuncio {
	
	public AnuncioImovel(String titulo, double preco, String tipo, String emailUsuario){
		super(titulo,preco,tipo,emailUsuario);
	}
	
	public AnuncioImovel(String titulo, Date dataDeCriacao, double preco, String nota, String tipo) {
		super(titulo, dataDeCriacao, preco, nota, tipo);
	}
	
	public AnuncioImovel(){
		super();
	}
}
