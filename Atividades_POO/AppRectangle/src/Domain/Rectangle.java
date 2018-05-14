package Domain;

public class Rectangle {
	public double width;
	public double height;
	public Point pontoDeOrigem;

	public double area() {
		double area = this.width * this.height;
		return area;
	}

	public double perimeter() {
		return 2 * this.width * 2 * this.height;
	}

	public String EstaContido(Rectangle rectangle) {
		if (Math.sqrt(Math.pow(rectangle.pontoDeOrigem.x - (pontoDeOrigem.x + width), 2)) <= Math
				.sqrt(Math.pow(pontoDeOrigem.x - (pontoDeOrigem.x + width), 2))) {
			if (Math.sqrt(Math.pow(rectangle.pontoDeOrigem.y - (pontoDeOrigem.y + height), 2)) <= Math
					.sqrt(Math.pow(pontoDeOrigem.y - (pontoDeOrigem.y + height), 2))) {
				return "Esta contido";
			}
		}
		return "Nao esta condido";
	}
}
