package com.github.marcosws.crs.view.mdi.chid.register.vehicle;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.marcosws.crs.view.mdi.chid.ControlChild;
import com.github.marcosws.crs.view.utils.CRSDimension;
import com.github.marcosws.crs.view.utils.custon.CRSGridView;

public class AutomakerView extends ControlChild {
	
	
	private JTextField editAutomakerId;
	private JTextField editAutomakerName;
	private CRSGridView gridAutomaker;
	

	public AutomakerView() {
		
		super("Montadora","Cadastro de Montadora");
		
		editAutomakerId = new JTextField();
		JLabel labelAutomakerId = new JLabel("ID");
		labelAutomakerId.setBounds(10, 180, 2000, 20);
		editAutomakerId.setBounds(10, 200, 200, 20);
		editAutomakerId.setEditable(false);
		
		editAutomakerName = new JTextField();
		JLabel labelAutomakerName = new JLabel("Nome");
		labelAutomakerName.setBounds(10, 220, 200, 20);
		editAutomakerName.setBounds(10, 240, 200, 20);
		
		JLabel labelAutomakerGrid = new JLabel("Montadoras Cadastradas");
		labelAutomakerGrid.setBounds(10, 280, 200, 20);
		gridAutomaker = new CRSGridView();
		gridAutomaker.getTableModel().addColumn("ID");
		gridAutomaker.getTableModel().addColumn("Nome");
		gridAutomaker.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = gridAutomaker.getTable().getSelectedRow();
				if (row != -1) {
					editAutomakerId.setText(gridAutomaker.getTableModel().getValueAt(row, 0).toString());
					editAutomakerName.setText(gridAutomaker.getTableModel().getValueAt(row, 1).toString());
				}
			}
		});
		gridAutomaker.getScrollPane().setBounds(10, 300, 600, 200);
		
		panel.add(labelAutomakerId);
		panel.add(editAutomakerId);
		panel.add(labelAutomakerName);
		panel.add(editAutomakerName);
		panel.add(labelAutomakerGrid);
		panel.add(gridAutomaker.getScrollPane());
		
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setBounds(0, 0, CRSDimension.getWidth(), CRSDimension.getHeight());
		frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableDisableFields() {
		// TODO Auto-generated method stub
		
	}

}
