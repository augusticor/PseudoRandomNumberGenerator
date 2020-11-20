package models;

public abstract class PseudoRandom {

	public int minLimit;
	public int maxLimit;
	public int Xn;
	
	public double calculateNI(int Ri) {
		return minLimit + (maxLimit - minLimit) * Ri;
	}
}