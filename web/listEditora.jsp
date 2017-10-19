<%-- 
    Document   : listEditora
    Created on : 19/10/2017, 15:16:17
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Editora</title>
    </head>
    <body>
        <h1>Relatorio Editora</h1>
        
            <div>
            <h2>Listando Relatorio Editora</h2>
            <p> Segue abaixo a lista de dados das editoras</p>                                                                                 
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
                        <c:forEach items="${editoraM}" var="editora">
                            <tr>
                                <td><c:out value="${editora.codigo}"/> </td>
                                <td><c:out value="${editora.descricao}"/> </td>

                                <td><a href="EditoraServlet?action=edit&codigo=<c:out value="${editora.codigo}"/>">Atualizar</a></td>
                                <td><a href="EditoraServlet?action=delete&codigo=<c:out value="${editora.codigo}"/>"> Excluir</a></td>        
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="EditoraServlet?action=insert">  Adicionar</a>
        </div>
    </body>
</html>
