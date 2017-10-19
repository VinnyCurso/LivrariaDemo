<%-- 
    Document   : Cliente
    Created on : 19/10/2017, 16:41:35
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Cliente</title>
    </head>
    <body>
        <h1>Formulario Cliente</h1>
        
         <fieldset>
             <legend>Formulario Cliente</legend>
            <form name="formCliente" method="post" action="ClienteServlet">
                
                <div>
                <label>Codigo :</label>
                <input type="number" name="codigo" placeholder="000" readonly="readonly" value="<c:out value="${cliente.codigo}"/>"> <br/>
               </div>
               
                <div>
                <label>Nome :</label>
                <input type="text" name="nome" required="true"  placeholder="Nome" value="<c:out value="${cliente.nome}"/>"> <br/>
                </div>
                
                <div>
                <label>Email :</label>
                <input type="email" name="email" required="true"  placeholder="xxx@xxxx.xxx" value="<c:out value="${cliente.email}"/>"> <br/>
                </div>
                
                <div>
                <label>Telefone :</label>
                <input type="tel" name="telefone" required="true"  placeholder="(00)0000-0000" value="<c:out value="${cliente.telefone}"/>"> <br/>
                </div>
                
                <div>
                <label>CPF :</label>
                <input type="text" name="cpf" required="true"  placeholder="000.000.000-00" value="<c:out value="${cliente.cpf}"/>"> <br/>
                </div>
                
                <div>
                <label>Data:</label>
                <input type="date" name="dataCadastro" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataCadastro}" />" /> </td> 
                </div>
                
                <button type="reset" value="Limpar"/>Limpar</button>
                <button type="submit" value="Salvar"/>Salvar</button>
                   
                </form>
            </fieldset>
    </body>
</html>