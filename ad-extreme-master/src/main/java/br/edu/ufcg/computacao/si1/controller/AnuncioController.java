package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import br.edu.ufcg.computacao.si1.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AnuncioController {

    @Autowired
    private AnuncioServiceImpl anuncioService;
    
    @RequestMapping(value = Constantes.ROTA_CADASTRAR_ANUNCIO, method = RequestMethod.GET)
    public ModelAndView getPageCadastrarAnuncio(AnuncioForm anuncioForm){
        
    	ModelAndView model = new ModelAndView();

        model.addObject(Constantes.TIPOS, anuncioForm.getTipos());
        model.setViewName(Constantes.VIEW_CADASTRAR_ANUNCIO);

        return model;
    }

    @RequestMapping(value = Constantes.ROTA_LISTAR_ANUNCIO, method = RequestMethod.GET)
    public ModelAndView getPageListarAnuncios(){
        
    	ModelAndView model = new ModelAndView();

        model.addObject(Constantes.ANUNCIOS, anuncioService.findAll());

        model.setViewName(Constantes.VIEW_LISTAR_ANUNCIO);

        return model;
    }

    @RequestMapping(value = Constantes.ROTA_CADASTRAR_ANUNCIO, method = RequestMethod.POST)
    public ModelAndView cadastroAnuncio(@Valid AnuncioForm anuncioForm, BindingResult result, RedirectAttributes attributes){
        
    	if(result.hasErrors()){
            return getPageCadastrarAnuncio(anuncioForm);
        }

        anuncioService.cria(anuncioForm);

        attributes.addFlashAttribute(Constantes.MENSAGEM, Constantes.CADASTRO_ANUNCIO_SUCESSO);
        return new ModelAndView("redirect:/user/cadastrar/anuncio");
    }
    
    


}
