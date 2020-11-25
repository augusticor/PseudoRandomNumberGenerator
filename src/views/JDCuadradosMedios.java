package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;

import constants.MyConstants;
import controller.ActionsE;
import views.components.OwnJButton;

public class JDCuadradosMedios extends JDialog {

	private static final long serialVersionUID = 1L;
	private JSpinner spSeed;
	private JSpinner spMin;
	private JSpinner spMax;
	private JSpinner spNumToGenerate;
	private JButton button;

	public JDCuadradosMedios(PseudoRandomMainWindow pseudoRandomMainWindow, ActionListener listener) {

		setModal(true);
		setSize(300, 400);
		setTitle("datos para cuadrados medios");
		setLocationRelativeTo(pseudoRandomMainWindow);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		spSeed = new JSpinner();
		spSeed.setBorder(BorderFactory.createTitledBorder("Ingrese el valor de la semilla"));
		add(spSeed);

		spMin = new JSpinner();
		spMin.setBorder(BorderFactory.createTitledBorder("Ingrese el valor minimo"));
		add(spMin);

		spMax = new JSpinner();
		spMax.setBorder(BorderFactory.createTitledBorder("Ingrese el valor maximo"));
		add(spMax);

		spNumToGenerate = new JSpinner();
		spNumToGenerate.setBorder(BorderFactory.createTitledBorder("Ingrese el numero de numeros a generar"));
		add(spNumToGenerate);

		button = new OwnJButton(" Generar ", ActionsE.CALCULATE_CUADRADOS_MEDIOS, listener);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button);

	}

	public Object[] cuadradosMediosInfo() {
		return new Object[] { 
				(Integer) spSeed.getValue(), 
				(Integer) spMin.getValue(), 
				(Integer) spMax.getValue(),
				(Integer) spNumToGenerate.getValue() 
			};

	}

}
 