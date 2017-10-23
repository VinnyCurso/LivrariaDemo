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
        <title>Formulario Livro</title>
    </head>
    <body>
        <h1>Formulario Livro</h1>
        
         <fieldset>
             <legend>Formulario Livro</legend>
            <form name="formLivro" method="post" action="LivroServlet">
                
                <div>
                <label>Codigo :</label>
                <input type="number" name="codigo" placeholder="000" readonly="readonly" value="<c:out value="${livro.codigo}"/>"> <br/>
               </div>
               
               <div>
                <label>Editora :</label>
                <select name ="codeditora" >
                                <c:forEach items="${editoraM}" var="editora">
                                    <option value="<c:out value="${editora.codigo}"/>" 
                                            ${editora.codigo ==  livro.editora.codigo ? 'selected' : ''}>
                                                   <c:out value="${editora.descricao}"/>
                                    </option >
                                </c:forEach>
                            </select>
                </div>
               
                <div>
                <label>Autor :</label>
                <select name ="codautor" >
                                <c:forEach items="${autorM}" var="autor">
                                    <option value="<c:out value="${autor.codigo}"/>" 
                                            ${autor.codigo ==  livro.autor.codigo ? 'selected' : ''}>
                                                   <c:out value="${autor.descricao}"/>
                                    </option >
                                </c:forEach>
                            </select>
                </div>
               
                <div>
                <label>Genero :</label>
                <select name ="codgenero" >
                                <c:forEach items="${generoM}" var="genero">
                                    <option value="<c:out value="${genero.codigo}"/>" 
                                            ${genero.codigo ==  livro.genero.codigo ? 'selected' : ''}>
                                                   <c:out value="${genero.descricao}"/>
                                    </option >
                                </c:forEach>
                            </select>
                </div>
               
                <div>
                <label>Idioma :</label>
                <select name ="codidioma" >
                                <c:forEach items="${idiomaM}" var="idioma">
                                    <option value="<c:out value="${idioma.codigo}"/>" 
                                            ${idioma.codigo ==  livro.idioma.codigo ? 'selected' : ''}>
                                                   <c:out value="${idioma.descricao}"/>
                                    </option >
                                </c:forEach>
                            </select>
                </div>
               
                <div>
                <label>Acabamento :</label>
                <select name ="codacabamento" >
                                <c:forEach items="${acabamentoM}" var="acabamento">
                                    <option value="<c:out value="${acabamento.codigo}"/>" 
                                            ${acabamento.codigo ==  livro.acabamento.codigo ? 'selected' : ''}>
                                                   <c:out value="${acabamento.descricao}"/>
                                    </option >
                                </c:forEach>
                            </select>
                </div>
               
               <div>
                <label>Data Publicação:</label>
                <input type="date" name="dataPublicacao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${livro.dataPublicacao}" />" /> </td> 
                </div>
               
               <div>
                <label>Nome :</label>
                <input type="text" name="nome" required="true"  placeholder="nome" value="<c:out value="${livro.nome}"/>"> <br/>
                </div>
                
                <div>
                <label>Descricao :</label>
                <input type="text" name="descricao" required="true"  placeholder="descricao" value="<c:out value="${livro.descricao}"/>"> <br/>
                </div>
                
                <div>
                <label>Numero de Paginas :</label>
                <input type="text" name="numeropagina" required="true"  placeholder="numeropagina" value="<c:out value="${livro.numeroPaginas}"/>"> <br/>
                </div>
                
                <div>
                <label>Preço :</label>
                <input type="text" name="numeropagina" required="true"  placeholder="numeropagina" value="<c:out value="${livro.numeroPaginas}"/>"> <br/>
                </div>
                
                 <div>
                <label>Peso :</label>
                <input type="text" name="peso" required="true"  placeholder="peso" value="<c:out value="${livro.peso}"/>"> <br/>
                </div>
                
                 <div>
                <label>Avaliação :</label>
                <input type="number" name="avaliacao" required="true"  placeholder="avaliacao" value="<c:out value="${livro.avaliacao}"/>"> <br/>
                </div>
                
                 <div>
                <label>ISBN :</label>
                <input type="text" name="isbn" required="true"  placeholder="isbn" value="<c:out value="${livro.isbn}"/>"> <br/>
                </div>
                
                <div>
                <label>Altura :</label>
                <input type="text" name="altura" required="true"  placeholder="altura" value="<c:out value="${livro.altura}"/>"> <br/>
                </div>
                
                  <div>
                <label>Largura :</label>
                <input type="text" name="largura" required="true"  placeholder="largura" value="<c:out value="${livro.largura}"/>"> <br/>
                </div>
                
                 <div>
                <label>Profundidade :</label>
                <input type="text" name="profundidade" required="true"  placeholder="profundidade" value="<c:out value="${livro.profundidade}"/>"> <br/>
                </div>
                
                <div>
                <label>Quantidade em Estoque :</label>
                <input type="text" name="quantidadeEstoque" required="true"  placeholder="quantidadeEstoque" value="<c:out value="${livro.quantidadeEstoque}"/>"> <br/>
                </div>
                
                <div>
                <label>Codigo de Barras :</label>
                <input type="text" name="codigoBarras" required="true"  placeholder="codigoBarras" value="<c:out value="${livro.codigoBarras}"/>"> <br/>
                </div>
                
                <div>
                <label>Capa :</label>
                <input type="file" name="capa" required="true"  placeholder="capa" value="<c:out value="${livro.capa}"/>"> <br/>
                </div>
 
                <button type="reset" value="Limpar"/>Limpar</button>
                <button type="submit" value="Salvar"/>Salvar</button>
                   
                </form>
            </fieldset>
    </body>
</html>