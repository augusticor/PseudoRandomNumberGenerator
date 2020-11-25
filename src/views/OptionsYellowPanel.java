package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import constants.MyConstants;
import controller.ActionsE;
import views.components.OwnJButton;
import views.components.OwnJLabel;

public class OptionsYellowPanel extends JPanel {

	public OptionsYellowPanel(ActionListener actionListener) {
		setBackground(Color.decode(MyConstants.CLR_YELLOW_PANEL));
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		GridBagConstraints c = new GridBagConstraints();
		createGrid(c);

		c.gridy = 0;
		c.weighty = 0.076923;
		c.gridx = 0;
		c.gridwidth = 12;
		add(new OwnJLabel(MyConstants.LBL_TITLE), c);

		c.gridy = 1;
		c.weighty = 0.0384615;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJLabel(" "), c);

		c.gridy = 2;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJButton(MyConstants.BTN_CUADRADOS_MED, ActionsE.CUADRADOS_MEDIOS, actionListener), c);

		c.gridy = 3;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJLabel(" "), c);

		c.gridy = 4;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJButton(MyConstants.BTN_CONGRUENCIA_L, ActionsE.CONGRUENCIA_LINEAL, actionListener), c);

		c.gridy = 5;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJLabel(" "), c);

		c.gridy = 6;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJButton(MyConstants.BTN_CONGRUENCIA_M, ActionsE.CONGRUENCIA_MULTIPLICATIVA, actionListener), c);

		c.gridy = 7;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJLabel(" "), c);

		c.gridy = 8;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJButton(MyConstants.BTN_DISTRO_UNIFOR, ActionsE.DISTRO_UNIFORME, actionListener), c);

		c.gridy = 9;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJLabel(" "), c);

		c.gridy = 10;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJButton(MyConstants.BTN_DISTRO_NORMAL, ActionsE.DISTRO_NORMAL_EST, actionListener), c);

		c.gridy = 11;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJLabel(" "), c);

		c.gridy = 12;
		c.weighty = 0.076923;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJButton(MyConstants.BTN_ACERCA_DE, ActionsE.ABOUT, actionListener), c);

		c.gridy = 13;
		c.weighty = 0.0384615;
		c.gridx = 4;
		c.gridwidth = 1;
		add(new OwnJLabel(" "), c);
	}

	/**
	 * Creates the grid for the GridBagLayout
	 * 
	 * @param c the layout columns
	 */
	public void createGrid(GridBagConstraints c) {
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridheight = 1;
		c.weighty = 0.01;

		for (int i = 0; i < 12; i++) {
			c.gridx = i;
			add(new JLabel(""), c);
		}
	}

	private static final long serialVersionUID = 1L;
}