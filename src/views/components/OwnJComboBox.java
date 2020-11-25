package views.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

import constants.MyConstants;

public class OwnJComboBox extends JComboBox<String> {

	public OwnJComboBox() {
		setBorder(BorderFactory.createTitledBorder("¿ Conjunto cerrado o abierto ?"));
		setBackground(Color.WHITE);
		setFont(new Font(MyConstants.FONT_ARIAL, 2, 13));
		addItem("Xi / m-1");
		addItem("Xi / m");
	}

	private static final long serialVersionUID = 1L;
}