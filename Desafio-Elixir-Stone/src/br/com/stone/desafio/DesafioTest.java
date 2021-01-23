package br.com.stone.desafio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * classe calcula o valor total das compras e os divide entre os usuarios dos emails cadastrados
 * @author Michelle Luz Rodirgues
 *@data 23 / 01 / 2021
 *
 
 */
public class DesafioTest {

	public static void main(String[] args) {
		// lista com os produtos para compras
		List<Produto> produto = new ArrayList<>();
		
		produto.add(new Produto("Macarrão", 1, 2.50F, 500, "g"));
		produto.add(new Produto("Feijão", 4, 7.20F, 1, "kg"));
		produto.add(new Produto("Arroz", 2, 6.99F, 1, "kg"));
		produto.add(new Produto("Farinha de trigo", 3, 1.79F, 500, "g"));
		produto.add(new Produto("Miojo", 10, 1.69F, 85, "g"));
		produto.add(new Produto("Molho de tomate", 3, 2.29F, 340, "g"));
		produto.add(new Produto("Refrigerante coca-cola", 4, 8.19F, 2, "l"));
		produto.add(new Produto("Banana prata", 1, 6.99F, 1, "kg"));
		produto.add(new Produto("Ração Dog Show", 1, 84.90F, 10, "kg"));
		produto.add(new Produto("Agua sanitaria", 1, 4.59F, 2, "L"));
		produto.add(new Produto("Detergente", 5, 1.89F, 500, "ml"));
		
		// lista de emails
		List<String> email = new ArrayList<>();
		email.add("mario.matar@gmail.com");
		email.add("maria2356Leandra@yahoo.com.br");
		email.add("lucassouza12@bol.com.br");
		email.add("aginaldotimoteo@hotmail.com");
		email.add("elsasoares.96@outlook.com");
		email.add("valdinerecruz@gmail.com");
		email.add("teobaldopinto@outlook.com.br");

		// soma o total que será gasto com a compra
		float soma = 0;
		for (Produto produto2 : produto) {
			soma += produto2.valorTotal();
		}
		
		System.out.println("Soma total: "+ soma);

		// separa o valor por email e comverte para bigdecimal para evitar erros de precisão
		BigDecimal divisao = new BigDecimal(soma / email.size());
		
		// monta o map com o email e o valor
		Map<String, BigDecimal> dicionario = new HashMap<>();
		
		// variavel para calcular o ajuste
		BigDecimal somaDecimal = new BigDecimal("0.00");

		// adicona os elementos ao mapa
		for (String e : email) {
			dicionario.put(e, divisao.setScale(2, BigDecimal.ROUND_DOWN));
			somaDecimal = somaDecimal.add(divisao.setScale(2, BigDecimal.ROUND_DOWN));
		}

		// converte o valor total para bigDecimal e subtrai o valor da variavel somaDecimal
		BigDecimal resultado = new BigDecimal(soma).add(somaDecimal.negate());
		
		// atualiza o valor paga do ultimo email inserido na lista, realiza a soma da 
		// variavel resultado ao valor a ser pago originalmente
		dicionario.put(email.get(email.size() - 1), dicionario.get(email.get(email.size()-1))
				.add(resultado).setScale(2, BigDecimal.ROUND_DOWN)); 
		
		// laço para imprimir o valor a ser pago para cado email
		for (Entry<String, BigDecimal> map : dicionario.entrySet()) {
			
			System.out.println("Email: " + map.getKey() + " valor: " + map.getValue());
		}
	}

}
