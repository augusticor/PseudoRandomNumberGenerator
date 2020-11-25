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


public class JDCuadradosMedios extends JDialog{

	private static final long serialVersionUID = 1L;
	private JSpinner spSeed;
	private JSpinner spMin;
	private JSpinner spMax;
	private JSpinner spNumToGenerate;
	private JButton button;
	

	public JDCuadradosMedios(PseudoRandomMainWindow pseudoRandomMainWindow) {
		
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
		add(spNumToGenerate );
		
		button = new JButton("Calcular");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setForeground(Color.decode(MyConstants.CLR_WHITE));
		button.setBackground(Color.decode(MyConstants.CLR_BLUE_BTNS));
		button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		button.setFont(new Font(MyConstants.FONT_ROBOTO, 1, 15));
		add(button);
		
//		setVisible(true);
	}
	

	
}
