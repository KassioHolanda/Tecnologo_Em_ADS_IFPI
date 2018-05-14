package app;

import javax.swing.JOptionPane;

import domain.*;

public class TestaEstacionamento {
	public static void main(String[] args) {
		Estacionamento novo = Estacionamento.getInstance();
		int opcao = 0;
		
		while (opcao != 4) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"## ESTACIONAMENTO 666 ### ##\n1 - Entrada\n2 - Saída\n3 - Listar Situacao Atual\n4 - Encerrar o programa"));
			if (opcao == 1) {
				String modelo = JOptionPane.showInputDialog("Modelo: ");
				String placa = JOptionPane.showInputDialog("Placa: ");
				
				Veiculo veiculo = new Veiculo(placa, modelo);
				
				novo.adicionaVeiculo(veiculo);
				JOptionPane.showMessageDialog(null, "Vaga Preenchida");
				
			}if (opcao == 2){
				int vaga = Integer.parseInt(JOptionPane.showInputDialog("Qual vaga vai sair: "));
				novo.removerEstacionamento(vaga);
			
			}if(opcao == 3) {
				msg(novo.listarEstacionamento());
	
			
			}if(opcao == 4) {
				System.exit(0);
			}
		}
	}
	
	public static void msg(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
}
