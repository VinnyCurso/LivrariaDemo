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
        <jsp:include page = "source/headBoostrap.jsp" />
        <title>Formulario Venda</title>
    </head>
    <body>
        <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Formulario Venda</h1>

        <div class="container">
            <fieldset>
                <legend>Formulario Venda</legend>
                <form name="formVenda" method="post" action="VendaServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" placeholder="000" readonly="readonly" value="<c:out value="${venda.codigo}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Cliente :</label>
                        <select name ="codclente" class="form-control" >
                            <c:forEach items="${clienteM}" var="cliente">
                                <option value="<c:out value="${cliente.codigo}"/>" 
                                        ${cliente.codigo ==  venda.cliente.codigo ? 'selected' : ''}>
                                    <c:out value="${cliente.nome}"/>
                                </option >
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Usuario :</label>
                        <select name ="codusuario" class="form-control">
                            <c:forEach items="${usuarioM}" var="usuario">
                                <option value="<c:out value="${usuario.codigo}"/>" 
                                        ${usuario.codigo ==  venda.usuario.codigo ? 'selected' : ''}>
                                    <c:out value="${usuario.login}"/>
                                </option >
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Valor Total :</label>
                        <input type="text" name="valorTotal" class="form-control" required="true"  placeholder="valorTotal" value="<c:out value="${venda.valorTotal}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Tipo Pagamento :</label>
                        <input type="text" name="tipoPagamento" class="form-control" required="true"  placeholder="tipoPagamento" value="<c:out value="${venda.tipoPagamento}"/>"> <br/>
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





