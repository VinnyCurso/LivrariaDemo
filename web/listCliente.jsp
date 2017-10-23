<%-- 
    Document   : listCliente
    Created on : 19/10/2017, 16:41:45
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
        <title>Relatorio Cliente</title>
    </head>
    <body>
          <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Relatorio Cliente</h1>
        
            <div class="container">
            <h2>Listando Relatorio Cliente</h2>
            <p> Segue abaixo a lista de dados dos Clientes</p>                                                                                 
            <div class="table-responsive">          
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Telefone</th>
                             <th>CPF</th>
                             <th>Data Cadastro</th>
                            <th colspan=2>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${clienteM}" var="cliente">
                            <tr>
                                <td><c:out value="${cliente.codigo}"/> </td>
                                <td><c:out value="${cliente.nome}"/> </td>
                                <td><c:out value="${cliente.email}"/> </td>
                                <td><c:out value="${cliente.telefone}"/> </td>
                                <td><c:out value="${cliente.cpf}"/> </td>
                                <td><c:out value="${cliente.dataCadastro}"/> </td>
                                
                                 <td><a class="btn btn-warning"  href="ClienteServlet?action=edit&codigo=<c:out value="${cliente.codigo}"/>"
                                       data-toggle="tooltip"  title="Clique para Alterar/Atualizar os Dados"> 
                                        <span class="glyphicon glyphicon-edit"></span> Atualizar</a></td>
                                        
                                         <td><a class="btn btn-danger" href="ClienteServlet?action=delete&codigo=<c:out value="${cliente.codigo}"/>"
                                       data-toggle="tooltip"  title="Clique para Excluir/Deletar os Dados">
                                        <span class="glyphicon-remove-circle"></span> Excluir</a></td>     
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            <a class="btn btn-primary"  data-toggle="tooltip"  title="Clique adicionar nova Informação" 
               href="ClienteServlet?action=insert"> <span class=" glyphicon glyphicon-saved"></span> Adicionar</a>
        </div>
            <jsp:include page = "source/footer.jsp" />
    </body>
</html>
