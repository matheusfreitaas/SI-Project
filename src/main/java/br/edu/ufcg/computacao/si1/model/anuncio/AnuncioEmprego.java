package br.edu.ufcg.computacao.si1.model.anuncio;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.util.Constantes;

/**
 * Classe para o objeto Anuncio, do tipo Emprego
 * @author Rafael
 *
 */
@Entity(name= Constantes.ANUNCIOEMPREGO)
@Table(name="tb_anuncio_emprego")
public class AnuncioEmprego extends Anuncio {
	
	/**
     * Construtor do objeto
     * @param titulo Título do anúncio
     * @param dataDeCriacao Data de criação do anúncio
     * @param preco Preco do anúncio
     * @param nota Nota do anúncio
     * @param tipo Tipo do anúncio
     */
	public AnuncioEmprego(String titulo, double preco, String tipo, Usuario dono){
		super(titulo,preco,tipo,dono);
	}
	
	/**
     * Construtor default
     */
	public AnuncioEmprego(){
		super();
	}
	

}
