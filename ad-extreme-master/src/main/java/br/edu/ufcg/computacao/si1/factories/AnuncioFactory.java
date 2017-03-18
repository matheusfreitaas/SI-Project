package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.Anuncio;
import br.edu.ufcg.computacao.si1.model.AnuncioEmprego;
import br.edu.ufcg.computacao.si1.model.AnuncioImovel;
import br.edu.ufcg.computacao.si1.model.AnuncioMovel;
import br.edu.ufcg.computacao.si1.model.AnuncioServico;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.util.Util;

public class AnuncioFactory {
	
	private final String ANUNCIO_MOVEL = "MOVEL";
	private final String ANUNCIO_IMOVEL = "IMOVEL";
	private final String ANUNCIO_EMPREGO = "EMPREGO";
	private final String ANUNCIO_SERVICO = "SERVIÇO";
	
	public Anuncio criaAnuncio(AnuncioForm anuncioForm){
		
		Anuncio novoAnuncio;
		
		if(anuncioForm.getTipo().toUpperCase().equals(ANUNCIO_MOVEL)){
			novoAnuncio = new AnuncioMovel(anuncioForm.getTitulo(), anuncioForm.getPreco(),
					anuncioForm.getTipo(), Util.emailUsuarioLogado());
			
		}else if(anuncioForm.getTipo().toUpperCase().equals(ANUNCIO_IMOVEL)){
			novoAnuncio = new AnuncioImovel(anuncioForm.getTitulo(), anuncioForm.getPreco(),
					anuncioForm.getTipo(), Util.emailUsuarioLogado());
			
		}else if(anuncioForm.getTipo().toUpperCase().equals(ANUNCIO_EMPREGO)){
			novoAnuncio = new AnuncioEmprego(anuncioForm.getTitulo(), anuncioForm.getPreco(),
					anuncioForm.getTipo(), Util.emailUsuarioLogado());
			
		}else{//Anuncio de serviço
			novoAnuncio = new AnuncioServico(anuncioForm.getTitulo(), anuncioForm.getPreco(),
					anuncioForm.getTipo(), Util.emailUsuarioLogado());
		};
		
		return novoAnuncio;
	}
}
