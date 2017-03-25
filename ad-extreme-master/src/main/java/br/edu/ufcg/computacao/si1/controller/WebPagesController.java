package br.edu.ufcg.computacao.si1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufcg.computacao.si1.util.Constantes;

/**
 * Responsável pelo fluxo de páginas da aplicação
 * @author Rafael
 *
 */
@Controller
public class WebPagesController {

	/**
	 * Redireciona o usuário para a página inicial da aplicação
	 * @return Página inicial
	 */
    @RequestMapping(value = Constantes.ROTA_INICIAL, method = RequestMethod.GET)
    public ModelAndView getPageIndex(){
        ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.VIEW_INDEX);

        return model;
    }

    /**
     * Redireciona o usuário para o login
     * @return Página de login
     */
    @RequestMapping(value = Constantes.ROTA_LOGIN, method = RequestMethod.GET)
    public ModelAndView getPageLogin(){
        ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.VIEW_LOGIN);

        return model;
    }

    /**
     * Redireciona o usuário para a página inicial de uma Pessoa Física
     * @return Página inicial de um usuario Pessoa Física
     */
    @RequestMapping(value = Constantes.ROTA_USUARIO_FISICO, method = RequestMethod.GET)
    public ModelAndView getPageIndexUser(){
        ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.VIEW_USUARIO_FISICO);

        return model;
    }

    /**
     * Redireciona o usuário para a página inicial de uma Pessoa Jurídica
     * @return Página inicial de um usuário Pessoa Jurídica
     */
    @RequestMapping(value = Constantes.ROTA_USUARIO_JURIDICO, method = RequestMethod.GET)
    public ModelAndView getPageIndexCompany(){
        ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.VIEW_USUARIO_JURIDICO);

        return model;
    }
}
