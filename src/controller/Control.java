package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.JDCongruenciaLineal;
import views.JDCongruenciaMultiplicativa;
import views.JDCuadradosMedios;
import views.PseudoRandomMainWindow;

public class Control implements ActionListener {

	private PseudoRandomMainWindow mainWindows;
	private JDCuadradosMedios jdCuadradosMedios;
	private JDCongruenciaLineal jdCongruenciaLineal;
	private JDCongruenciaMultiplicativa jdCongruenciaMultiplicativa;

	public Control() {

		mainWindows = new PseudoRandomMainWindow(this);

		jdCuadradosMedios = new JDCuadradosMedios(mainWindows);
		jdCongruenciaLineal = new JDCongruenciaLineal(mainWindows);
		jdCongruenciaMultiplicativa = new JDCongruenciaMultiplicativa(mainWindows);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (ActionsE.valueOf(e.getActionCommand())) {
		case CUADRADOS_MEDIOS:
			showDialogCuadradosMedios();
			break;
		case CONGRUENCIA_LINEAL:
			showDialogCongruenciaLineal();
			break;
		case CONGRUENCIA_MULTIPLICATIVA:
			showDialogCongruenciaMiltiplicativa();
			break;
		case DISTRO_NORMAL_EST:
			break;
		case DISTRO_UNIFORME:
			break;
		case ABOUT:
			break;
		default:
			break;
		}
	}

	public void showDialogCuadradosMedios() {
		jdCuadradosMedios.setVisible(true);
	}

	public void showDialogCongruenciaLineal() {
		jdCongruenciaLineal.setVisible(true);
	}

	public void showDialogCongruenciaMiltiplicativa() {
		jdCongruenciaMultiplicativa.setVisible(true);
	}

}
