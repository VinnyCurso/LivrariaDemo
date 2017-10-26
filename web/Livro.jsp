<%-- 
    Document   : Livro
    Created on : 22/10/2017, 21:39:40
    Author     : vinicius caetano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jsInterno/Livro.js" type="text/javascript"></script>
        <jsp:include page = "source/headBoostrap.jsp" />
        <title>Formulario Livro</title>
    </head>
    <body>
        <jsp:include page = "source/menuNavbar.jsp" />
        <h1>Formulario Livro</h1>

        <div class="container">
            <fieldset>
                <legend>Formulario Livro</legend>
                <form name="formLivro" method="post" action="LivroServlet">

                    <div class="form-group">
                        <label>Codigo :</label>
                        <input type="number" name="codigo" class="form-control" placeholder="000" readonly="readonly" value="<c:out value="${livro.codigo}"/>"> <br/>
                    </div>

                    <div class="form-group" >
                        <label>Editora :</label>
                        <select name ="codeditora" class="form-control">
                            <c:forEach items="${editoraM}" var="editora">
                                <option value="<c:out value="${editora.codigo}"/>" 
                                        ${editora.codigo ==  livro.editora.codigo ? 'selected' : ''}>
                                    <c:out value="${editora.descricao}"/>
                                </option >
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Autor :</label>
                        <select name ="codautor"  class="form-control">
                            <c:forEach items="${autorM}" var="autor">
                                <option value="<c:out value="${autor.codigo}"/>" 
                                        ${autor.codigo ==  livro.autor.codigo ? 'selected' : ''}>
                                    <c:out value="${autor.descricao}"/>
                                </option >
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Genero :</label>
                        <select name ="codgenero" class="form-control">
                            <c:forEach items="${generoM}" var="genero">
                                <option value="<c:out value="${genero.codigo}"/>" 
                                        ${genero.codigo ==  livro.genero.codigo ? 'selected' : ''}>
                                    <c:out value="${genero.descricao}"/>
                                </option >
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Idioma :</label>
                        <select name ="codidioma" class="form-control" >
                            <c:forEach items="${idiomaM}" var="idioma">
                                <option value="<c:out value="${idioma.codigo}"/>" 
                                        ${idioma.codigo ==  livro.idioma.codigo ? 'selected' : ''}>
                                    <c:out value="${idioma.descricao}"/>
                                </option >
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Acabamento :</label>
                        <select name ="codacabamento" class="form-control">
                            <c:forEach items="${acabamentoM}" var="acabamento">
                                <option value="<c:out value="${acabamento.codigo}"/>" 
                                        ${acabamento.codigo ==  livro.acabamento.codigo ? 'selected' : ''}>
                                    <c:out value="${acabamento.descricao}"/>
                                </option >
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Data Publicação:</label>
                        <input type="date" name="dataPublicacao" class="form-control" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${livro.dataPublicacao}" />" /> </td> 
                    </div>

                    <div class="form-group">
                        <label>Nome :</label>
                        <input type="text" name="nome" required="true" class="form-control" placeholder="nome" value="<c:out value="${livro.nome}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Descricao :</label>
                        <input type="text" name="descricao" required="true" class="form-control" placeholder="descricao" value="<c:out value="${livro.descricao}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Numero de Paginas :</label>
                        <input type="text" name="numeropagina" required="true" class="form-control"  placeholder="numeropagina" value="<c:out value="${livro.numeroPaginas}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Preço :</label>
                        <input type="text" name="numeropagina" required="true" class="form-control" placeholder="numeropagina" value="<c:out value="${livro.numeroPaginas}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Peso :</label>
                        <input type="text" name="peso" required="true" class="form-control" placeholder="peso" value="<c:out value="${livro.peso}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Avaliação :</label>
                        <input type="number" name="avaliacao" required="true" class="form-control"  placeholder="avaliacao" value="<c:out value="${livro.avaliacao}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>ISBN :</label>
                        <input type="text" name="isbn" required="true" class="form-control" placeholder="isbn" value="<c:out value="${livro.isbn}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Altura :</label>
                        <input type="text" name="altura" required="true" class="form-control" placeholder="altura" value="<c:out value="${livro.altura}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Largura :</label>
                        <input type="text" name="largura" required="true" class="form-control" placeholder="largura" value="<c:out value="${livro.largura}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Profundidade :</label>
                        <input type="text" name="profundidade" required="true"class="form-control"  placeholder="profundidade" value="<c:out value="${livro.profundidade}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Quantidade em Estoque :</label>
                        <input type="text" name="quantidadeEstoque" required="true" class="form-control" placeholder="quantidadeEstoque" value="<c:out value="${livro.quantidadeEstoque}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Codigo de Barras :</label>
                        <input type="text" name="codigoBarras" required="true" class="form-control" placeholder="codigoBarras" value="<c:out value="${livro.codigoBarras}"/>"> <br/>
                    </div>

                    <div class="form-group">
                        <label>Capa :</label>
                        <input type="file" name="file" id="file" class="form-control"  placeholder="capa"  value="<c:out value="${livro.capa}"/>" onchange="atualizarFoto()"> <br/>
                        <img alt="imagem" src="image/livro4.jpg" name="capa" id="capa" width="60" >
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