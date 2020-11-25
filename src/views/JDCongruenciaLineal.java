package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSpinner;

import constants.MyConstants;
import views.components.OwnJComboBox;

public class JDCongruenciaLineal extends JDialog{

	private static final long serialVersionUID = 1L;

	private JSpinner spSeed;
	private JSpinner spMin;
	private JSpinner spMax;
	private JSpinner spNumToGenerate;
	private JSpinner spC;
	private JSpinner spA;
	private JSpinner spG;
	private OwnJComboBox coboxIsClosed;
	private JButton button;
	
	public JDCongruenciaLineal(PseudoRandomMainWindow pseudoRandomMainWindow) {
		
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
		
		spC = new JSpinner();
		spC.setBorder(BorderFactory.createTitledBorder("Ingrese el valor de C"));
		add(spC );
		
		spA = new JSpinner();
		spA.setBorder(BorderFactory.createTitledBorder("Ingrese el valor de A"));
		add(spA );
		
		spG = new JSpinner();
		spG.setBorder(BorderFactory.createTitledBorder("Ingrese el valor de G"));
		add(spG );
		
		coboxIsClosed = new OwnJComboBox();
		add(coboxIsClosed);
		
		button = new JButton("Calcular");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setForeground(Color.decode(MyConstants.CLR_WHITE));
		button.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		button.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 15));
		add(button);
		
	}
}
