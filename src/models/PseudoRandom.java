package models;

import java.util.ArrayList;

public abstract class PseudoRandom {

	public int minLimit;
	public int maxLimit;
	public int seed;
	public int numbersToGenerate;

	public ArrayList<DataForTable> dataForTables;

	public PseudoRandom() {
		dataForTables = new ArrayList<DataForTable>();
	}

	public void updateValues(int minLimit, int maxLimit, int seed, int numbersToGenerate) {
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.seed = seed;
		this.numbersToGenerate = numbersToGenerate;
	}

	public double calculateNI(double ri) {
		return minLimit + (maxLimit - minLimit) * ri;
	}

	public void clearDatForTables() {
		this.dataForTables.clear();
	}

	public void addDataForTable(int i, int xn, double ri, double d) {
		this.dataForTables.add(new DataForTable(i, xn, ri, d));
	}

	public ArrayList<DataForTable> getDataForTables() {
		return dataForTables;
	}

	public ArrayList<DataForTable> createACopyOfThisArray() {
		return new ArrayList<DataForTable>(this.dataForTables);
	}
}