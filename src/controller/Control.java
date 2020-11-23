package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.PseudoRandomMainWindow;

public class Control  implements ActionListener{
	
	private PseudoRandomMainWindow mainWindows;

	public Control() {
		
		mainWindows = new PseudoRandomMainWindow(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (ActionsE.valueOf(e.getActionCommand())) {
		case EXIT:
			System.exit(0);
			break;
		case CUADRADOS_MEDIOS:
			mainWindows.showDialogCuadradosMedios();
			System.out.println("Cuadrados medios");
			break;
		case ABOUT:
			break;
		case CONGRUENCIA_LINEAL:
			mainWindows.showDialogCongruenciaLineal();
			break;
		case CONGRUENCIA_MULTIPLICATIVA:
			mainWindows.showDialogCongruenciaMiltiplicativa();
			break;
		case DISTRO_NORMAL_EST:
			break;
		case DISTRO_UNIFORME:
			break;
		default:
			break;
		}
	}

}
