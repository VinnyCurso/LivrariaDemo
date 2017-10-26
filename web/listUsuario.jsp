<%-- 
    Document   : listUsuario
    Created on : 23/10/2017, 01:18:54
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
        <title>Relatorio Usuario</title>
    </head>
    <body>
        <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Relatorio Usuario</h1>

        <div class="container">
            <h2>Listando Relatorio Usuario</h2>
            <p> Segue abaixo a lista de dados dos usuarios</p>                                                                                 
            <div class="table-responsive">  
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Login</th>
                            <th>Password</th>
                            <th>Confirmação Password</th>
                            <th>Name</th>
                            <th>Ativo</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${usuarioM}" var="usuario">
                            <tr>
                                <td><c:out value="${usuario.codigo}"/> </td>
                                <td><c:out value="${usuario.login}"/> </td>
                                <td><c:out value="${usuario.password}"/> </td>
                                <td><c:out value="${usuario.confirmacaoPassword}"/> </td>
                                <td><c:out value="${usuario.name}"/> </td>
                                <td><c:out value="${usuario.ativo}"/> </td>

                                <td>
                                    <a class="btn btn-warning" href="UsuarioServlet?action=edit&codigo=<c:out value="${usuario.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Alterar/Atualizar os Dados">
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                                </td>

                                <td>
                                    <a class="btn btn-danger" href="UsuarioServlet?action=delete&codigo=<c:out value="${usuario.codigo}"/>" data-toggle="tooltip"
                                       title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="UsuarioServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
    </body>
</html>

