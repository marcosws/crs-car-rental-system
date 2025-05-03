package com.github.marcosws.crs.view.mdi.chid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.github.marcosws.crs.view.utils.CRSTitlesApplications;

public abstract class ControlChild implements ActionListener, IControlChild {
	
	protected JInternalFrame frame;
	protected JPanel panel;
	
	protected JLabel labelTitle;
	protected JLabel labelOperationName;
	protected JButton buttonCreate;
	protected JButton buttonUpdate;
	protected JButton buttonDelete;
	protected JButton buttonRead;
	protected JButton buttonConfirm;
	protected JButton buttonCancel;
	protected JButton buttonExit;
	
	private String operation;
	

    public JInternalFrame getFrame() {
        return frame;
    }
    
    protected enum Operation {
		CREATE("Incluir"),
		UPDATE("Alterar"),
		DELETE("Excluir"),
		READ("Consultar"),
		SELECT_OPERATION("Selecione a Operação");
		
		private String name;
		
		Operation(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public ControlChild(String nameForm, String nameFrame) {
		
        panel = new JPanel();
        panel.setLayout(null);
        frame = new JInternalFrame(nameForm, true, true, true, true);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/mainicon16.png"));
        frame.setFrameIcon(icon);

    	labelTitle = new JLabel(nameFrame);
    	labelTitle.setFont(new Font("Arial", Font.BOLD, 14));
    	labelTitle.setBounds(20, 20, 500, 20);
    	
    	labelOperationName = new JLabel("Selecione a Operação");
    	labelOperationName.setFont(new Font("Arial", Font.BOLD, 14));
    	labelOperationName.setBounds(20, 120, 500, 20);
    	labelOperationName.setForeground(Color.BLUE);
    	
        
        buttonCreate = new JButton("Incluir");
    	buttonUpdate = new JButton("Alterar");
    	buttonDelete = new JButton("Excluir");
    	buttonRead = new JButton("Consultar");
    	buttonConfirm = new JButton("Confirmar");
    	buttonCancel = new JButton("Cancelar");
    	buttonExit = new JButton("Sair");
    	
    	
        buttonCreate.setBounds(20, 60, 100, 44);
        ImageIcon iconCreate = new ImageIcon(getClass().getResource("/img/create.png"));
        buttonCreate.setIcon(iconCreate);
        buttonCreate.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCreate.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonUpdate.setBounds(120, 60, 100, 44);
        ImageIcon iconUpdate = new ImageIcon(getClass().getResource("/img/update.png"));
        buttonUpdate.setIcon(iconUpdate);
        buttonUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonUpdate.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonDelete.setBounds(220, 60, 100, 44);
        ImageIcon iconDelete = new ImageIcon(getClass().getResource("/img/delete.png"));
        buttonDelete.setIcon(iconDelete);
        buttonDelete.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonRead.setBounds(320, 60, 100, 44);
        ImageIcon iconRead = new ImageIcon(getClass().getResource("/img/read.png"));
        buttonRead.setIcon(iconRead);
        buttonRead.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonRead.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonConfirm.setBounds(420, 60, 100, 44);
        ImageIcon iconConfirm = new ImageIcon(getClass().getResource("/img/confirm.png"));
        buttonConfirm.setIcon(iconConfirm);
        buttonConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonConfirm.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonCancel.setBounds(520, 60, 100, 44);
        ImageIcon iconCancel = new ImageIcon(getClass().getResource("/img/cancel.png"));
        buttonCancel.setIcon(iconCancel);
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonExit.setBounds(620, 60, 100, 44);
        ImageIcon iconExit = new ImageIcon(getClass().getResource("/img/exit.png"));
        buttonExit.setIcon(iconExit);
        buttonExit.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonExit.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        buttonConfirm.setEnabled(false);
        buttonCancel.setEnabled(false);
        
        panel.add(labelTitle);
        panel.add(labelOperationName);
        panel.add(buttonDelete);
        panel.add(buttonCreate);
        panel.add(buttonDelete);
        panel.add(buttonUpdate);
        panel.add(buttonRead);
        panel.add(buttonConfirm);
        panel.add(buttonCancel);
        panel.add(buttonExit);
        
	}
	
	protected void enableDisableButtons(boolean enable) {
		
		buttonCreate.setEnabled(enable);
		buttonUpdate.setEnabled(enable);
		buttonDelete.setEnabled(enable);
		buttonRead.setEnabled(enable);
		buttonConfirm.setEnabled(!enable);
		buttonCancel.setEnabled(!enable);
		
	}
	
	public void initialize() {
		
		frame.setVisible(true);
		
		buttonCreate.addActionListener(this);
		buttonUpdate.addActionListener(this);
		buttonDelete.addActionListener(this);
		buttonRead.addActionListener(this);
		buttonConfirm.addActionListener(this);
		buttonCancel.addActionListener(this);
		buttonExit.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
		if (event.getSource().equals(buttonCreate)) {
			
			this.enableDisableButtons(false);
			operation = OperationNameEnum.CREATE.getOperationName();
			labelOperationName.setText(Operation.CREATE.getName());
			this.enableDisableFields();

		}
		else if (event.getSource().equals(buttonUpdate)) {
			
			this.enableDisableButtons(false);
			operation = OperationNameEnum.UPDATE.getOperationName();
			labelOperationName.setText(Operation.UPDATE.getName());
			this.enableDisableFields();

		}
		else if (event.getSource().equals(buttonDelete)) {
			
			this.enableDisableButtons(false);
			operation = OperationNameEnum.DELETE.getOperationName();
			labelOperationName.setText(Operation.DELETE.getName());
			this.enableDisableFields();

		}
		else if (event.getSource().equals(buttonRead)) {
			
			this.enableDisableButtons(false);
			operation = OperationNameEnum.READ.getOperationName();
			labelOperationName.setText(Operation.READ.getName());
			this.enableDisableFields();

		}
		else if (event.getSource().equals(buttonConfirm)) {
			
			this.enableDisableButtons(true);
			labelOperationName.setText(Operation.SELECT_OPERATION.getName());
			if(operation.equals(OperationNameEnum.CREATE.getOperationName())) {
				this.create();
			}
			else if (operation.equals(OperationNameEnum.UPDATE.getOperationName())) {
				this.update();
			}
			else if (operation.equals(OperationNameEnum.DELETE.getOperationName())) {
				this.delete();
			}
			else if (operation.equals(OperationNameEnum.READ.getOperationName())) {
				this.read();
			}
			
			operation = "";
			this.enableDisableFields();
			
		}
		else if (event.getSource().equals(buttonCancel)) {
			
			this.enableDisableButtons(true);
			labelOperationName.setText(Operation.SELECT_OPERATION.getName());
			operation = OperationNameEnum.CANCEL.getOperationName();
			this.enableDisableFields();
			
		}
		else if (event.getSource().equals(buttonExit)) {
			
            if(JOptionPane.showConfirmDialog(null, "Deseja fechar o formulário?", CRSTitlesApplications.TITLE_SHORT_APPLICATION, JOptionPane.OK_CANCEL_OPTION) == 0){
            	frame.dispose();
            }
			
		}
		
	}

}
