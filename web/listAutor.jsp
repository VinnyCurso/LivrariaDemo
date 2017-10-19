<%-- 
    Document   : listAutor
    Created on : 19/10/2017, 14:41:45
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Autor</title>
    </head>
    <body>
        <h1>Relatorio Autor</h1>
        
            <div>
            <h2>Listando Relatorio Autor</h2>
            <p> Segue abaixo a lista de dados dos autores</p>                                                                                 
            <div>          
                <table>
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Descricao</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${autorM}" var="autor">
                            <tr>
                                <td><c:out value="${autor.codigo}"/> </td>
                                <td><c:out value="${autor.descricao}"/> </td>

                                <td><a href="AutorServlet?action=edit&codigo=<c:out value="${autor.codigo}"/>">Atualizar</a></td>
                                <td><a href="AutorServlet?action=delete&codigo=<c:out value="${autor.codigo}"/>"> Excluir</a></td>        
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="AutorServlet?action=insert">  Adicionar</a>
        </div>
    </body>
</html>
