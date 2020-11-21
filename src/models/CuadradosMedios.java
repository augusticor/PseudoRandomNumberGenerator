package models;

public class CuadradosMedios extends PseudoRandom {

	private int seed = 9929;
	private int seedAux = seed;

	public double generateRi(int n) {

		int auxInt = 0;

		for (int i = 0; i < n; i++) {
			auxInt = algorithm();
		}
		return auxInt;
	}

	private int algorithm() {
		int auxInt;
		String auxString;
		auxInt = (int) Math.pow(seedAux, 2);
		auxString = Integer.toString(auxInt);
		int sizek = Integer.toString(seed).length();
		auxString = addZero(auxString);
		String k1 = auxString.substring((auxString.length() / 2) - (sizek / 2), auxString.length() / 2);
		String k2 = auxString.substring(auxString.length() / 2, (auxString.length() / 2) + (sizek / 2));

		auxString = k1 + k2;
		auxInt = Integer.parseInt(auxString);
		System.out.println(auxInt);
		seedAux = auxInt;
		return auxInt;
	}

	public String addZero(String auxString) {
		while (auxString.length() < 2 * (Integer.toString(seed).length())) {
			auxString = 0 + auxString;
		}
		return auxString;
	}

	public static void main(String[] args) {
		CuadradosMedios cuadradosMedios = new CuadradosMedios();
		cuadradosMedios.generateRi(5);
	}

}