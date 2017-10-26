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
         <jsp:include page = "source/headBoostrap.jsp" />
        <title>Formulario Editora</title>
    </head>
    <body>
          <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Formulario Editora</h1>
        
        <div class="container">
         <fieldset>
             <legend>Formulario Editora</legend>
            <form name="formEditora" method="post" action="EditoraServlet">
                
                <div class="form-group">
                <label>Codigo :</label>
                <input type="number"  name="codigo"   class="form-control" placeholder="000" readonly="readonly" value="<c:out value="${editora.codigo}"/>"> <br/>
               </div>
               
               <div class="form-group">
                <label>Descrição :</label>
                <input type="text" name="descricao"  class="form-control" required="true"  placeholder="Descrição" value="<c:out value="${editora.descricao}"/>"> <br/>
                </div>
 
               <button class="btn btn-large btn btn-info" type="reset" value="Limpar"
                            data-toggle="tooltip"  title="Clique para Limpar Campos">
                        <span class=" glyphicon glyphicon-erase"></span>
                        Limpar
                    </button>

                    <button class="btn btn-large btn btn-success" data-toggle="tooltip" type="submit" 
                            title="Clique para Salvar" value="Salvar">
                        <span class=" glyphicon glyphicon-send"></span>
                        Salvar
                    </button>
                   
                </form>
            </fieldset>
                </div>
    </body>
</html>
