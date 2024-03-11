package mercadinho.mercadinho;

import java.util.HashMap;

public class Usuario {
	private HashMap<String, String> listaDeUsuarios = new HashMap<>();

	public void cadastroDeUsuário(String nome, String senha) {

		listaDeUsuarios.put(nome, senha);
	}

	public void login(String nome, String senha) {
		if (listaDeUsuarios.containsKey(nome)) {
			String senhaDigitada = listaDeUsuarios.get(senha);
			if (!senha.equals(senhaDigitada)) {

				System.out.println("Login ou senha incorreto.");
			} else {

				System.out.println("Bem-vindo!");
			}

		} else {
			
			System.out.println("Usuário não encontrado.");
			
		}

	}
}
