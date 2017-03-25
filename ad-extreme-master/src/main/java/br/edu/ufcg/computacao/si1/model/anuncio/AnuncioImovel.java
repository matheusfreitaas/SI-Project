package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.ufcg.computacao.si1.util.Constantes;

@Entity(name=Constantes.ANUNCIOIMOVEL)
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
