package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.factories.AnuncioFactory;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioForm;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import br.edu.ufcg.computacao.si1.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


/**
 * Responsável pela conexão do AnuncioController com o AnuncioRepository
 */
@Service
public class AnuncioServiceImpl implements InterfaceService<Anuncio, AnuncioForm> {

    private AnuncioRepository anuncioRepository;
    private AnuncioFactory factory;
    
    @Autowired
    private UsuarioServiceImpl usuarioService;
    

    @Autowired
    public AnuncioServiceImpl(AnuncioRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
        this.factory = new AnuncioFactory();
    }

    /**
     * Retorna o repositório de anúncios
     * @return Repositório de anúncios
     */
    public AnuncioRepository getAnuncioRepository(){
        return this.anuncioRepository;
    }

    /**
     * Cria um anuncio pelo seu formulário
     */
    public Anuncio cria(AnuncioForm anuncioForm) {
    	
    	Usuario logado = usuarioService.getUsuarioPeloEmail(Util.emailUsuarioLogado());
    	
    	Anuncio anuncio = factory.criaAnuncio(anuncioForm, logado);
    	
        return anuncioRepository.save(anuncio);
    }
   
    /**
     * Retorna um anúncio pelo seu id
     */
    public Optional<Anuncio> getById(Long id) {
        return Optional.ofNullable(anuncioRepository.findOne(id));
    }

    /**
     * Retorna todos os anúncios
     */
    public Collection<Anuncio> getAll() {
        return anuncioRepository.findAll();
    }

    /**
     * Atualiza um anúncio
     */
    public boolean update(Anuncio anuncio) {
        if (anuncioRepository.exists(anuncio.getId())) {
            anuncioRepository.save(anuncio);
            return true;
        }
        return false;
    }

    /**
     * Deleta um anúncio pelo seu id
     */
    public boolean delete(Long id) {
        if (anuncioRepository.exists(id)) {
            anuncioRepository.delete(id);
            return true;
        }
        return false;
    }
    
    /**
     * Faz a compra de um anúncio
     * @param anuncio Anúncio a ser comprado
     */
    public void comprarAnuncio(String titulo){
    	Anuncio anuncio = anuncioRepository.findByTitulo(titulo);
    	
    	
    	Usuario usuarioDebito = usuarioService.getUsuarioPeloEmail(Util.emailUsuarioLogado());
    	Usuario usuarioCredito = anuncio.getUsuario();
    	
    	
    	double valor = anuncio.getPreco();
    	
    	usuarioDebito.setDebito(usuarioDebito.getDebito() + valor);
    	usuarioCredito.setCredito(usuarioCredito.getCredito() + valor);
    	
    	
    	usuarioService.update(usuarioDebito);
    	usuarioService.update(usuarioCredito);
    	
    	this.delete(anuncio.getId());
    }
}
