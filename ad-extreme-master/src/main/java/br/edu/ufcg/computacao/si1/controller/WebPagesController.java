package br.edu.ufcg.computacao.si1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ufcg.computacao.si1.util.Constantes;

@Controller
public class WebPagesController {

    @RequestMapping(value = Constantes.ROTA_INICIAL, method = RequestMethod.GET)
    public ModelAndView getPageIndex(){
        ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.VIEW_INDEX);

        return model;
    }

    @RequestMapping(value = Constantes.ROTA_LOGIN, method = RequestMethod.GET)
    public ModelAndView getPageLogin(){
        ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.VIEW_LOGIN);

        return model;
    }

    @RequestMapping(value = Constantes.ROTA_USUARIO_FISICO, method = RequestMethod.GET)
    public ModelAndView getPageIndexUser(){
        ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.VIEW_USUARIO_FISICO);

        return model;
    }

    @RequestMapping(value = Constantes.ROTA_USUARIO_JURIDICO, method = RequestMethod.GET)
    public ModelAndView getPageIndexCompany(){
        ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.VIEW_USUARIO_JURIDICO);

        return model;
    }
}
