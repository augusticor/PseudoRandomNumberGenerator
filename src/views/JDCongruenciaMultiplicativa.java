package views;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JDialog;

import controller.ActionsE;
import views.components.OwnJButton;
import views.components.OwnJComboBox;
import views.components.OwnJSpinner;

public class JDCongruenciaMultiplicativa extends JDialog {

	private static final long serialVersionUID = 1L;

	private OwnJSpinner spSeed;
	private OwnJSpinner spMin;
	private OwnJSpinner spMax;
	private OwnJSpinner spNumToGenerate;
	private OwnJSpinner spT;
	private OwnJSpinner spG;
	private OwnJComboBox coboxIsClosed;
	private OwnJButton btnCongruenciaM;

	public JDCongruenciaMultiplicativa(PseudoRandomMainWindow pseudoRandomMainWindow, ActionListener actionListener) {
		super(pseudoRandomMainWindow);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setModal(true);
		setSize(320, 600);
		setTitle("Datos para cuadrados medios");

		spSeed = new OwnJSpinner("Ingrese el valor de la semilla");
		add(spSeed);

		spMin = new OwnJSpinner("Ingrese el valor minimo");
		add(spMin);

		spMax = new OwnJSpinner("Ingrese el valor maximo");
		add(spMax);

		spNumToGenerate = new OwnJSpinner("Cantidad de numeros a generar");
		add(spNumToGenerate);

		spT = new OwnJSpinner("Ingrese el valor de T");
		add(spT);

		spG = new OwnJSpinner("Ingrese el valor de G");
		add(spG);
		
		coboxIsClosed = new OwnJComboBox();
		add(coboxIsClosed);

		btnCongruenciaM = new OwnJButton("  Calcular  ", ActionsE.CALCULATE_CONGRUENCIA_MULTIPLICATIVA, actionListener);
		btnCongruenciaM.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnCongruenciaM);
	}

	public Object[] congruenciaMultiplicativaInfo() {
		return new Object[] {
				(Integer) spSeed.getValue(),
				(Integer) spMin.getValue(),
				(Integer) spMax.getValue(),
				(Integer) spNumToGenerate.getValue(),
				(Integer) spT.getValue(),
				(Integer) spG.getValue(),
				coboxIsClosed.getSelectedIndex() == 0 ? true : false
				};
	}
}