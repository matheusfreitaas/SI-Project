package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.form.UsuarioForm;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
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
public class CadastroController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @RequestMapping(value = Constantes.ROTA_CADASTRAR_USUARIO, method = RequestMethod.GET)
    public ModelAndView getPageCadastro(UsuarioForm usuarioForm){
        
    	ModelAndView model = new ModelAndView();
        model.setViewName(Constantes.CADASTRO);

        return model;
    }

    @RequestMapping(value = Constantes.ROTA_CADASTRAR_USUARIO, method = RequestMethod.POST)
    public ModelAndView cadastro(@Valid UsuarioForm usuarioForm, BindingResult result, RedirectAttributes attributes){
        
    	if(result.hasErrors()){
            return getPageCadastro(usuarioForm);
        }
        if (usuarioService.getByEmail(usuarioForm.getEmail()).isPresent()){
            attributes.addFlashAttribute(Constantes.ERROR, Constantes.EMAIL_EM_USO);
            return new ModelAndView("redirect:/cadastrar-se");
        }

        usuarioService.create(usuarioForm);

        attributes.addFlashAttribute(Constantes.MENSAGEM, Constantes.CADASTRO_USUARIO_SUCESSO);
        return new ModelAndView("redirect:/cadastrar-se");
    }


}
