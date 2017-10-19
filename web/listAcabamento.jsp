<%-- 
    Document   : listAcabamento
    Created on : 18/10/2017, 15:52:16
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorio Acabamento</title>
    </head>
    <body>
        <h1>Relatorio Acabamento Livro</h1>
        
            <div>
            <h2>Listando Relatorio Acabamento Livro</h2>
            <p> Segue abaixo a lista de dados dos acabamentos</p>                                                                                 
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
                        <c:forEach items="${acabamentoM}" var="acabamento">
                            <tr>
                                <td><c:out value="${acabamento.codigo}"/> </td>
                                <td><c:out value="${acabamento.descricao}"/> </td>

                                <td><a href="AcabamentoServlet?action=edit&codigo=<c:out value="${acabamento.codigo}"/>">Atualizar</a></td>
                                <td><a href="AcabamentoServlet?action=delete&codigo=<c:out value="${acabamento.codigo}"/>"> Excluir</a></td>        
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="AcabamentoServlet?action=insert">  Adicionar</a>
        </div>
    </body>
</html>
