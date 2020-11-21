package models;

public class CuadradosMedios extends PseudoRandom {

	private int Xi;
	private int seedAux;

	public void updateCuadrados() {
		Xi = super.seed;
		seedAux = Xi;
	}

	public void generateNumbers(int n) {
		int seedSize = Integer.toString(Xi).length();
		double divisionNumber = Math.pow(10, seedSize);
		double Ri = 0;
		super.clearDatForTables();
		
		for (int i = 0; i < n; i++) {
			algorithm();
			Ri = (double) seedAux / divisionNumber;
			super.addDataForTable(i + 1, seedAux, Ri, super.calculateNI(Ri));
		}
	}

	private void algorithm() {
		int auxInt;
		String auxString;
		auxInt = (int) Math.pow(seedAux, 2);
		auxString = Integer.toString(auxInt);
		int sizek = Integer.toString(Xi).length();
		auxString = addZero(auxString);
		String k1 = auxString.substring((auxString.length() / 2) - (sizek / 2), auxString.length() / 2);
		String k2 = auxString.substring(auxString.length() / 2, (auxString.length() / 2) + (sizek / 2));

		auxString = k1 + k2;
		auxInt = Integer.parseInt(auxString);
		seedAux = auxInt;
	}

	public String addZero(String auxString) {
		while (auxString.length() < 2 * (Integer.toString(Xi).length())) {
			auxString = 0 + auxString;
		}
		return auxString;
	}

	public static void main(String[] args) {
		CuadradosMedios cuadradosMedios = new CuadradosMedios();

		cuadradosMedios.updateValues(8, 10, 1234, 10);
		cuadradosMedios.updateCuadrados();

		cuadradosMedios.generateNumbers(cuadradosMedios.numbersToGenerate);

		for (int i = 0; i < cuadradosMedios.dataForTables.size(); i++) {
			System.out.println(cuadradosMedios.dataForTables.get(i));
		}
	}

}