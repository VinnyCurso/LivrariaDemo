/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.control;


import br.com.livrariademo.dao.AcabamentoLivroDao;
import br.com.livrariademo.dao.AutorDao;
import br.com.livrariademo.dao.EditoraDao;
import br.com.livrariademo.dao.GeneroDao;
import br.com.livrariademo.dao.IdiomaDao;
import br.com.livrariademo.dao.LivroDao;
import br.com.livrariademo.model.AcabamentoLivro;
import br.com.livrariademo.model.Autor;
import br.com.livrariademo.model.Editora;
import br.com.livrariademo.model.Genero;
import br.com.livrariademo.model.Idioma;
import br.com.livrariademo.model.Livro;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius caetano
 */
public class LivroServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/Livro.jsp";
    private static String LIST_LIVRO = "/listLivro.jsp";
    private LivroDao livroDAO;
    
    private EditoraDao editoraDAO;
    private AutorDao autorDAO;
    private GeneroDao generoDAO;
    private IdiomaDao idiomaDAO;
    private AcabamentoLivroDao acabamentoDAO;
    
    
     public LivroServlet() throws SQLException {
        super();
        livroDAO = new LivroDao();
        editoraDAO = new EditoraDao();
        autorDAO = new AutorDao();
        generoDAO = new GeneroDao();
        idiomaDAO = new IdiomaDao();
        acabamentoDAO = new AcabamentoLivroDao();
    }
     
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String forward = "";
            String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));
            livroDAO.Deletar(codigo);
            forward = LIST_LIVRO;
            request.setAttribute("livroM", livroDAO.Listar());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Livro livro = livroDAO.Consultar(codigo);
            request.setAttribute("livro", livro);
        } else if (action.equalsIgnoreCase("listLivro")) {
            forward = LIST_LIVRO;
            request.setAttribute("livroM", livroDAO.Listar());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
//            request.setAttribute("livroM", livroDAO.Listar());
            request.setAttribute("editoraM", editoraDAO.Listar());
            request.setAttribute("autorM", autorDAO.Listar());
            request.setAttribute("generoM", generoDAO.Listar());
            request.setAttribute("idiomaM", idiomaDAO.Listar());
            request.setAttribute("acabamentoM", acabamentoDAO.Listar());
            view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        Livro livro = new Livro();
        
        livro.setEditora(new Editora());
        livro.setAutor(new Autor());
        livro.setGenero(new Genero());
        livro.setIdioma(new Idioma());
        livro.setAcabamento(new AcabamentoLivro());
        
        try {
            Date dataPublicacao = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataPublicacao"));
            livro.setDataPublicacao(dataPublicacao);
        } catch (ParseException e) {
            e.getMessage();
        }
        
        livro.setNome(request.getParameter("nome"));
        livro.setDescricao(request.getParameter("descricao"));
        livro.setNumeroPaginas(Integer.parseInt(request.getParameter("numeroPaginas")));
        livro.setPreco(Float.parseFloat(request.getParameter("preco")));
        livro.setPeso(Float.parseFloat(request.getParameter("peso")));
        livro.setAvaliacao(Integer.parseInt(request.getParameter("avaliacao")));
        livro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
        livro.setAltura(Float.parseFloat(request.getParameter("altura")));
        livro.setLargura(Float.parseFloat(request.getParameter("largura")));
        livro.setProfundidade(Float.parseFloat(request.getParameter("profundidade")));
        livro.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidadeEstoque")));
        livro.setCodigoBarras(request.getParameter("codigoBarras"));
        livro.setCapa(Byte.parseByte(request.getParameter("capa")));

        
        
        String codigo = request.getParameter("codigo");
        if (codigo == null || codigo.isEmpty()) {

            livroDAO.Cadastrar(livro);
        } else {

            livro.setCodigo(Integer.parseInt(codigo));
            livroDAO.Atualizar(livro);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_LIVRO);
        request.setAttribute("livroM", livroDAO.Listar());
        view.forward(request, response);
    }



}
