package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import constants.MyConstants;
import models.*;
import views.PseudoRandomMainWindow;

public class Control implements ActionListener {

	private CongruenciaMultiplicativa congruenciaMultiplicativa;

	private PseudoRandomMainWindow mainW;

	public Control() {
		congruenciaMultiplicativa = new CongruenciaMultiplicativa();

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
		}
	}

	public void calculateCuadradosMedios() {
	}

	public void calculateCongruenciaLineal() {
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