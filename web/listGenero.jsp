<%-- 
    Document   : listGenero
    Created on : 19/10/2017, 15:39:47
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Genero</title>
    </head>
    <body>
        <h1>Relatorio Genero</h1>
        
            <div>
            <h2>Listando Relatorio Genero</h2>
            <p> Segue abaixo a lista de dados dos generos</p>                                                                                 
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
                        <c:forEach items="${generoM}" var="genero">
                            <tr>
                                <td><c:out value="${genero.codigo}"/> </td>
                                <td><c:out value="${genero.descricao}"/> </td>

                                <td><a href="GeneroServlet?action=edit&codigo=<c:out value="${genero.codigo}"/>">Atualizar</a></td>
                                <td><a href="GeneroServlet?action=delete&codigo=<c:out value="${genero.codigo}"/>"> Excluir</a></td>        
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="GeneroServlet?action=insert">  Adicionar</a>
        </div>
    </body>
</html>