package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import constants.MyConstants;
import models.DataForTable;
import views.components.OwnJTable;

public class PseudoRandomMainWindow extends JFrame {

	private OwnJTable ownJTable;
	private JDCuadradosMedios jdCuadradosMedios;
	private JDCongruenciaLineal jdCongruenciaLineal;
	private JDCongruenciaMultiplicativa jdCongruenciaMultiplicativa;
	private JDDistribucionUniforme jdDistribucionUniforme;
	private JDNormalEstandar jdNormalEstandar;
	private AboutDialog jdAboutDialog;

	public PseudoRandomMainWindow(ActionListener actionListener) {
		getContentPane().setBackground(Color.WHITE);
		setTitle(MyConstants.APP_TITLE);
		setIconImage(createImageIcon(MyConstants.MAIN_ICON).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		setMinimumSize(new Dimension(950, 550));

		GridBagConstraints c = new GridBagConstraints();
		createGrid(c);

		c.gridy = 0;
		c.weighty = 1;
		c.gridx = 0;
		c.gridwidth = 1;
		add(new OptionsYellowPanel(actionListener), c);

		c.gridy = 0;
		c.weighty = 1;
		c.gridx = 1;
		c.gridwidth = 11;
		ownJTable = new OwnJTable();
		add(new JScrollPane(ownJTable), c);

		jdCuadradosMedios = new JDCuadradosMedios(this, actionListener);
		jdCongruenciaLineal = new JDCongruenciaLineal(this, actionListener);
		jdCongruenciaMultiplicativa = new JDCongruenciaMultiplicativa(this, actionListener);
		jdDistribucionUniforme = new JDDistribucionUniforme(this, actionListener);
		jdNormalEstandar = new JDNormalEstandar(this, actionListener);
		jdAboutDialog = new AboutDialog(this);

		setVisible(true);
	}

	/**
	 * Creates the grid for the GridBagLayout
	 * 
	 * @param c the layout columns
	 */
	private void createGrid(GridBagConstraints c) {
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridheight = 1;
		c.weighty = 0.01;

		for (int i = 0; i < 12; i++) {
			c.gridx = i;
			add(new JLabel(""), c);
		}
	}

	/**
	 * Displays a message in a JOptionPane object
	 * 
	 * @param errorMessage to show to the user
	 */
	public void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage, "� ERROR !", JOptionPane.ERROR_MESSAGE);
	}

	public void manageTableData(String[] columnIdentifiers, ArrayList<DataForTable> dataForTable) {
		ownJTable.manageTableData(columnIdentifiers, dataForTable);
	}

	public void showDialogCuadradosMedios(boolean show) {
		jdCuadradosMedios.setVisible(show);
	}

	public void showDialogCongruenciaLineal(boolean show) {
		jdCongruenciaLineal.setVisible(show);
	}

	public void showDialogCongruenciaMultiplicativa(boolean show) {
		jdCongruenciaMultiplicativa.setVisible(show);
	}

	public void showDialogDistribucionUniforme(boolean show) {
		jdDistribucionUniforme.setVisible(show);
	}

	public void showDialogDistribucioNormalEst(boolean show) {
		jdNormalEstandar.setVisible(show);
	}
	
	public void showAboutDialog() {
		jdAboutDialog.setVisible(true);
	}

	public Object[] getDataCongruenciaMultiplicativa() {
		return jdCongruenciaMultiplicativa.congruenciaMultiplicativaInfo();
	}

	public Object[] getDataCongruenciaLineal() {
		return jdCongruenciaLineal.congruenciaLinealInfo();
	}

	public Object[] getDataCuadradosMedios() {
		return jdCuadradosMedios.cuadradosMediosInfo();
	}

	public Object[] getDataDistribucionUniforme() {
		return jdDistribucionUniforme.getDistroUniformeData();
	}

	public Object[] getDataDistribucionNormal() {
		return jdNormalEstandar.getDistroNormalData();
	}

	private ImageIcon createImageIcon(String path) {
		return new ImageIcon(getClass().getResource(path));
	}

	private static final long serialVersionUID = 1L;
}