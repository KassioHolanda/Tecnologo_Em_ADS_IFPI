package Cap02;

public class ConversaoDeTipos {
	public static void main(String[] args) {
		String a1 = "10";
		int v = Integer.parseInt(a1);
		float x = Float.parseFloat(a1);
		double y = Double.parseDouble(a1);
		int w = (int) x;
		int z = (int) y;
		String a2 = String.valueOf(v);
		System.out.println(a2 + w + z);
	}
}
