package models;

public class CongruenciaMultiplicativa extends PseudoRandom {

	private int Xi;
	private int a;
	private int m;

	public void updateData(int t, int g) {
		Xi = super.seed;
		a = (8 * t) + 3;
		m = (int) Math.pow(2, g);
	}

	/**
	 * metodo principal del algoritmo
	 * 
	 * @param isClosed define si el intervalo es abierto o cerrado
	 */
	public void algorithm(boolean isClosed) {
		super.clearDatForTables();
		double Ri = 0;

		for (int i = 0; i < super.numbersToGenerate; i++) {
			Xi = (a * Xi) % m;
			Ri = (double) calculateRi(isClosed);
			super.addDataForTable(i + 1, Xi, Ri, super.calculateNI(Ri));
		}
	}

	/**
	 * metodo que calcula el Ri
	 * 
	 * @param isClosed define si el intervalo es abierto o cerrado
	 * @return el valor de Ri
	 */
	public double calculateRi(boolean isClosed) {
		if (isClosed) {
			return (double) Xi / (m - 1);
		}
		return (double) Xi / m;
	}

}