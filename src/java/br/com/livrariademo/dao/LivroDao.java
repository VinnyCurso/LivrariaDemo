/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrariademo.dao;

import br.com.livrariademo.model.Autor;
import br.com.livrariademo.model.Editora;
import br.com.livrariademo.model.Genero;
import br.com.livrariademo.model.Idioma;
import br.com.livrariademo.model.Livro;
import br.com.livrariademo.model.AcabamentoLivro;
import br.com.livrariademo.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public class LivroDao {
    
     private Connection connection;

    public LivroDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Livro livro) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into livro(codigoeditora, codigoautor, codigogenero, codigoidioma, codigoacabamento, "
                            + "ddatapublicacao, dnome, ddescricao, dnumeropaginas, dpreco, dpeso"
                            + ", davaliacao, disbn, daltura, dlargura, dprofundidade"
                            + ", dquantidadeestoque, dcodigoBarras, dcapa ) values "
                            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING cod_livro");

            preparedStatement.setInt(1, livro.getEditora().getCodigo());
            preparedStatement.setInt(2, livro.getAutor().getCodigo());
            preparedStatement.setInt(3, livro.getGenero().getCodigo());
            preparedStatement.setInt(4, livro.getIdioma().getCodigo());
            preparedStatement.setInt(5, livro.getAcabamento().getCodigo());
            preparedStatement.setDate(6, new java.sql.Date(livro.getDataPublicacao().getTime()));
            preparedStatement.setString(7, livro.getNome());
            preparedStatement.setString(8, livro.getDescricao());
            preparedStatement.setInt(9, livro.getNumeroPaginas());
            preparedStatement.setFloat(10, livro.getPreco());
            preparedStatement.setFloat(11, livro.getPeso());
            preparedStatement.setInt(12, livro.getAvaliacao());
            preparedStatement.setInt(13, livro.getIsbn());
            preparedStatement.setFloat(14, livro.getAltura());
            preparedStatement.setFloat(15, livro.getLargura());
            preparedStatement.setFloat(16, livro.getProfundidade());
            preparedStatement.setInt(17, livro.getQuantidadeEstoque());
            preparedStatement.setString(18, livro.getCodigoBarras());
            preparedStatement.setByte(19, livro.getCapa());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from livro where cod_livro=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Livro livro) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update livro set codigoeditora=?,"
                            + "codigoautor=?, codigogenero=?, codigoidioma=?, codigoacabamento=?,ddatapublicacao=?,"
                            + "dnome=?, ddescricao=?, dnumeropaginas=?, dpreco=?, dpeso=?,"
                            + "davaliacao=?, disbn=?, daltura=?, dlargura=?, dprofundidade=?,"
                            + "dquantidadeestoque=?, dcodigoBarras=?, dcapa=?"
                            + "where cod_livro=?");

            preparedStatement.setInt(1, livro.getEditora().getCodigo());
            preparedStatement.setInt(2, livro.getAutor().getCodigo());
            preparedStatement.setInt(3, livro.getGenero().getCodigo());
            preparedStatement.setInt(4, livro.getIdioma().getCodigo());
            preparedStatement.setInt(5, livro.getAcabamento().getCodigo());
            preparedStatement.setDate(6, new java.sql.Date(livro.getDataPublicacao().getTime()));
            preparedStatement.setString(7, livro.getNome());
            preparedStatement.setString(8, livro.getDescricao());
            preparedStatement.setInt(9, livro.getNumeroPaginas());
            preparedStatement.setFloat(10, livro.getPreco());
            preparedStatement.setFloat(11, livro.getPeso());
            preparedStatement.setInt(12, livro.getAvaliacao());
            preparedStatement.setInt(13, livro.getIsbn());
            preparedStatement.setFloat(14, livro.getAltura());
            preparedStatement.setFloat(15, livro.getLargura());
            preparedStatement.setFloat(16, livro.getProfundidade());
            preparedStatement.setInt(17, livro.getQuantidadeEstoque());
            preparedStatement.setString(18, livro.getCodigoBarras());
            preparedStatement.setByte(19, livro.getCapa());

            preparedStatement.setInt(20, livro.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Livro> Listar() {
        List<Livro> livroM = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from livro");
            while (rs.next()) {

                Livro livro = new Livro();

                livro.setCodigo(rs.getInt("cod_livro"));
                livro.setEditora((Editora) rs.getObject("codigoeditora"));
                livro.setAutor((Autor) rs.getObject("codigoautor"));
                livro.setGenero((Genero) rs.getObject("codigogenero"));
                livro.setIdioma((Idioma) rs.getObject("codigoidioma"));
                livro.setAcabamento((AcabamentoLivro)rs.getObject("codigoacabamento"));
                livro.setDataPublicacao(rs.getDate("ddatapublicacao"));
                livro.setNome(rs.getString("dnome"));
                livro.setDescricao(rs.getString("ddescricao"));
                livro.setCodigo(rs.getInt("dnumeropaginas"));
                livro.setPreco(rs.getFloat("dpreco"));
                livro.setPeso(rs.getFloat("dpeso"));
                livro.setAvaliacao(rs.getInt("davaliacao"));
                livro.setIsbn(rs.getInt("disbn"));
                livro.setAltura(rs.getFloat("daltura"));
                livro.setLargura(rs.getFloat("dlargura"));
                livro.setProfundidade(rs.getFloat("dprofundidade"));
                livro.setQuantidadeEstoque(rs.getInt("dquantidadeestoque"));
                livro.setCodigoBarras(rs.getString("dcodigoBarras"));
                livro.setCapa(rs.getByte("dcapa"));

                livroM.add(livro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return livroM;
    }

    public Livro Consultar(int codigo) {
        Livro livro = new Livro();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from livro where cod_livro=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                livro.setCodigo(rs.getInt("cod_livro"));
                livro.setEditora((Editora) rs.getObject("codigoeditora"));
                livro.setAutor((Autor) rs.getObject("codigoautor"));
                livro.setGenero((Genero) rs.getObject("codigogenero"));
                livro.setIdioma((Idioma) rs.getObject("codigoidioma"));
                livro.setAcabamento((AcabamentoLivro)rs.getObject("codigoacabamento"));
                livro.setDataPublicacao(rs.getDate("ddatapublicacao"));
                livro.setNome(rs.getString("dnome"));
                livro.setDescricao(rs.getString("ddescricao"));
                livro.setCodigo(rs.getInt("dnumeropaginas"));
                livro.setPreco(rs.getFloat("dpreco"));
                livro.setPeso(rs.getFloat("dpeso"));
                livro.setAvaliacao(rs.getInt("davaliacao"));
                livro.setIsbn(rs.getInt("disbn"));
                livro.setAltura(rs.getFloat("daltura"));
                livro.setLargura(rs.getFloat("dlargura"));
                livro.setProfundidade(rs.getFloat("dprofundidade"));
                livro.setQuantidadeEstoque(rs.getInt("dquantidadeestoque"));
                livro.setCodigoBarras(rs.getString("dcodigoBarras"));
                livro.setCapa(rs.getByte("dcapa"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return livro;
    }
    
    public Livro ConsultarPorCodigo(int codigo) {
		Livro livro = new Livro();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from livro where cod_livro=?");
			preparedStatement.setInt(1, codigo);
			ResultSet rs = preparedStatement.executeQuery();
		
                    if (rs.next()) {
                        livro.setCodigo(rs.getInt("cod_livro"));
                        livro.setEditora((Editora) rs.getObject("codigoeditora"));
                        livro.setAutor((Autor) rs.getObject("codigoautor"));
                        livro.setGenero((Genero) rs.getObject("codigogenero"));
                        livro.setIdioma((Idioma) rs.getObject("codigoidioma"));
                        livro.setAcabamento((AcabamentoLivro) rs.getObject("codigoacabamento"));
                        livro.setDataPublicacao(rs.getDate("ddatapublicacao"));
                        livro.setNome(rs.getString("dnome"));
                        livro.setDescricao(rs.getString("ddescricao"));
                        livro.setCodigo(rs.getInt("dnumeropaginas"));
                        livro.setPreco(rs.getFloat("dpreco"));
                        livro.setPeso(rs.getFloat("dpeso"));
                        livro.setAvaliacao(rs.getInt("davaliacao"));
                        livro.setIsbn(rs.getInt("disbn"));
                        livro.setAltura(rs.getFloat("daltura"));
                        livro.setLargura(rs.getFloat("dlargura"));
                        livro.setProfundidade(rs.getFloat("dprofundidade"));
                        livro.setQuantidadeEstoque(rs.getInt("dquantidadeestoque"));
                        livro.setCodigoBarras(rs.getString("dcodigoBarras"));
                        livro.setCapa(rs.getByte("dcapa"));

                        }
                        
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
		}

		return livro;
	}

    
    
}
