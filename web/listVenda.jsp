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
        <title>Relatorio Venda</title>
    </head>
    <body>
        <h1>Relatorio Venda</h1>
        
            <div>
            <h2>Listando Relatorio Venda</h2>
            <p> Segue abaixo a lista de dados dos Venda</p>                                                                                 
            <div>          
                <table>
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
                                         

                                <td><a href="VendaServlet?action=edit&codigo=<c:out value="${venda.codigo}"/>">Atualizar</a></td>
                                <td><a href="VendaServlet?action=delete&codigo=<c:out value="${venda.codigo}"/>"> Excluir</a></td>        
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="VendaServlet?action=insert">  Adicionar</a>
        </div>
    </body>
</html>