package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório para anúncios
 * @author Rafael
 *
 */
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

	Anuncio findByTitulo(String titulo);
	
}
