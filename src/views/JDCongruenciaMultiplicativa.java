package views;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;

public class JDCongruenciaMultiplicativa extends JDialog{

	private static final long serialVersionUID = 1L;

	private JSpinner spSeed;
	private JSpinner spMin;
	private JSpinner spMax;
	private JSpinner spNumToGenerate;
	private JSpinner spT;
	private JSpinner spG;
	private JButton button;
	
	public JDCongruenciaMultiplicativa(PseudoRandomMainWindow pseudoRandomMainWindow) {
		
		setModal(true);
		setSize(500, 500);
		setTitle("datos para cuadrados medios");
		setLocationRelativeTo(pseudoRandomMainWindow);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		spSeed = new JSpinner();
		spSeed.setBorder(BorderFactory.createTitledBorder("ingrese el valor de la semilla"));
		add(spSeed);
		
		spMin = new JSpinner();
		spMin.setBorder(BorderFactory.createTitledBorder("ingrese el valor minimo"));
		add(spMin);
		
		spMax = new JSpinner();
		spMax.setBorder(BorderFactory.createTitledBorder("ingrese el valor maximo"));
		add(spMax);
		
		spNumToGenerate = new JSpinner();
		spNumToGenerate.setBorder(BorderFactory.createTitledBorder("ingrese el numero de numeros a generar"));
		add(spNumToGenerate );
		
		spT = new JSpinner();
		spT.setBorder(BorderFactory.createTitledBorder("ingrese el valor de T"));
		add(spT );
		
		
		spG = new JSpinner();
		spG.setBorder(BorderFactory.createTitledBorder("ingrese el valor de G"));
		add(spG );
		
		
		button = new JButton("Calcular");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setBackground(Color.GREEN);
		add(button);
		
		setVisible(true);
	}
}
