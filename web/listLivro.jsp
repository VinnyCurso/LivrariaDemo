<%-- 
    Document   : listLivro
    Created on : 22/10/2017, 22:44:37
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Livro</title>
    </head>
    <body>
        <h1>Relatorio Livro</h1>
        
            <div>
            <h2>Listando Relatorio Livro</h2>
            <p> Segue abaixo a lista de dados dos Livro</p>                                                                                 
            <div>          
                <table>
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Editora</th>
                            <th>Autor</th>
                            <th>Genero</th>
                            <th>Idioma</th>
                            <th>Acabamento</th>
                            <th>dataPublicacao</th>
                            <th>Nome</th>
                            <th>Descricao</th>
                            <th>Numero de Paginas</th>
                            <th>Preço</th>
                            <th>Peso</th>
                             <th>Avaliação</th>
                             <th>ISBN</th>
                             <th>Altura</th>
                             <th>Largura</th>
                             <th>Profundidade</th>
                             <th>Quantidade Estoque</th>
                             <th>Codigo barras</th>
                             <th>Capa</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${livroM}" var="livro">
                            <tr>
                                <td><c:out value="${livro.codigo}"/> </td>
                                <td><c:out value="${livro.editora}"/> </td>
                                <td><c:out value="${livro.autor}"/> </td>
                                <td><c:out value="${livro.genero}"/> </td>
                                <td><c:out value="${livro.idioma}"/> </td>
                                <td><c:out value="${livro.acabamento}"/> </td>
                                <td><c:out value="${livro.dataPublicacao}"/> </td>
                                <td><c:out value="${livro.nome}"/> </td>
                                <td><c:out value="${livro.descricao}"/> </td>
                                <td><c:out value="${livro.numeroPaginas}"/> </td>
                                <td><c:out value="${livro.preco}"/> </td>
                                <td><c:out value="${livro.peso}"/> </td>
                                <td><c:out value="${livro.avaliacao}"/> </td>
                                <td><c:out value="${livro.isbn}"/> </td>
                                <td><c:out value="${livro.altura}"/> </td>
                                <td><c:out value="${livro.largura}"/> </td>
                                <td><c:out value="${livro.profundidade}"/> </td>
                                <td><c:out value="${livro.quantidadeEstoque}"/> </td>
                                <td><c:out value="${livro.codigoBarras}"/> </td>
                                <td><c:out value="${livro.capa}"/> </td>
                                                  

                                <td><a href="LivroServlet?action=edit&codigo=<c:out value="${livro.codigo}"/>">Atualizar</a></td>
                                <td><a href="LivroServlet?action=delete&codigo=<c:out value="${livro.codigo}"/>"> Excluir</a></td>        
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="LivroServlet?action=insert">  Adicionar</a>
        </div>
    </body>
</html>
