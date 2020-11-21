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

	public static void main(String[] args) {
		NormalEstandar normalEstandar = new NormalEstandar();

		normalEstandar.updateValues(2, 8, 0, 10);

		normalEstandar.algorithm();

		for (int i = 0; i < normalEstandar.dataForTables.size(); i++) {
			System.out.println(normalEstandar.dataForTables.get(i));
		}

		System.out.println("Mayor valor generado : " + normalEstandar.getMaxValue());
		System.out.println("Menor valor generado : " + normalEstandar.getMinValue());
	}
}