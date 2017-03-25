package br.edu.ufcg.computacao.si1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.ufcg.computacao.si1.util.Constantes;

@Controller
public class ErrorPagesController {

    @RequestMapping(Constantes.ROTA_404)
    public String notFound() {
        return Constantes.ERRO_404;
    }

    @RequestMapping(Constantes.ROTA_403)
    public String forbidden() {
        return Constantes.ERRO_403;
    }

    @RequestMapping(Constantes.ROTA_500)
    public String internalServerError() {
        return Constantes.ERRO_500;
    }
}
