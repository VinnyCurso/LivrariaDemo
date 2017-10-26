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
        <script src="js/jsInterno/Cliente.js" type="text/javascript"></script>
        <jsp:include page = "source/headBoostrap.jsp" />

        <title>Formulario Cliente</title>

    </head>
    <body>
        <jsp:include page = "source/menuNavbar.jsp" />

        <h1>Formulario Cliente</h1>
        <div class="imgagem">
            <img src="image/livro1.jpg" class="img-circle" width="300" alt="cond" title="cond">
        </div>

        <div class="container">
            <fieldset>
                <legend>Formulario Cliente</legend>
                <form name="formCliente" method="post" action="ClienteServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" class="form-control" placeholder="000" readonly="readonly" value="<c:out value="${cliente.codigo}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Nome :</label>
                        <input type="text" name="nome"  class="form-control" required="true"  placeholder="Nome" value="<c:out value="${cliente.nome}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Email :</label>
                        <input type="email" name="email" class="form-control" required="true"  placeholder="xxx@xxxx.xxx" value="<c:out value="${cliente.email}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Telefone :</label>
                        <input type="tel" name="telefone" class="form-control" required="true"  placeholder="(00)0000-0000" value="<c:out value="${cliente.telefone}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>CPF :</label>
                        <input type="text" name="cpf" class="form-control" required="true"  placeholder="000.000.000-00" value="<c:out value="${cliente.cpf}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Data:</label>
                        <input type="date" name="dataCadastro" id="dataCadastro" class="form-control" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataCadastro}" />" /> </td> 
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
        <jsp:include page = "source/footer.jsp" />
    </body>
</html>