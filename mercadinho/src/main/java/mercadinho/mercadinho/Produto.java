package mercadinho.mercadinho;

import java.util.HashMap;

public class Produto {

	private HashMap<String, Double> listaDeProdutos = new HashMap<String, Double>();
	private HashMap<String, Double> listaDeCarrinho = new HashMap<String, Double>();

	public Produto() {
		listaDeProdutos.put("Arroz", 3.99);
		listaDeProdutos.put("Feijão", 5.99);
		listaDeProdutos.put("Óleo", 7.50);
		listaDeProdutos.put("Macarrão instantâneo", 2.99);
		listaDeProdutos.put("Chocolate", 5.00);
		listaDeProdutos.put("Leite", 3.99);
		listaDeProdutos.put("Farinha de trigo", 6.70);

	}

	public String listarProdutos() {
		String listagemDeprodutos = "";
		if (listaDeProdutos.isEmpty()) {

			System.out.println("Nenhum produto disponível");

		} else {
			for (String key : listaDeProdutos.keySet()) {
				listagemDeprodutos += "Produto: " + key + ", preço: " + listaDeProdutos.get(key);

			}
		}
		return listagemDeprodutos;
	}

	public void adicionarAoCarrinho(String produto) {

		if (listaDeProdutos.containsKey(produto)) {
			double preco = listaDeProdutos.get(produto);
			listaDeCarrinho.put(produto, preco);

		} else {

			System.out.println("Produto não encontrado");

		}

	}

	public void removerDoCarrinho(String produto) {

		listaDeCarrinho.remove(produto);

	}

	public String listarCarrinho() {
		String listagemDoCarrinho = "";
		if (listaDeCarrinho.isEmpty()) {

			System.out.println("Nenhum produto adicionaod ao carrinho");

		} else {
			for (String key : listaDeCarrinho.keySet()) {
				listagemDoCarrinho += "Produto: " + key + ", preço: " + listaDeCarrinho.get(key);

			}
		}
		return listagemDoCarrinho;
	}

	public void finalizarCompra() {

		listaDeCarrinho.clear();

		// Tentar fazer com que mostre o valor total da compra;
	}

}
