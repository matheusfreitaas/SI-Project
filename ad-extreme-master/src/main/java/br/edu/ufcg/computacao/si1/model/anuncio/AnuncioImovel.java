package br.edu.ufcg.computacao.si1.model.anuncio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.ufcg.computacao.si1.util.Constantes;

/**
 * Classe para o objeto Anuncio, do tipo Imovel
 * @author Rafael
 *
 */
@Entity(name=Constantes.ANUNCIOIMOVEL)
@Table(name="tb_anuncio_imovel")
public class AnuncioImovel extends Anuncio {
	
	/**
     * Construtor do objeto
     * @param titulo Título do anúncio
     * @param dataDeCriacao Data de criação do anúncio
     * @param preco Preco do anúncio
     * @param nota Nota do anúncio
     * @param tipo Tipo do anúncio
     */
	public AnuncioImovel(String titulo, double preco, String tipo, String emailUsuario){
		super(titulo,preco,tipo,emailUsuario);
	}
	
	/**
     * Construtor do objeto
     * @param titulo Título do anúncio
     * @param preco Preco do anúncio
     * @param tipo Tipo do anúncio
     * @param emailUsuario Email do criador do anúncio
     */
	public AnuncioImovel(String titulo, Date dataDeCriacao, double preco, String nota, String tipo) {
		super(titulo, dataDeCriacao, preco, nota, tipo);
	}
	
	/**
     * Construtor default
     */
	public AnuncioImovel(){
		super();
	}
}
