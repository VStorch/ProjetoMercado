package estoque;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Supermercado {
	
	private static List<Produto> estoque = new ArrayList();
	
	public void adicionarProduto(Produto produto) {
		for (Produto produtos : estoque) {
			if (!produtos.getNome().equals(produto.getNome())) {
				estoque.add(produto);
				JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!", "Adição realizada", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Produto já cadastrado!", "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void removerProduto(String nomeProduto) {
		for (Produto produtos : estoque) {
			if (produtos.getNome().equals(nomeProduto)) {
				estoque.remove(nomeProduto);
				JOptionPane.showMessageDialog(null, "Produto removido com sucesso!", "Exclusão realizada", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado", "Erro de exclusão", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void listarProdutos() {
		
	}
	
	public void alterarProduto(String nomeProduto) {
		
	}
	
}
