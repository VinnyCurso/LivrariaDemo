<%-- 
    Document   : listVenda
    Created on : 23/10/2017, 01:30:37
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
        <title>Relatorio Venda</title>
    </head>
    <body>
        <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Relatorio Venda</h1>

        <div class="container">
            <h2>Listando Relatorio Venda</h2>
            <p> Segue abaixo a lista de dados dos Venda</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Cliente</th>
                            <th>Usuario</th>
                            <th>Valor Total</th>
                            <th>Tipo Pagamento</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <c:forEach items="${vendaM}" var="venda">
                        <tr>
                            <td><c:out value="${venda.codigo}"/> </td>
                            <td><c:out value="${venda.cliente}"/> </td>
                            <td><c:out value="${venda.usuario}"/> </td>
                            <td><c:out value="${venda.valorTotal}"/> </td>
                            <td><c:out value="${venda.tipoPagamento}"/> </td>

                            <td>
                                <a class="btn btn-warning" href="VendaServlet?action=edit&codigo=<c:out value="${venda.codigo}"/>" data-toggle="tooltip"
                                   title="Clique para Alterar/Atualizar os Dados">
                                    <span class="glyphicon glyphicon-edit"></span> Atualizar</a>
                            </td>

                            <td>
                                <a class="btn btn-danger" href="VendaServlet?action=delete&codigo=<c:out value="${venda.codigo}"/>" data-toggle="tooltip"
                                   title="Clique para Excluir/Deletar os Dados">
                                    <span class="glyphicon-remove-circle"></span> Excluir</a>
                            </td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <a class="btn btn-primary" data-toggle="tooltip" title="Clique adicionar nova Informação" href="VendaServlet?action=insert">
                <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
    </body>
</html>