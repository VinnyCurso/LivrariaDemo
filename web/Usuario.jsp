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
        <jsp:include page = "source/headBoostrap.jsp" />
        <title>Formulario Usuario</title>
    </head>
    <body>
        <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Formulario Usuario</h1>

        <div class="container">
            <fieldset>
                <legend>Formulario Usuario</legend>
                <form name="formUsuario" method="post" action="UsuarioServlet">

                    <div  class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" class="form-control" placeholder="000" readonly="readonly" value="<c:out value="${usuario.codigo}"/>"> <br/>
                    </div>

                    <div  class="form-group">
                        <label>Login :</label>
                        <input type="email" name="login" class="form-control" required="true"  placeholder="login" value="<c:out value="${usuario.login}"/>"> <br/>
                    </div>

                    <div  class="form-group">
                        <label>Password :</label>
                        <input type="password" name="password" class="form-control" required="true"  placeholder="password" value="<c:out value="${usuario.password}"/>"> <br/>
                    </div>

                    <div  class="form-group">
                        <label>Confirmação Password :</label>
                        <input type="password" name="confirmacaoPassword" class="form-control" required="true"  placeholder="confirmacaoPassword" value="<c:out value="${usuario.confirmacaoPassword}"/>"> <br/>
                    </div>

                    <div  class="form-group">
                        <label>Nome :</label>
                        <input type="text" name="name" class="form-control" required="true"  placeholder="name" value="<c:out value="${usuario.name}"/>"> <br/>
                    </div>

                    <div  class="form-group">
                        <label>Ativo :</label>
                        <input type="number" name="ativo" class="form-control" required="true"  placeholder="ativo" value="<c:out value="${usuario.ativo}"/>"> <br/>
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
