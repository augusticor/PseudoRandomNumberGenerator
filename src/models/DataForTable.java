package models;

public class DataForTable {

	private int i;
	private int Xn;
	private double Ri;
	private double Ni;

	public DataForTable(int i, int xn, double ri, double ni) {
		this.i = i;
		Xn = xn;
		Ri = ri;
		Ni = ni;
	}

	public String toString() {
		return "i : " + i + "\n" + "Xn : " + Xn + "\n" + "Ri : " + Ri + "\n" + "Ni : " + Ni + "\n";
	}

	public int getI() {
		return i;
	}

	public int getXn() {
		return Xn;
	}

	public double getRi() {
		return Ri;
	}

	public double getNi() {
		return Ni;
	}
}