package br.edu.ufcg.computacao.si1.factorys;

import br.edu.ufcg.computacao.si1.model.Anuncio;

public class AnuncioFactory {
	private final String MOVEL = "movel";
	private final String IMOVEL = "imovel";
	private final String EMPREGO = "emprego";
	
	public Anuncio getAnuncio(String tipoAnuncio) {
		switch (tipoAnuncio) {
		
		case MOVEL:
			return new Anuncio();

		case IMOVEL:
			return new Anuncio();
			
		case EMPREGO:
			return new Anuncio();
		
		default:
			return null;
		}
	}
}
