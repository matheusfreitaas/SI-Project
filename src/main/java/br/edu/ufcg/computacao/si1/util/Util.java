package br.edu.ufcg.computacao.si1.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe com métodos uteis para toda aplicação
 * @author Rafael
 *
 */
public class Util {

	/**
	 * Retorna o email do usuário atualmente logado
	 * @return Email do usuário
	 */
	public static String emailUsuarioLogado() {
		Object usuarioLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return usuarioLogado instanceof UserDetails ? ((UserDetails) usuarioLogado).getUsername()
				: usuarioLogado.toString();
	}
	
}
