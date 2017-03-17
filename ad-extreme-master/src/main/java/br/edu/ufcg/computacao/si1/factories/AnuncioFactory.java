package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.Anuncio;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.util.Util;

public class AnuncioFactory {

	public Anuncio criaAnuncio(AnuncioForm anuncioForm){
		
		Anuncio novoAnuncio = new Anuncio(anuncioForm.getTitulo(), anuncioForm.getPreco(),
				anuncioForm.getTipo(), Util.emailUsuarioLogado());
		
		return novoAnuncio;
	}
}
