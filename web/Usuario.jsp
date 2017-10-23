<%-- 
    Document   : Usuario
    Created on : 23/10/2017, 01:18:42
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Usuario</title>
    </head>
    <body>
        <h1>Formulario Usuario</h1>
        
         <fieldset>
             <legend>Formulario Usuario</legend>
            <form name="formUsuario" method="post" action="UsuarioServlet">
                
                <div>
                <label>Codigo :</label>
                <input type="number" name="codigo" placeholder="000" readonly="readonly" value="<c:out value="${usuario.codigo}"/>"> <br/>
               </div>
               
               <div>
                <label>Login :</label>
                <input type="email" name="login" required="true"  placeholder="login" value="<c:out value="${usuario.login}"/>"> <br/>
                </div>
                
                <div>
                <label>Password :</label>
                <input type="password" name="password" required="true"  placeholder="password" value="<c:out value="${usuario.password}"/>"> <br/>
                </div>
                
                <div>
                <label>Confirmação Password :</label>
                <input type="password" name="confirmacaoPassword" required="true"  placeholder="confirmacaoPassword" value="<c:out value="${usuario.confirmacaoPassword}"/>"> <br/>
                </div>
                
                <div>
                <label>Nome :</label>
                <input type="text" name="name" required="true"  placeholder="name" value="<c:out value="${usuario.name}"/>"> <br/>
                </div>
                
                <div>
                <label>Ativo :</label>
                <input type="number" name="ativo" required="true"  placeholder="ativo" value="<c:out value="${usuario.ativo}"/>"> <br/>
                </div>
 
                <button type="reset" value="Limpar"/>Limpar</button>
                <button type="submit" value="Salvar"/>Salvar</button>
                   
                </form>
            </fieldset>
    </body>
</html>
