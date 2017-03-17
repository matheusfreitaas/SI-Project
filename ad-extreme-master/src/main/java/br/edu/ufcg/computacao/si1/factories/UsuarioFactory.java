package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.Usuario;
import br.edu.ufcg.computacao.si1.model.form.UsuarioForm;

public class UsuarioFactory {
	
	private final String PESSOA_FISICA = "USER";
	private final int ID_PESSOA_FISICA = 1;
	private final String PESSOA_JURIDICA = "COMPANY";
	private final int ID_PESSOA_JURIDICA = 2;
	
	public Usuario criaUsuario(UsuarioForm usuarioForm){
		
		Usuario novoUsuario;
		
		if(usuarioForm.getRole() == ID_PESSOA_FISICA){
			novoUsuario = new Usuario(usuarioForm.getNome(), usuarioForm.getEmail(),
                    usuarioForm.getSenha(), PESSOA_FISICA);
        } else if(usuarioForm.getRole() == ID_PESSOA_JURIDICA) {
        	novoUsuario = new Usuario(usuarioForm.getNome(), usuarioForm.getEmail(),
                    usuarioForm.getSenha(), PESSOA_JURIDICA);
        } else {
        	novoUsuario = new Usuario();
        }
		
		return novoUsuario; 
	}

}
