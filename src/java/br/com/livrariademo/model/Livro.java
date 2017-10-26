/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.model;

import java.util.Date;

/**
 *
 * @author vinicius caetano
 */
public class Livro {
    
    private int codigo;
    private Editora editora;
    private Autor autor;
    private Genero genero;
    private Idioma idioma;
    private AcabamentoLivro acabamento;
    private Date dataPublicacao;
    private String nome;
    private String descricao;
    private int numeroPaginas;
    private float preco;
    private float peso;
    private int avaliacao;
    private int isbn;
    private float altura;
    private float largura;
    private float profundidade;
    private int quantidadeEstoque;
    private String codigoBarras;
    private byte capa;

    public Livro() {
    }

    public Livro(int codigo, Editora editora, Idioma idioma, Autor autor, Genero genero, AcabamentoLivro acabamento, String nome) {
        this.codigo = codigo;
        this.editora = editora;
        this.idioma = idioma;
        this.autor = autor;
        this.genero = genero;
        this.acabamento = acabamento;
        this.nome = nome;
    }

    public Livro(int codigo, Editora editora, Idioma idioma, Autor autor, Genero genero, AcabamentoLivro acabamento, Date dataPublicacao, String nome, String descricao, int numeroPaginas, float preco, float peso, int avaliacao, int isbn, float altura, float largura, float profundidade, int quantidadeEstoque, String codigoBarras, byte capa) {
        this.codigo = codigo;
        this.editora = editora;
        this.idioma = idioma;
        this.autor = autor;
        this.genero = genero;
        this.acabamento = acabamento;
        this.dataPublicacao = dataPublicacao;
        this.nome = nome;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
        this.preco = preco;
        this.peso = peso;
        this.avaliacao = avaliacao;
        this.isbn = isbn;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.codigoBarras = codigoBarras;
        this.capa = capa;
    }

    public Livro(int codigo, String nome, String descricao, int numeroPaginas) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public AcabamentoLivro getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(AcabamentoLivro acabamento) {
        this.acabamento = acabamento;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(float profundidade) {
        this.profundidade = profundidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public byte getCapa() {
        return capa;
    }

    public void setCapa(byte capa) {
        this.capa = capa;
    }

    @Override
    public String toString() {
        return "Livro{" + "codigo=" + codigo + ", editora=" + editora + ", idioma=" + idioma + ", autor=" + autor + ", genero=" + genero + ", acabamento=" + acabamento + ", dataPublicacao=" + dataPublicacao + ", nome=" + nome + ", descricao=" + descricao + ", numeroPaginas=" + numeroPaginas + ", preco=" + preco + ", peso=" + peso + ", avaliacao=" + avaliacao + ", isbn=" + isbn + ", altura=" + altura + ", largura=" + largura + ", profundidade=" + profundidade + ", quantidadeEstoque=" + quantidadeEstoque + ", codigoBarras=" + codigoBarras + ", capa=" + capa + '}';
    }
    
 
    
}
