package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.ufcg.computacao.si1.util.Constantes;

/**
 * Classe para o objeto Anuncio, do tipo Servico
 * @author Rafael
 *
 */
@Entity(name=Constantes.ANUNCIOSERVICO)
@Table(name="tb_anuncio_servico")
public class AnuncioServico extends Anuncio {

	/**
     * Construtor do objeto
     * @param titulo Título do anúncio
     * @param dataDeCriacao Data de criação do anúncio
     * @param preco Preco do anúncio
     * @param nota Nota do anúncio
     * @param tipo Tipo do anúncio
     */
	public AnuncioServico(String titulo, double preco, String tipo, String emailUsuario){
		super(titulo,preco,tipo,emailUsuario);
	}
	
	/**
     * Construtor default
     */
	public AnuncioServico(){
		super();
	}
}
