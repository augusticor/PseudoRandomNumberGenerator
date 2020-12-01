package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import constants.MyConstants;
import models.*;
import persistence.FileManager;
import views.PseudoRandomMainWindow;

public class Control implements ActionListener {

	private CongruenciaMultiplicativa congruenciaMultiplicativa;
	private CongruenciaLineal congruenciaLineal;
	private CuadradosMedios cuadradosMedios;
	private UniformDistribution distributionUniforme;
	private NormalEstandar normalEstandar;

	private FileManager fileManager;

	private PseudoRandomMainWindow mainW;

	public Control() {
		congruenciaMultiplicativa = new CongruenciaMultiplicativa();
		congruenciaLineal = new CongruenciaLineal();
		cuadradosMedios = new CuadradosMedios();
		distributionUniforme = new UniformDistribution();
		normalEstandar = new NormalEstandar();

		fileManager = new FileManager();

		mainW = new PseudoRandomMainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ActionsE.valueOf(e.getActionCommand())) {
		case CUADRADOS_MEDIOS:
			mainW.showDialogCuadradosMedios(true);
			break;
		case CONGRUENCIA_LINEAL:
			mainW.showDialogCongruenciaLineal(true);
			break;
		case CONGRUENCIA_MULTIPLICATIVA:
			mainW.showDialogCongruenciaMultiplicativa(true);
			break;
		case DISTRO_NORMAL_EST:
			mainW.showDialogDistribucioNormalEst(true);
			break;
		case DISTRO_UNIFORME:
			mainW.showDialogDistribucionUniforme(true);
			break;
		case ABOUT:
			mainW.showAboutDialog();
			break;
		case CALCULATE_CONGRUENCIA_MULTIPLICATIVA:
			calculateCongruenciaMultiplicativa();
			break;
		case CALCULATE_CONGRUENCIA_LINEAL:
			calculateCongruenciaLineal();
			break;
		case CALCULATE_CUADRADOS_MEDIOS:
			calculateCuadradosMedios();
			break;
		case CALCULATE_DISTRO_UNIFORME:
			calculateDistroUniforme();
			break;
		case CALCULATE_DISTRO_NORMAL:
			calculateDistroNormalEstandar();
			break;
		}
	}

	private void calculateCuadradosMedios() {
		Object[] data = mainW.getDataCuadradosMedios();
		cuadradosMedios.updateValues((int) data[1], (int) data[2], (int) data[0], (int) data[3]);
		cuadradosMedios.updateCuadrados();
		cuadradosMedios.generateNumbers();

		ArrayList<DataForTable> auxData = cuadradosMedios.createACopyOfThisArray();

		mainW.manageTableData(MyConstants.COLI_BASIC, auxData);
		mainW.showDialogCuadradosMedios(false);

		try {
			fileManager.writeFile("cuadradosmedios.txt", auxData);
		} catch (IOException e) {
			mainW.showErrorMessage("Error al escribir el archivo cuadradosmedios en Desktop");
			mainW.showErrorMessage(e.getMessage());
		}
	}

	private void calculateCongruenciaLineal() {
		Object[] data = mainW.getDataCongruenciaLineal();
		congruenciaLineal.updateValues((int) data[1], (int) data[2], (int) data[0], (int) data[3]);
		congruenciaLineal.updateCongruencia((int) data[4], (int) data[5], (int) data[6]);
		congruenciaLineal.algorithm((boolean) data[7]);

		ArrayList<DataForTable> auxData = congruenciaLineal.createACopyOfThisArray();

		mainW.manageTableData(MyConstants.COLI_BASIC, congruenciaLineal.getDataForTables());
		mainW.showDialogCongruenciaLineal(false);

		try {
			fileManager.writeFile("congruencialineal.txt", auxData);
		} catch (IOException e) {
			mainW.showErrorMessage("Error al escribir el archivo congruencialineal en Desktop");
			mainW.showErrorMessage(e.getMessage());
		}
	}

	private void calculateCongruenciaMultiplicativa() {
		Object[] data = mainW.getDataCongruenciaMultiplicativa();
		congruenciaMultiplicativa.updateValues((int) data[1], (int) data[2], (int) data[0], (int) data[3]);
		congruenciaMultiplicativa.updateData((int) data[4], (int) data[5]);
		congruenciaMultiplicativa.algorithm((boolean) data[6]);

		ArrayList<DataForTable> auxData = congruenciaMultiplicativa.createACopyOfThisArray();

		mainW.manageTableData(MyConstants.COLI_BASIC, congruenciaMultiplicativa.getDataForTables());
		mainW.showDialogCongruenciaMultiplicativa(false);

		try {
			fileManager.writeFile("congruenciamultiplicativa.txt", auxData);
		} catch (IOException e) {
			mainW.showErrorMessage("Error al escribir el archivo congruenciamultiplicativa en Desktop");
			mainW.showErrorMessage(e.getMessage());
		}
	}

	private void calculateDistroUniforme() {
		Object[] data = mainW.getDataDistribucionUniforme();
		distributionUniforme.updateValues((int) data[0], (int) data[1], 0, (int) data[2]);
		distributionUniforme.algorithm();

		ArrayList<DataForTable> auxData = distributionUniforme.createACopyOfThisArray();

		mainW.manageTableData(MyConstants.COLI_BASIC, distributionUniforme.getDataForTables());
		mainW.showDialogDistribucionUniforme(false);

		try {
			fileManager.writeFile("distrouniforme.txt", auxData);
		} catch (IOException e) {
			mainW.showErrorMessage("Error al escribir el archivo distrouniforme en Desktop");
			mainW.showErrorMessage(e.getMessage());
		}
	}

	private void calculateDistroNormalEstandar() {
		Object[] data = mainW.getDataDistribucionNormal();
		normalEstandar.updateValues((int) data[0], (int) data[1], 0, (int) data[2]);
		normalEstandar.algorithm();

		ArrayList<DataForTable> auxData = normalEstandar.createACopyOfThisArray();

		mainW.manageTableData(MyConstants.COLI_BASIC, normalEstandar.getDataForTables());
		mainW.showDialogDistribucioNormalEst(false);

		try {
			fileManager.writeFile("distronormal.txt", auxData);
		} catch (IOException e) {
			mainW.showErrorMessage("Error al escribir el archivo distronormal en Desktop");
			mainW.showErrorMessage(e.getMessage());
		}
	}
}