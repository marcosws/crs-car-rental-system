package com.github.marcosws.crs.view.mdi.chid.register;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.github.marcosws.crs.view.mdi.chid.ControlChild;
import com.github.marcosws.crs.view.utils.CRSDimension;
import com.github.marcosws.crs.view.utils.custon.CRSGridView;

public class UserView extends ControlChild {

	private JTextField editUserId;
	private JTextField editUserName;
	private JTextField editUserLogin;
	private JPasswordField pwdUserEditPassword;
	private JPasswordField pwdUserConfirmPassword;
	
	private JCheckBox chkUserActive;
	private JCheckBox chkUserAdmin;
	
	private CRSGridView gridUser;
	
	
	public UserView() {
		
		super("Usuário","Cadastro de Usuário");
		
		editUserId = new JTextField();
		editUserName = new JTextField();
		editUserLogin = new JTextField();
		pwdUserEditPassword = new JPasswordField();
		pwdUserConfirmPassword = new JPasswordField();
		chkUserActive = new JCheckBox("Ativo");
		chkUserAdmin = new JCheckBox("Administrador");
		
		
		JLabel labelUserId = new JLabel("ID");
		labelUserId.setBounds(20, 180, 200, 20);
		editUserId.setBounds(20, 200, 200, 20);
		editUserId.setEditable(false);
		
		JLabel labelUserName = new JLabel("Nome");
		labelUserName.setBounds(20, 220, 200, 20);
		editUserName.setBounds(20, 240, 200, 20);
		
		JLabel labelUserLogin = new JLabel("Login");
		labelUserLogin.setBounds(20, 260, 200, 20);
		editUserLogin.setBounds(20, 280, 200, 20);
		
		JLabel labelUserPassword = new JLabel("Senha");
		labelUserPassword.setBounds(260, 220, 200, 20);
		pwdUserEditPassword.setBounds(260, 240, 200, 20);
		
		JLabel labelUserConfirmPassword = new JLabel("Confirma Senha");
		labelUserConfirmPassword.setBounds(260, 260, 200, 20);
		pwdUserConfirmPassword.setBounds(260, 280, 200, 20);
		
		JPanel groupBoxAtributes = new JPanel();
		groupBoxAtributes.setLayout(null);
		groupBoxAtributes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Atributos"));
		groupBoxAtributes.setBounds(20, 320, 700, 60);
		
		chkUserActive.setBounds(10, 20, 200, 20);
		chkUserActive.setSelected(true);
		
		chkUserAdmin.setBounds(240, 20, 200, 20);
		
		groupBoxAtributes.add(chkUserActive);
		groupBoxAtributes.add(chkUserAdmin);
		
		JLabel labelUserGrid = new JLabel("Usuários Cadastrados");
		labelUserGrid.setBounds(20, 400, 200, 20);
		gridUser = new CRSGridView();
		gridUser.getTableModel().addColumn("ID");
		gridUser.getTableModel().addColumn("Nome");
		gridUser.getTableModel().addColumn("Login");
		gridUser.getTableModel().addColumn("Ativo");
		gridUser.getTableModel().addColumn("Administrador");
		gridUser.getTable().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int row = gridUser.getTable().getSelectedRow();
				if (row != -1) {
					editUserId.setText(gridUser.getTableModel().getValueAt(row, 0).toString());
					editUserName.setText(gridUser.getTableModel().getValueAt(row, 1).toString());
					editUserLogin.setText(gridUser.getTableModel().getValueAt(row, 2).toString());
					chkUserActive.setSelected(Boolean.parseBoolean(gridUser.getTableModel().getValueAt(row, 3).toString()));
					chkUserAdmin.setSelected(Boolean.parseBoolean(gridUser.getTableModel().getValueAt(row, 4).toString()));
				}
			}
		});
		gridUser.getScrollPane().setBounds(20, 420, 700, 200);
		
		
		panel.add(labelUserId);
		panel.add(editUserId);
		panel.add(labelUserName);
		panel.add(editUserName);
		panel.add(labelUserLogin);
		panel.add(editUserLogin);
		panel.add(labelUserPassword);
		panel.add(pwdUserEditPassword);
		panel.add(labelUserConfirmPassword);
		panel.add(pwdUserConfirmPassword);
		panel.add(groupBoxAtributes);
		panel.add(labelUserGrid);
		panel.add(gridUser.getScrollPane());
		
		
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
