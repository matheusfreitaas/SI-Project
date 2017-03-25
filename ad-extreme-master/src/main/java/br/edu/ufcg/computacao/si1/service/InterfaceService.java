package br.edu.ufcg.computacao.si1.service;

import java.util.Collection;
import java.util.Optional;

public interface InterfaceService<Modelo, Form> {
	
	public Modelo cria(Form form);

	public Optional<Modelo> getById(Long id);

	public Collection<Modelo> getAll();

	public boolean update(Modelo modelo);

	public boolean delete(Long id);
	
}
