package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.factories.UsuarioFactory;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.model.usuario.UsuarioForm;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Responsável pela conexão do UsuarioController com o UsuarioRepository
 * @author Rafael
 *
 */
@Service
public class UsuarioServiceImpl implements InterfaceService<Usuario, UsuarioForm>{

    private UsuarioRepository usuarioRepository;
    private UsuarioFactory factory;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.factory = new UsuarioFactory();
    }

    /**
     * Cria um novo usuário
     */
    public Usuario cria(UsuarioForm usuarioForm) {

        Usuario usuario = factory.criaUsuario(usuarioForm);

        System.out.println(usuario + "estah sendo criado");
        return usuarioRepository.save(usuario);
    }

    /**
     * Retorna um usuário pelo id
     */
    @Override
    public Optional<Usuario> getById(Long id) {
        return Optional.ofNullable(usuarioRepository.findOne(id));
    }

    /**
     * Retorna todos os usuários
     */
    public Collection<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    /**
     * Atualiza um usuário
     */
    public boolean update(Usuario usuario) {
        System.out.println(usuario + "estah sendo atualizado");

        if(usuarioRepository.exists(usuario.getId())) {
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    /**
     * Deleta um usuário pelo seu id
     */
    public boolean delete(Long id) {
        if(usuarioRepository.exists(id)) {
            usuarioRepository.delete(id);
            return true;
        }
        return false;
    }
    
    /**
     * Retorna um usuário pelo email
     * @param email Email do usuário
     * @return Usuário
     */
    public Usuario getUsuarioPeloEmail(String email){
    	return usuarioRepository.findByEmail(email);
    }

    /**
     * Retorna um usuário pelo email
     */
    public Optional<Usuario> getByEmail(String email) {
        System.out.println(email + "estah sendo retornado");
        return Optional.ofNullable(usuarioRepository.findByEmail(email));
    }
}
