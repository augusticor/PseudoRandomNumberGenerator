package views.components;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import constants.MyConstants;
import models.PseudoRandom;

public class OwnJTable extends JTable {

	private DefaultTableModel dtmElements;

	public OwnJTable() {
		dtmElements = new DefaultTableModel();
		dtmElements.setColumnIdentifiers(MyConstants.COLI_BASIC);
		setModel(dtmElements);

		getTableHeader().setReorderingAllowed(false);
		getTableHeader().setResizingAllowed(false);
		getTableHeader().setBackground(Color.WHITE);
		getTableHeader().setForeground(Color.BLACK);
		getTableHeader().setFont(new Font(MyConstants.FONT_ARIAL, 1, 20));
		setFont(new Font(MyConstants.FONT_ARIAL, 0, 16));
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
	}

	public void manageTableData(Vector<?> columnIdentifiers, ArrayList<PseudoRandom> callList) {
		dtmElements.setColumnIdentifiers(columnIdentifiers);
		dtmElements.setRowCount(0);
//		for (Person call : callList) {
//			dtmElements.addRow(call.valuesForTable());
//		}
	}

	private static final long serialVersionUID = 1L;
}