package model.dao;

import db.DB;
import model.dao.impl.LivroDaoJDBC;

public class DaoFactory {

	public static LivroDao createLivroDao() {
		return new LivroDaoJDBC(DB.getConnection());
	}
	
}
