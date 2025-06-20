package model.dao;

import java.util.List;

import model.entities.Livro;

public interface LivroDao {
	void inserirLivros(Livro livro);
	List<Livro> listarLivros();
}
