package views;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

import controller.ActionsE;
import views.components.OwnJButton;
import views.components.OwnJSpinner;

public class JDNormalEstandar extends JDialog {

	private OwnJSpinner spMinLimit;
	private OwnJSpinner spMaxLimit;
	private OwnJSpinner spNumToGenerate;
	private OwnJButton btnDistroUniforme;
	
	public JDNormalEstandar(JFrame pseudoRandomMainWindow, ActionListener actionListener) {
		super(pseudoRandomMainWindow);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setModal(true);
		setSize(300, 280);
		setTitle("Datos para distribucion Normal estándar");
		setLocationRelativeTo(pseudoRandomMainWindow);

		spMinLimit = new OwnJSpinner("Ingrese el valor mínimo");
		add(spMinLimit);

		spMaxLimit = new OwnJSpinner("Ingrese el valor máximo");
		add(spMaxLimit);

		spNumToGenerate = new OwnJSpinner("Cantidad de numeros a generar");
		add(spNumToGenerate);

		btnDistroUniforme = new OwnJButton("Generar números", ActionsE.CALCULATE_DISTRO_NORMAL, actionListener);
		btnDistroUniforme.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(btnDistroUniforme);
	}
	
	public Object[] getDistroNormalData() {
		return new Object[] {
				spMinLimit.getValue(),
				spMaxLimit.getValue(),
				spNumToGenerate.getValue()
		};
	}
	
	private static final long serialVersionUID = 1L;
}