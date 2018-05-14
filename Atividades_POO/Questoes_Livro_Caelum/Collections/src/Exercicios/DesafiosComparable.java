package Exercicios;

public class DesafiosComparable implements Comparable<DesafiosComparable>{

	int numerosComparable;
	
	public DesafiosComparable() {
		// TODO Auto-generated constructor stub
	}

	public DesafiosComparable(int i) {
		numerosComparable = i;
	}

	@Override
	public int compareTo(DesafiosComparable o) {
		if(this.numerosComparable < o.numerosComparable){
			return -1;
		} else if(this.numerosComparable > o.numerosComparable){
			return 1;
		}
		return 0;
	}

}
