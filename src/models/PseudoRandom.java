package models;

public abstract class PseudoRandom {

	public int minLimit;
	public int maxLimit;
	public int seed;
	public int numbersToGenerate;

	public void updateValues(int minLimit, int maxLimit, int seed, int numbersToGenerate) {
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.seed = seed;
		this.numbersToGenerate = numbersToGenerate;
	}

	public double calculateNI(int Ri) {
		return minLimit + (maxLimit - minLimit) * Ri;
	}
}