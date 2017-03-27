package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioEmprego;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioForm;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioImovel;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioMovel;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioServico;
import br.edu.ufcg.computacao.si1.util.Constantes;
import br.edu.ufcg.computacao.si1.util.Util;

/**
 * Responsável pela instanciação de anúncios
 * @author Rafael
 *
 */
public class AnuncioFactory {
	
	/**
	 * Cria um anúncio, dependendo do tipo passado
	 * @param anuncioForm Formulário de um anúncio
	 * @return Anúncio criado
	 */
	public Anuncio criaAnuncio(AnuncioForm anuncioForm){
		
		Anuncio novoAnuncio;
		
		if(anuncioForm.getTipo().equals(Constantes.ANUNCIO_MOVEL)){
			novoAnuncio = new AnuncioMovel(anuncioForm.getTitulo(), anuncioForm.getPreco(),
					anuncioForm.getTipo(), Util.emailUsuarioLogado());
			
		}else if(anuncioForm.getTipo().equals(Constantes.ANUNCIO_IMOVEL)){
			novoAnuncio = new AnuncioImovel(anuncioForm.getTitulo(), anuncioForm.getPreco(),
					anuncioForm.getTipo(), Util.emailUsuarioLogado());
			
		}else if(anuncioForm.getTipo().equals(Constantes.ANUNCIO_EMPREGO)){
			novoAnuncio = new AnuncioEmprego(anuncioForm.getTitulo(), anuncioForm.getPreco(),
					anuncioForm.getTipo(), Util.emailUsuarioLogado());
			
		}else if(anuncioForm.getTipo().equals(Constantes.ANUNCIO_SERVICO)){
			novoAnuncio = new AnuncioServico(anuncioForm.getTitulo(), anuncioForm.getPreco(),
					anuncioForm.getTipo(), Util.emailUsuarioLogado());
		}else{
			throw new RuntimeException();
		};
		
		return novoAnuncio;
	}
}
