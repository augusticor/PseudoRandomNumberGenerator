package models;

import java.util.Random;

public class UniformDistribution extends PseudoRandom {

	private Random random;

	public UniformDistribution() {
		random = new Random();
	}

	public void algorithm() {
		super.clearDatForTables();
		double Ri = 0;
		for (int i = 0; i < super.numbersToGenerate; i++) {
			Ri = random.nextDouble();
			super.addDataForTable(i + 1, 0, Ri, super.calculateNI(Ri));
		}
	}

	public static void main(String[] args) {
		UniformDistribution uniformDistribution = new UniformDistribution();

		uniformDistribution.updateValues(1, 50, 0, 20);
		uniformDistribution.algorithm();
		
		for (int i = 0; i < uniformDistribution.dataForTables.size(); i++) {
			System.out.println(uniformDistribution.dataForTables.get(i));
		}
	}
}