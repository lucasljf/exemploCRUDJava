package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
