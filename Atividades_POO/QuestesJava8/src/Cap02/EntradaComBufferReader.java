package Cap02;
import java.io.*;

import Cap02.DataInputStream;
public class EntradaComBufferReader {
	public static void main(String[] args) {
		String s;
		float largura, comprimento, area, perimetro;
		BufferedReader dado;
		try {
			System.out.println("Entre com o perimtro");
			dado = new BufferedReader(new InputStreamReader(System.in));
			s = dado.readLine();
			comprimento = Float.parseFloat(s);
			
			System.out.println("entre com a largura");
			dado = new BufferedReader(new InputStreamReader(System.in));
			s = dado.readLine();
			largura = Float.parseFloat(s);
			
			area = comprimento * largura;
			perimetro = comprimento * 2 + largura * 2;
			System.out.println("Area do retangulo: " + area);
			System.out.println("Perimetro do retangulo: " + perimetro);
		} catch (IOException erro) {
			System.out.println("Houve um erro na entrada de dados" + erro.toString());
		} catch (NumberFormatException erro) {
			System.out.println("Houve um erro na conversao, digite apenas caracteres numericos" + erro.toString());
				
		}
	}
}
