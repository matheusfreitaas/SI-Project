package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="AnuncioMovel")
@Table(name="tb_anuncio_movel")
public class AnuncioMovel extends Anuncio {
	
	public AnuncioMovel(String titulo, double preco, String tipo, String emailUsuario){
		super(titulo,preco,tipo,emailUsuario);
		
	}
	
	public AnuncioMovel(String titulo, Date dataDeCriacao, double preco, String nota, String tipo){
		super(titulo, dataDeCriacao, preco, nota, tipo);
	}
	
	public AnuncioMovel(){
		super();
	}
}
