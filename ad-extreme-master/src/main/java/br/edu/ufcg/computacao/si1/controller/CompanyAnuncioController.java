package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioForm;
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

/**
 * Responsável por gerenciar as operações sobre os anúncios de uma Pessoa Jurídica
 * @author Rafael
 *
 */
@Controller
public class CompanyAnuncioController {

    @Autowired
    private AnuncioServiceImpl anuncioService;
    
    /**
     * Redireciona o usúario para a view de cadastro de anúncios
     * @param anuncioForm Formulário de um anúncio
     * @return Página de cadastro de anúncios
     */
    @RequestMapping(value = Constantes.ROTA_CADASTRAR_ANUNCIO_COMPANY, method = RequestMethod.GET)
    public ModelAndView getPageCadastarAnuncio(AnuncioForm anuncioForm){
       
    	ModelAndView model = new ModelAndView();

        model.addObject(Constantes.TIPOS, anuncioForm.getTipos());
        model.setViewName(Constantes.VIEW_CADASTRAR_ANUNCIO_COMPANY);

        return model;
    }

    /**
     * Retorna a view com todos os anúncios cadastrados
     * @return Página com a listagem de todos os anúncios
     */
    @RequestMapping(value = Constantes.ROTA_LISTAR_ANUNCIO_COMPANY, method = RequestMethod.GET)
    public ModelAndView getPageListarAnuncios(){
        
    	ModelAndView model = new ModelAndView();

        model.addObject(Constantes.ANUNCIOS, anuncioService.getAnuncioRepository().findAll());

        model.setViewName(Constantes.VIEW_LISTAR_ANUNCIO_COMPANY);

        return model;
    }

    /**
     * Cadastra um anúncio e redireciona o usuário para a pagina de todos os anúncios
     * @param anuncioForm Formulário de um anúncio
     * @param result
     * @param attributes
     * @return Página com a listagem de todos os anúncios
     */
    @RequestMapping(value = Constantes.ROTA_CADASTRAR_ANUNCIO_COMPANY, method = RequestMethod.POST)
    public ModelAndView cadastroAnuncio(@Valid AnuncioForm anuncioForm, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return getPageCadastarAnuncio(anuncioForm);
        }

        anuncioService.cria(anuncioForm);

        attributes.addFlashAttribute(Constantes.MENSAGEM, Constantes.CADASTRO_ANUNCIO_SUCESSO);
        return new ModelAndView("redirect:/company/listar/anuncios");
    }
    
    /**
     * Realiza a compra de um determinado anúncio
     * @param anuncio Anuncio a ser comprado
     * @param result
     * @param attributes
     * @return Página com a listagem de todos os anúncios
     */
    @RequestMapping(value = Constantes.ROTA_COMPRAR_ANUNCIO_COMPANY, method = RequestMethod.POST)
    public ModelAndView comprarAnuncio(@Valid Anuncio anuncio, BindingResult result, RedirectAttributes attributes){

    	System.out.println("entrou");

    	if(result.hasErrors()){
           // return getPageCadastrarAnuncio(anuncioForm);
    		return new ModelAndView();
        }
    	
        //anuncioService.comprar(anuncio);

        attributes.addFlashAttribute(Constantes.MENSAGEM, Constantes.CADASTRO_ANUNCIO_SUCESSO);
        return new ModelAndView("redirect:/user/listar/anuncios");
    }


}
