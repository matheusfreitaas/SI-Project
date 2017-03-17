package br.edu.ufcg.computacao.si1.factorys;

import br.edu.ufcg.computacao.si1.model.Usuario;

public class UsuarioFactory {
	private final String PESSOA_FISICA = "pessoa fisica";
	private final String PESSOA_JURIDICA = "pessoa juridica";
	
	public Usuario getUsuario(String tipoUsuario) {
		switch (tipoUsuario) {
		case PESSOA_FISICA:
			return new Usuario();
			
		case PESSOA_JURIDICA:
			return new Usuario();
			
		default:
			return null;
		}
	}

}
