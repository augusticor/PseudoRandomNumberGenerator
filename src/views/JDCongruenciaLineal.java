package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;

import controller.ActionsE;
import views.components.OwnJButton;
import views.components.OwnJComboBox;

public class JDCongruenciaLineal extends JDialog{

	private static final long serialVersionUID = 1L;

	private JSpinner spSeed;
	private JSpinner spMin;
	private JSpinner spMax;
	private JSpinner spNumToGenerate;
	private JSpinner spk;
	private JSpinner spC;
	private JSpinner spG;
	private OwnJComboBox coboxIsClosed;
	private JButton button;
	
	public JDCongruenciaLineal(PseudoRandomMainWindow pseudoRandomMainWindow, ActionListener listener) {
		
		setModal(true);
		setSize(300, 450);
		setTitle("datos para Congruencia lineal");
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
		add(spNumToGenerate );
		
		spk = new JSpinner();
		spk.setBorder(BorderFactory.createTitledBorder("Ingrese el valor de K"));
		add(spk );
		
		spC = new JSpinner();
		spC.setBorder(BorderFactory.createTitledBorder("Ingrese el valor de C"));
		add(spC );
		
		spG = new JSpinner();
		spG.setBorder(BorderFactory.createTitledBorder("Ingrese el valor de G"));
		add(spG );
		
		coboxIsClosed = new OwnJComboBox();
		add(coboxIsClosed);
		
		button = new OwnJButton(" Generar ",ActionsE.CALCULATE_CONGRUENCIA_LINEAL,listener);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button);
		
	
	}
	
	public Object[] congruenciaLinealInfo() {
		return new Object[] {
				(Integer) spSeed.getValue(),
				(Integer) spMin.getValue(),
				(Integer) spMax.getValue(),
				(Integer) spNumToGenerate.getValue(),
				(Integer) spk.getValue(),
				(Integer) spC.getValue(),
				(Integer) spG.getValue(),
				coboxIsClosed.getSelectedIndex() == 0 ? true : false
		};
	}
}
