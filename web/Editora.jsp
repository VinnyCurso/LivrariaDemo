<%-- 
    Document   : Editora
    Created on : 19/10/2017, 15:15:58
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Editora</title>
    </head>
    <body>
        <h1>Formulario Editora</h1>
        
         <fieldset>
             <legend>Formulario Editora</legend>
            <form name="formEditora" method="post" action="EditoraServlet">
                
                <div>
                <label>Codigo :</label>
                <input type="number" name="codigo" placeholder="000" readonly="readonly" value="<c:out value="${editora.codigo}"/>"> <br/>
               </div>
               
               <div>
                <label>Descrição :</label>
                <input type="text" name="descricao" required="true"  placeholder="Descrição" value="<c:out value="${editora.descricao}"/>"> <br/>
                </div>
 
                <button type="reset" value="Limpar"/>Limpar</button>
                <button type="submit" value="Salvar"/>Salvar</button>
                   
                </form>
            </fieldset>
    </body>
</html>
