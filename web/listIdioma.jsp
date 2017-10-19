<%-- 
    Document   : listIdioma
    Created on : 19/10/2017, 15:51:53
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Idioma</title>
    </head>
    <body>
        <h1>Relatorio Idioma</h1>
        
            <div>
            <h2>Listando Relatorio Idioma</h2>
            <p> Segue abaixo a lista de dados dos Idiomas</p>                                                                                 
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
                        <c:forEach items="${idiomaM}" var="idioma">
                            <tr>
                                <td><c:out value="${idioma.codigo}"/> </td>
                                <td><c:out value="${idioma.descricao}"/> </td>

                                <td><a href="IdiomaServlet?action=edit&codigo=<c:out value="${idioma.codigo}"/>">Atualizar</a></td>
                                <td><a href="IdiomaServlet?action=delete&codigo=<c:out value="${idioma.codigo}"/>"> Excluir</a></td>        
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="IdiomaServlet?action=insert">  Adicionar</a>
        </div>
    </body>
</html>