package br.com.programafidelidade.app;

import br.com.programafidelidade.domain.Cliente;
import br.com.programafidelidade.domain.Compra;
import br.com.programafidelidade.domain.Estabelecimento;
import br.com.programafidelidade.domain.Funcionario;
import br.com.programafidelidade.domain.Produto;

public class MainCompra {
	public static void main(String[] args) {
		Produto produto = new Produto("Jaca", 12.00);
		Cliente cliente = new Cliente("Kassio", "123");
		Funcionario funcionario = new Funcionario("Kasiso", "123", "7:30", 1379);
		Estabelecimento estabelecimento = new Estabelecimento(funcionario, "Mercearia do Jaca", "Planalto Uruguai", produto);
		
		Compra compra = new Compra(produto, cliente, estabelecimento);
		
		System.out.println(compra.getCliente().getNome());
		System.out.println(compra.getCliente().getNumeroDeCompras());
		System.out.println(compra.getCliente().getDescontos());
		
		
		compra.definirDesconto(cliente.getDescontos());
		System.out.println(compra.getProduto().getPreco());
	}
}
