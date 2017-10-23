<%-- 
    Document   : Venda
    Created on : 23/10/2017, 01:30:27
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Venda</title>
    </head>
    <body>
        <h1>Formulario Venda</h1>
        
         <fieldset>
             <legend>Formulario Venda</legend>
            <form name="formVenda" method="post" action="VendaServlet">
                
                <div>
                <label>Codigo :</label>
                <input type="number" name="codigo" placeholder="000" readonly="readonly" value="<c:out value="${venda.codigo}"/>"> <br/>
               </div>
               
               <div>
                <label>Cliente :</label>
                <select name ="codclente" >
                                <c:forEach items="${clienteM}" var="cliente">
                                    <option value="<c:out value="${cliente.codigo}"/>" 
                                            ${cliente.codigo ==  venda.cliente.codigo ? 'selected' : ''}>
                                                   <c:out value="${cliente.nome}"/>
                                    </option >
                                </c:forEach>
                            </select>
                </div>
               
               <div>
                <label>Usuario :</label>
                <select name ="codusuario" >
                                <c:forEach items="${usuarioM}" var="usuario">
                                    <option value="<c:out value="${usuario.codigo}"/>" 
                                            ${usuario.codigo ==  venda.usuario.codigo ? 'selected' : ''}>
                                                   <c:out value="${usuario.login}"/>
                                    </option >
                                </c:forEach>
                            </select>
                </div>
               
                <div>
                <label>Valor Total :</label>
                <input type="text" name="valorTotal" required="true"  placeholder="valorTotal" value="<c:out value="${venda.valorTotal}"/>"> <br/>
                </div>
                
                 <div>
                <label>Tipo Pagamento :</label>
                <input type="text" name="tipoPagamento" required="true"  placeholder="tipoPagamento" value="<c:out value="${venda.tipoPagamento}"/>"> <br/>
                </div>
                
                    <button type="reset" value="Limpar"/>Limpar</button>
                <button type="submit" value="Salvar"/>Salvar</button>
                   
                </form>
            </fieldset>
    </body>
</html>
                
         
                
                
               
