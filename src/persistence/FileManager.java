package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import models.DataForTable;

/**
 * Escribe un archivo por cada vez que se generan numeros pseudoaleatorios
 * usando alguno de los metodos
 */
public class FileManager {

	public static DecimalFormat FORMAT = new DecimalFormat("#.#####");

	/**
	 * Escribe un archivo con extension .txt
	 * 
	 * @param fileName     el nombre que tendra el archivo, sera guardado en el
	 *                     escritorio del usuario
	 * @param dataForTable la informacion de los numeros pseudoaleatorios, se
	 *                     extraera Ri
	 * @throws IOException excepcion de escritura de archivos
	 */
	public void writeFile(String fileName, ArrayList<DataForTable> dataForTable) throws IOException {
		ArrayList<DataForTable> auxArray = new ArrayList<DataForTable>(dataForTable);
		File file = new File(System.getProperty("user.home") + "/Desktop/" + fileName);

		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		for (int i = 0; i < auxArray.size(); i++) {
			bufferedWriter.write(FORMAT.format(auxArray.get(i).getRi()));
			if (i < auxArray.size() - 1) {
				bufferedWriter.write("#");
			}
		}

		bufferedWriter.close();
		fileWriter.close();
	}

	public void writeFileNormalDistro(String fileName, ArrayList<DataForTable> dataForTable) throws IOException {
		ArrayList<DataForTable> auxArray = new ArrayList<DataForTable>(dataForTable);
		File file = new File(System.getProperty("user.home") + "/Desktop/" + fileName);

		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		for (int i = 0; i < auxArray.size(); i++) {
			bufferedWriter.write(FORMAT.format(auxArray.get(i).getNi()));
			if (i < auxArray.size() - 1) {
				bufferedWriter.write("#");
			}
		}

		bufferedWriter.close();
		fileWriter.close();
	}
}