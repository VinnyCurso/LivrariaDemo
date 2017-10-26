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
         <jsp:include page = "source/headBoostrap.jsp" />
        <title>Relatorio Idioma</title>
    </head>
    <body>
          <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Relatorio Idioma</h1>
        
            <div class="container">
            <h2>Listando Relatorio Idioma</h2>
            <p> Segue abaixo a lista de dados dos Idiomas</p>                                                                                 
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
                        <c:forEach items="${idiomaM}" var="idioma">
                            <tr>
                                <td><c:out value="${idioma.codigo}"/> </td>
                                <td><c:out value="${idioma.descricao}"/> </td>

                                
                                  <td>
                <a class="btn btn-warning" href="IdiomaServlet?action=edit&codigo=<c:out value="${idioma.codigo}"/>" data-toggle="tooltip"
                    title="Clique para Alterar/Atualizar os Dados">
                    <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
            </td>

            <td>
                <a class="btn btn-danger" href="IdiomaServlet?action=delete&codigo=<c:out value="${idioma.codigo}"/>" data-toggle="tooltip"
                    title="Clique para Excluir/Deletar os Dados">
                    <span class="glyphicon-remove-circle"></span> Excluir</a>
            </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
             <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="IdiomaServlet?action=insert">
            <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
    </body>
</html>