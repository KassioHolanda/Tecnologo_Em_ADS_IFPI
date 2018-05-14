package App;

import Domain.Rectangle;

import Domain.Point;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		String menu = "#### RT ####";
		menu += "\n 1 - Configurar rect1";
		menu += "\n 2 - Configurar rect2";
		menu += "\n 3 - Area rect1";
		menu += "\n 4 - Perimetro rect1";
		menu += "\n\n 0 - Sair\n";
		int op = -1;
		
		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle();
		rect1.pontoDeOrigem = new Point();
		rect2.pontoDeOrigem = new Point();
		
		while (op != 0){
			op = getInt(menu);
			switch (op) {
				case 1:
					rect1.height = getDouble("H: ");
					rect1.width = getDouble("W: ");
					rect1.pontoDeOrigem.x = getDouble("Rect1 X: ");
					rect1.pontoDeOrigem.y = getDouble("Rect1 Y: ");
					break;
				
				case 2:	
					rect2.height = getDouble("H: ");
					rect2.width = getDouble("W: ");
					rect2.pontoDeOrigem.x = getDouble("Rect2 X: ");
					rect2.pontoDeOrigem.y = getDouble("Rect2 Y: ");
					break;
				
				case 3:
					showMsg("Rect1 Area: " + rect1.area());
					break;
				
				case 4:
					showMsg("Rect1 perimetro: " + rect1.perimeter());
					break;
				case 0:
					break;
				
				default:
					showMsg("Opção invalida");
					break;
			}
		}
	}
	private static void showMsg(String menu){
		JOptionPane.showConfirmDialog(null, menu);
	}
	
	private static String getString(String msg){
		return JOptionPane.showInputDialog(msg);
	}
	
	private static int getInt(String msg){
		return Integer.valueOf(JOptionPane.showInputDialog(msg));
	}
	
	private static Double getDouble(String msg){
		String entrada = JOptionPane.showInputDialog(msg);
		return Double.valueOf(entrada);
	}
}
