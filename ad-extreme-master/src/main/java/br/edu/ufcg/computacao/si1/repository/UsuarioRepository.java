package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para usuários
 * @author Rafael
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    Usuario findByEmail(String email);
}
