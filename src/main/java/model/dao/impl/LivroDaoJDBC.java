package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.LivroDao;
import model.entities.Livro;

public class LivroDaoJDBC implements LivroDao {
	
	private Connection conn;
	
	public LivroDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserirLivros(Livro livro) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO livros "
					+ "(titulo, autor, ano) "
					+ "VALUES "
					+ "(?, ?, ?)"
					);
			st.setString(1, livro.getTitulo());
			st.setString(2, livro.getAutor());
			st.setInt(3, livro.getAno());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Livro> listarLivros() {
		// TODO Auto-generated method stub
		return null;
	}

}
