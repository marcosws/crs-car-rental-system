package com.github.marcosws.crs.view.mdi.chid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.github.marcosws.crs.service.Utils;
import com.github.marcosws.crs.view.utils.CRSDimension;

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
		CONFIRM("Confirmar"),
		CANCEL("Cancelar"),
		EXIT("Sair");
		
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
        ImageIcon iconCreate = new ImageIcon(Utils.getFullPathResource("/img/create.png"));
        buttonCreate.setIcon(iconCreate);
        buttonCreate.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCreate.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonUpdate.setBounds(120, 60, 100, 44);
        ImageIcon iconUpdate = new ImageIcon(Utils.getFullPathResource("/img/update.png"));
        buttonUpdate.setIcon(iconUpdate);
        buttonUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonUpdate.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonDelete.setBounds(220, 60, 100, 44);
        ImageIcon iconDelete = new ImageIcon(Utils.getFullPathResource("/img/delete.png"));
        buttonDelete.setIcon(iconDelete);
        buttonDelete.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonRead.setBounds(320, 60, 100, 44);
        ImageIcon iconRead = new ImageIcon(Utils.getFullPathResource("/img/read.png"));
        buttonRead.setIcon(iconRead);
        buttonRead.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonRead.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonConfirm.setBounds(420, 60, 100, 44);
        ImageIcon iconConfirm = new ImageIcon(Utils.getFullPathResource("/img/confirm.png"));
        buttonConfirm.setIcon(iconConfirm);
        buttonConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonConfirm.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonCancel.setBounds(520, 60, 100, 44);
        ImageIcon iconCancel = new ImageIcon(Utils.getFullPathResource("/img/cancel.png"));
        buttonCancel.setIcon(iconCancel);
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.setVerticalTextPosition(SwingConstants.BOTTOM);
        
    	buttonExit.setBounds(620, 60, 100, 44);
        ImageIcon iconExit = new ImageIcon(Utils.getFullPathResource("/img/exit.png"));
        buttonExit.setIcon(iconExit);
        buttonExit.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonExit.setVerticalTextPosition(SwingConstants.BOTTOM);
        

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
	
	public void initialize() {
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

}
