package br.edu.ufcg.computacao.si1.factories;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.model.usuario.UsuarioForm;
import br.edu.ufcg.computacao.si1.util.Constantes;

/**
 * Responsável pela instanciação de usuários
 * @author Rafael
 *
 */
public class UsuarioFactory {
	
	/**
	 * Cria um usuário, dependendo do tipo passado
	 * @param usuarioForm Formulário de um usuário
	 * @return Novo uúario
	 */
	public Usuario criaUsuario(UsuarioForm usuarioForm){
		
		Usuario novoUsuario;
		
		if(usuarioForm.getRole() == Constantes.ID_PESSOA_FISICA){
			novoUsuario = new Usuario(usuarioForm.getNome(), usuarioForm.getEmail(),
                    usuarioForm.getSenha(), Constantes.PESSOA_FISICA);
        } else if(usuarioForm.getRole() == Constantes.ID_PESSOA_JURIDICA) {
        	novoUsuario = new Usuario(usuarioForm.getNome(), usuarioForm.getEmail(),
                    usuarioForm.getSenha(), Constantes.PESSOA_JURIDICA);
        } else {
        	novoUsuario = new Usuario();
        }
		
		return novoUsuario; 
	}

}
