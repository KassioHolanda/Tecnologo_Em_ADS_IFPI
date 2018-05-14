package Cap05;

import java.text.DecimalFormat;

public class ArrayNumeros {
	public static void main(String[] args) {
		int[] inteiro = new int[10];
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("0000");
		for (int i = 0; i < inteiro.length; i++) {
			inteiro[i] = (int) (Math.random() * 1000);
			System.out.println(df.format(inteiro[i]));
		}
	}
}
