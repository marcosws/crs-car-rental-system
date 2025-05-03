package com.github.marcosws.crs.view.utils.custon;

import java.util.EventObject;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRSGridView {
	
	
	protected JTable table;
	protected DefaultTableModel tableModel;
	protected JScrollPane scrollPane;
	
	public JTable getTable() {
		return table;
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public CRSGridView() {
		
		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		scrollPane = new JScrollPane(table) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("unused")
			public boolean editCellAt(int row, int column, EventObject e) {
				return false;
			}
		};
		scrollPane = new JScrollPane(table);
		
	}
	
	public void clearGrid() {
		int rows = tableModel.getRowCount();
		for (int i = rows - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
	
	
	
	

}
