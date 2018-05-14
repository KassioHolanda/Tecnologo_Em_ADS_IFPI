package br.com.programafidelidade.domain;

import java.util.Calendar;

public class Compra {
	private Produto produto;
	private Cliente cliente;
	private Estabelecimento estabelecimento;
	private Calendar date;

	public Compra(Produto produto, Cliente cliente, Estabelecimento estabelecimento) {
		this.produto = produto;
		this.cliente = cliente;
		this.estabelecimento = estabelecimento;
		this.date = Calendar.getInstance();
		cliente.setNumeroDeCompras(1);
		cliente.setDescontos(1.5 * cliente.getNumeroDeCompras());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Calendar getDate() {
		return date;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void definirDesconto(double preco){
		produto.setPreco(preco);
	}

}
