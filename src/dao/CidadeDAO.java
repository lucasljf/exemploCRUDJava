package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Cidade;

public class CidadeDAO {

	private Connection conexao;
	private PreparedStatement stmt;
	
	public CidadeDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Cidade cidade) {
		String sql = "INSERT INTO cidade (nome) VALUES (?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cidade.getNome());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Cidade cidade) {
		String sql = "UPDATE cidade SET nome = ? WHERE idCidade = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cidade.getNome());
			stmt.setInt(2, cidade.getIdCidade());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Cidade pesquisaNome(String nomeCidade) {
		String sql = "SELECT * FROM cidade WHERE nome = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nomeCidade);
			ResultSet rs = stmt.executeQuery();
			Cidade cidade = new Cidade();
			if (rs.next()) {
				cidade.setIdCidade(rs.getInt("idCidade"));
				cidade.setNome(rs.getString("nome"));
			}
			return cidade;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cidade pesquisaId(int idCidade) {
		String sql = "SELECT * FROM cidade WHERE idCidade = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idCidade);
			ResultSet rs = stmt.executeQuery();
			Cidade cidade = new Cidade();
			if (rs.next()) {
				cidade.setIdCidade(rs.getInt("idCidade"));
				cidade.setNome(rs.getString("nome"));
			}
			return cidade;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Cidade> listarTudo() {
		String sql = "SELECT * FROM cidade";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cidade> lista = new ArrayList<Cidade>();
			while (rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setIdCidade(rs.getInt("idCidade"));
				cidade.setNome(rs.getString("nome"));
				lista.add(cidade);
			}
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
