package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.Conexao;
import model.Aluno;

public class AlunoDAO {

    private Connection conexao;
    private PreparedStatement stmt;

    public AlunoDAO() {
        this.conexao = new Conexao().getConexao();
    }

    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, idCidade) VALUES (?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getCidade().getIdCidade());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Aluno pesquisaNome(String nomeAluno) {
        String sql = "SELECT * FROM aluno WHERE nome = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeAluno);
            ResultSet rs = stmt.executeQuery();
            Aluno aluno = new Aluno();
            if (rs.next()) {
                aluno.setIdAluno(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));

                CidadeDAO cidadeDAO = new CidadeDAO();
                aluno.setCidade(cidadeDAO.pesquisaId(rs.getInt("idCidade")));
            }
            stmt.close();
            return aluno;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Aluno> listarTudo() {
        String sql = "SELECT * FROM aluno";
        try {
            stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Aluno> lista = new ArrayList<Aluno>();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));

                CidadeDAO cidadeDAO = new CidadeDAO();
                aluno.setCidade(cidadeDAO.pesquisaId(rs.getInt("idCidade")));
                lista.add(aluno);
            }
            stmt.close();
            return lista;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
