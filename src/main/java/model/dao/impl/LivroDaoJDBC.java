package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select * from livros"
					);
			rs = st.executeQuery();
			List<Livro> livros = new ArrayList<>();
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setAno(rs.getInt("ano"));
				livros.add(livro);
			}
			return livros;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
