<%-- 
    Document   : Autor
    Created on : 19/10/2017, 14:41:27
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Autor</title>
    </head>
    <body>
        <h1>Formulario Autor</h1>
        
         <fieldset>
             <legend>Formulario Autor</legend>
            <form name="formAutor" method="post" action="AutorServlet">
                
                <div>
                <label>Codigo :</label>
                <input type="number" name="codigo" placeholder="000" readonly="readonly" value="<c:out value="${autor.codigo}"/>"> <br/>
               </div>
               
               <div>
                <label>Descrição :</label>
                <input type="text" name="descricao" required="true"  placeholder="Descrição" value="<c:out value="${autor.descricao}"/>"> <br/>
                </div>
 
                <button type="reset" value="Limpar"/>Limpar</button>
                <button type="submit" value="Salvar"/>Salvar</button>
                   
                </form>
            </fieldset>
    </body>
</html>
