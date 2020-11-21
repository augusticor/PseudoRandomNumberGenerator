package models;

public class CongruenciaLineal extends PseudoRandom {

	/* Semilla x0 */
	private int Xi;

	/* Interseccion de la recta */
	private int c;

	/* a */
	private int a;

	/* m */
	private int m;

	/**
	 * Actualiza los valores usados para congruencia lineal
	 * 
	 * @param k pendiente de la recta
	 * @param c interseccion de la recta
	 * @param g periodo de generación (se convertira en m)
	 */
	public void updateCongruencia(int k, int c, int g) {
		Xi = super.seed;
		this.c = c;

		a = 1 + (2 * k);
		m = (int) Math.pow(2, g);
	}

	public void algorithm() {
		super.clearDatForTables();
		
		for (int i = 0; i < super.numbersToGenerate; i++) {
			Xi = ((a * Xi) + c) % m;
			double Ri = generateRi(Xi, true);

			//System.out.println("Xi : " + Xi + "-- Ri : " + Ri);
			super.addDataForTable(i, Xi, Ri, super.calculateNI(Ri));
		}
	}

	/**
	 * Genera los numeros Ri
	 * 
	 * @param Xi          el numero pseudo aleatorio generado inicialmente para
	 *                    generar Ri
	 * @param isClosedSet si es conjunto cerrado aplica la formula (xi / m-1) si no
	 *                    aplica (xi / m)
	 * @return el numero Ri generado
	 */
	public double generateRi(int Xi, boolean isClosedSet) {
		double auxXi = (double) Xi;
		if (isClosedSet) {
			return (auxXi / (m - 1));
		}
		return (auxXi / m);
	}

	public static void main(String[] args) {
		CongruenciaLineal congruenciaLineal = new CongruenciaLineal();

		congruenciaLineal.updateValues(8, 10, 1, 10);
		congruenciaLineal.updateCongruencia(4, 3, 7);

		congruenciaLineal.algorithm();
		
		for (int i = 0; i < congruenciaLineal.dataForTables.size(); i++) {
			System.out.println(congruenciaLineal.dataForTables.get(i));
		}
	}
}