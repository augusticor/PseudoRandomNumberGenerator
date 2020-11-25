package models;

import java.util.Random;

public class NormalEstandar extends PseudoRandom {

	private Random normalRandom;

	public NormalEstandar() {
		normalRandom = new Random();
	}

	public void algorithm() {
		double Ni = 0;
		super.clearDatForTables();

		for (int i = 0; i < super.numbersToGenerate; i++) {
			Ni = normalRandom.nextGaussian();
			super.addDataForTable(i + 1, 0, 0, Ni);
		}
	}

	public double getMaxValue() {
		double maxValue = -30;
		double auxNi = 0;
		for (DataForTable dataForTable : dataForTables) {
			auxNi = dataForTable.getNi();
			if (auxNi > maxValue) {
				maxValue = auxNi;
			}
		}
		return maxValue;
	}

	public double getMinValue() {
		double minValue = 50;
		double auxNi = 0;
		for (DataForTable dataForTable : dataForTables) {
			auxNi = dataForTable.getNi();
			if (auxNi < minValue) {
				minValue = auxNi;
			}
		}
		return minValue;
	}

}