package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import constants.MyConstants;
import views.components.OwnJTable;

public class PseudoRandomMainWindow extends JFrame {

	private OwnJTable ownJTable;

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
		JOptionPane.showMessageDialog(this, errorMessage, "¡ ERROR !", JOptionPane.ERROR_MESSAGE);
	}

	private ImageIcon createImageIcon(String path) {
		return new ImageIcon(getClass().getResource(path));
	}

	private static final long serialVersionUID = 1L;
}