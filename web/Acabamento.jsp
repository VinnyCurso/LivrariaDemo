<%-- 
    Document   : Acabamento
    Created on : 18/10/2017, 15:47:41
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Acabamento</title>
    </head>
    <body>
        <h1>Formulario Acabamento</h1>
        
         <fieldset>
             <legend>Formulario Acabamento Livro</legend>
            <form name="formAcabamento" method="post" action="AcabamentoServlet">
                
                <div>
                <label>Codigo :</label>
                <input type="number" name="codigo" placeholder="000" readonly="readonly" value="<c:out value="${acabamento.codigo}"/>"> <br/>
               </div>
               
               <div>
                <label>Descrição :</label>
                <input type="text" name="descricao" required="true"  placeholder="Descrição" value="<c:out value="${acabamento.descricao}"/>"> <br/>
                </div>
 
                <button type="reset" value="Limpar"/>Limpar</button>
                <button type="submit" value="Salvar"/>Salvar</button>
                   
                </form>
            </fieldset>
    </body>
</html>
