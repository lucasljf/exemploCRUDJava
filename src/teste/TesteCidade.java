package teste;

import java.util.ArrayList;

import dao.CidadeDAO;
import model.Cidade;

public class TesteCidade {

	public static void main(String[] args) {
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		
//		Cidade c1 = new Cidade();
//		c1.setNome("Rialma");
//		cidadeDAO.inserir(c1);		
		
//
//		Cidade c2 = cidadeDAO.pesquisaNome("Carmo");
//		System.out.println(c2.getIdCidade());
//		System.out.println(c2.getNome());
		
//		Cidade c3 = cidadeDAO.pesquisaId(3);
//		System.out.println(c3.getIdCidade());
//		System.out.println(c3.getNome());
		
		ArrayList<Cidade> lista = cidadeDAO.listarTudo();
		System.out.println(lista);
		
		System.out.println("FIM");
	}
}
