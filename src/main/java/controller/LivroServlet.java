package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Livro;
import model.dao.DaoFactory;
import model.dao.LivroDao;

public class LivroServlet extends HttpServlet {
    private LivroDao dao;

    @Override
    public void init() throws ServletException {
        dao = DaoFactory.createLivroDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Livro livro = new Livro();
        livro.setTitulo(request.getParameter("titulo"));
        livro.setAutor(request.getParameter("autor"));
        livro.setAno(Integer.parseInt(request.getParameter("ano")));
        dao.inserirLivros(livro);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livro> livros = null;
		livros = dao.listarLivros();
        request.setAttribute("lista", livros);
        RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
        rd.forward(request, response);
    }
}
