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
        <jsp:include page = "source/headBoostrap.jsp" />
        <title>Relatorio Acabamento</title>
    </head>
    <body>
        <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Relatorio Acabamento Livro</h1>

        <div class="container">
            <h2>Listando Relatorio Acabamento Livro</h2>
            <p> Segue abaixo a lista de dados dos acabamentos</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
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


                                <td>
                                    <a class="btn btn-warning" href="AcabamentoServlet?action=edit&codigo=<c:out value="${acabamento.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="AcabamentoServlet?action=delete&codigo=<c:out value="${acabamento.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="AcabamentoServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
    </body>
</html>
