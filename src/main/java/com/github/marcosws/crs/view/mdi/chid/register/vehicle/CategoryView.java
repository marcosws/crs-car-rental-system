package com.github.marcosws.crs.view.mdi.chid.register.vehicle;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.marcosws.crs.view.mdi.chid.ControlChild;
import com.github.marcosws.crs.view.utils.CRSDimension;
import com.github.marcosws.crs.view.utils.custon.CRSGridView;

public class CategoryView extends ControlChild  {

	private JTextField editCategoryId;
	private JTextField editCategoryName;
	private CRSGridView gridCategory;
	
	
	public CategoryView() {
		
		super("Categoria","Cadastro  de Categoria de Veiculo");
		
		editCategoryId = new JTextField();
		JLabel labelCategoryId = new JLabel("ID");
		labelCategoryId.setBounds(10, 180, 200, 20);
		editCategoryId.setName("ID");
		editCategoryId.setEditable(false);
		editCategoryId.setBounds(10, 200, 200, 20);
		
		
		editCategoryName = new JTextField();
		JLabel labelCategoryName = new JLabel("Nome");
		labelCategoryName.setBounds(10, 220, 200, 20);
		editCategoryName.setName("Nome");
		editCategoryName.setBounds(10, 240, 200, 20);
		
		JTextField editCategoryGrid = new JTextField("Categorias Cadastradas");
		labelCategoryName.setBounds(10, 280, 200, 20);
		gridCategory = new CRSGridView();
		gridCategory.getTableModel().addColumn("ID");
		gridCategory.getTableModel().addColumn("Nome");
		gridCategory.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = gridCategory.getTable().getSelectedRow();
				if (row != -1) {
					editCategoryId.setText(gridCategory.getTableModel().getValueAt(row, 0).toString());
					editCategoryName.setText(gridCategory.getTableModel().getValueAt(row, 1).toString());
				}
			}
		});
		gridCategory.getScrollPane().setBounds(10, 300, 600, 200);
		
		panel.add(labelCategoryId);
		panel.add(editCategoryId);
		panel.add(labelCategoryName);
		panel.add(editCategoryName);
		panel.add(editCategoryGrid);
		panel.add(gridCategory.getScrollPane());
		
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
