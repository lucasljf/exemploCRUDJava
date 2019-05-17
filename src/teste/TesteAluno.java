package teste;

import java.util.ArrayList;

import dao.AlunoDAO;
import dao.CidadeDAO;
import model.Aluno;
import model.Cidade;

public class TesteAluno {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();
        CidadeDAO cidadeDAO = new CidadeDAO();

        // Cidade c1 = new Cidade();
        // c1.setNome("Ceres");

        // Aluno a1 = new Aluno();
        // a1.setNome("Teste");

        // if (cidadeDAO.pesquisaNome(c1.getNome()).getIdCidade() == 0) {
        // cidadeDAO.inserir(c1);
        // }
        // c1 = cidadeDAO.pesquisaNome(c1.getNome());

        // a1.setCidade(c1);
        // alunoDAO.inserir(a1);

        Aluno alunoPesquisado = alunoDAO.pesquisaNome("Teste");

        if (alunoPesquisado.getIdAluno() != 0) {
            System.out.println(alunoPesquisado.getIdAluno());
            System.out.println(alunoPesquisado.getNome());
            System.out.println(alunoPesquisado.getCidade().getNome());
        }

        ArrayList<Aluno> alunos = alunoDAO.listarTudo();
        for (Aluno a : alunos) {
            System.out.println(a.getIdAluno());
            System.out.println(a.getNome());
            System.out.println(a.getCidade().getIdCidade());
            System.out.println(a.getCidade().getNome());
        }
    }
}