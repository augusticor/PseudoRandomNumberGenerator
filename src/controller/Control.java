package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.MyConstants;
import models.*;
import views.PseudoRandomMainWindow;

public class Control implements ActionListener {

	private CongruenciaMultiplicativa congruenciaMultiplicativa;
	private CongruenciaLineal congruenciaLineal;
	private CuadradosMedios cuadradosMedios;

	private PseudoRandomMainWindow mainW;

	public Control() {
		congruenciaMultiplicativa = new CongruenciaMultiplicativa();
		congruenciaLineal = new CongruenciaLineal();
		cuadradosMedios = new CuadradosMedios();

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
			break;
		case DISTRO_UNIFORME:
			break;
		case ABOUT:
			break;
		case CALCULATE_CONGRUENCIA_MULTIPLICATIVA:
			calculateCongruenciaMultiplicativa();
			break;
		case CALCULATE_CONGRUENCIA_LINEAL:
			calculateCongruenciaLineal();
			break;
		case CALCULATE_CUADRADOS_MEDIOS:
			calculateCuadradosMedios();
		}
	}

	public void calculateCuadradosMedios() {
		Object[] data = mainW.getDataCuadradosMedios();
		cuadradosMedios.updateValues((int) data[1], (int) data[2], (int) data[0], (int) data[3]);
		cuadradosMedios.updateCuadrados();
		cuadradosMedios.generateNumbers();
		
		mainW.manageTableData(MyConstants.COLI_BASIC, cuadradosMedios.getDataForTables());
		mainW.showDialogCuadradosMedios(false);
	}

	public void calculateCongruenciaLineal() {
		Object[] data = mainW.getDataCongruenciaLineal();
		congruenciaLineal.updateValues((int) data[1], (int) data[2], (int) data[0], (int) data[3]);
		congruenciaLineal.updateCongruencia((int)data[4], (int)data[5], (int)data[6]);
		congruenciaLineal.algorithm((boolean) data[7]);
		
		mainW.manageTableData(MyConstants.COLI_BASIC, congruenciaLineal.getDataForTables());
		mainW.showDialogCongruenciaLineal(false);
		
	}

	public void calculateCongruenciaMultiplicativa() {
		Object[] data = mainW.getDataCongruenciaMultiplicativa();
		congruenciaMultiplicativa.updateValues((int) data[1], (int) data[2], (int) data[0], (int) data[3]);
		congruenciaMultiplicativa.updateData((int) data[4], (int) data[5]);
		congruenciaMultiplicativa.algorithm((boolean) data[6]);

		mainW.manageTableData(MyConstants.COLI_BASIC, congruenciaMultiplicativa.getDataForTables());
		mainW.showDialogCongruenciaMultiplicativa(false);
	}
}