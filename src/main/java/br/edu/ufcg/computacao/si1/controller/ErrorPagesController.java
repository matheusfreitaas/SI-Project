package br.edu.ufcg.computacao.si1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.ufcg.computacao.si1.util.Constantes;

/**
 * Responsável pelo redirecionamento para páginas de erro
 * @author Rafael
 *
 */
@Controller
public class ErrorPagesController {

	/**
	 * Redireciona para a página de erro 404
	 * @return Página 404
	 */
    @RequestMapping(Constantes.ROTA_404)
    public String notFound() {
        return Constantes.ERRO_404;
    }

    /**
	 * Redireciona para a página de erro 403
	 * @return Página 403
	 */
    @RequestMapping(Constantes.ROTA_403)
    public String forbidden() {
        return Constantes.ERRO_403;
    }

    /**
	 * Redireciona para a página de erro 500
	 * @return Página 500
	 */
    @RequestMapping(Constantes.ROTA_500)
    public String internalServerError() {
        return Constantes.ERRO_500;
    }
}
