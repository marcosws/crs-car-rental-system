package com.github.marcosws.crs.view.mdi.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.github.marcosws.crs.controller.crsmain.CRSChangePasswordController;
import com.github.marcosws.crs.service.Utils;
import com.github.marcosws.crs.view.utils.CRSTitlesApplications;

public class CRSChangePasswordView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private final JTextField editLogin;
	private final JPasswordField pwdActualPassword;
	private final JPasswordField pwdNewPassword;
	private final JPasswordField pwdConfirmPassword;
	private final JButton buttonCancel;
	private final JButton buttonConfirmChangePassword;
	private final JButton buttonExit;
	private final JPanel panel;
	
	public JTextField getEditLogin() {
		return editLogin;
	}


	public JPasswordField getPwdActualPassword() {
		return pwdActualPassword;
	}


	public JPasswordField getPwdNewPassword() {
		return pwdNewPassword;
	}


	public JPasswordField getPwdConfirmPassword() {
		return pwdConfirmPassword;
	}


	public CRSChangePasswordView() {
		
		panel = new JPanel();
		panel.setLayout(null);
			        
		editLogin = new JTextField();
		pwdActualPassword = new JPasswordField();
		pwdNewPassword = new JPasswordField();
		pwdConfirmPassword = new JPasswordField();
			        
		JLabel labelTitle = new JLabel("Alterar Senha");
		labelTitle.setBounds(10, 10, 300, 30);
		labelTitle.setFont(new Font("Arial",Font.BOLD,14));
			        
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(10, 40, 100, 20);
		editLogin.setBounds(10, 60, 200, 20);
			        
		JLabel labelActualPassword = new JLabel("Sua Senha Atual");
		labelActualPassword.setBounds(10, 80, 200, 20);
		pwdActualPassword.setBounds(10, 100, 200, 20);
			        
		JLabel labelNewPassword = new JLabel("Nova Senha");
		labelNewPassword.setBounds(10, 120, 200, 20);
		pwdNewPassword.setBounds(10, 140, 200, 20);
			        
		JLabel labelConfirmPassword = new JLabel("Confirmar Senha");
		labelConfirmPassword.setBounds(10, 160, 200, 20);
		pwdConfirmPassword.setBounds(10, 180, 200, 20);
			       
		buttonConfirmChangePassword = new JButton("Confirmar");
		buttonConfirmChangePassword.setBounds(10, 220, 130, 44);
        ImageIcon iconConfirmChangePassword = new ImageIcon(Utils.getFullPathResource("/img/confirm.png"));
        buttonConfirmChangePassword.setIcon(iconConfirmChangePassword);
        buttonConfirmChangePassword.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonConfirmChangePassword.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		buttonCancel = new JButton("Cancelar");
		buttonCancel.setBounds(150, 220, 130, 44);
        ImageIcon iconCancel = new ImageIcon(Utils.getFullPathResource("/img/cancel.png"));
        buttonCancel.setIcon(iconCancel);
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.setVerticalTextPosition(SwingConstants.BOTTOM);
			        
		buttonExit = new JButton("Sair");
		buttonExit.setBounds(290, 220, 130, 44);
        ImageIcon iconExit = new ImageIcon(Utils.getFullPathResource("/img/exit.png"));
        buttonExit.setIcon(iconExit);
        buttonExit.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonExit.setVerticalTextPosition(SwingConstants.BOTTOM);
		
        panel.add(labelTitle);
        panel.add(labelLogin);
        panel.add(editLogin);
        panel.add(labelActualPassword);
        panel.add(pwdActualPassword);
        panel.add(labelNewPassword);
        panel.add(pwdNewPassword);
        panel.add(labelConfirmPassword);
        panel.add(pwdConfirmPassword);
        panel.add(buttonCancel);
        panel.add(buttonConfirmChangePassword);
        panel.add(buttonExit);
	}
	
    public void initialize(){
        
        buttonCancel.addActionListener(this);
        buttonConfirmChangePassword.addActionListener(this);
        buttonExit.addActionListener(this);
                
        this.setTitle(CRSTitlesApplications.TITLE_SHORT_APPLICATION);
        this.setBounds(0, 0, 430, 310);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);
        
    }
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource().equals(buttonCancel)){
			
			CRSLoginView crsLoginView = new CRSLoginView();
			crsLoginView.initialize();
	        this.dispose();
	        
	    }
	    else if(event.getSource().equals(buttonConfirmChangePassword)){
	    	
	        CRSChangePasswordController crsChangePasswordController = new CRSChangePasswordController();

	        switch(crsChangePasswordController.changePasword(this)){
	        	case USER_OK:{
	        		CRSLoginView crsLoginView = new CRSLoginView();
	        		crsLoginView.initialize();
	                this.dispose();
	                break;
	        	}
	            case DIFFERENT_PASSWORD:{
	            	JOptionPane.showMessageDialog(null, "implement dif pass");
	                break;
	            }
	            case EMPTY_PASSWORD:{
	            	JOptionPane.showMessageDialog(null, "implement vazio");
	                 break;
	            }
	            case INACTIVE:{
	            	int option = JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION;
					JOptionPane.showMessageDialog(null, "Usuário inativo!\nContate o administrador do sistema.", "Acesso Negado", option);
	                break;
	            }
	             default:{
	                int option = JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION;
	                JOptionPane.showMessageDialog(null, "Login ou Senha Inválido!", "Acesso Negado", option);
	                break;
	             }
	        }
	    }
	    else if(event.getSource().equals(buttonExit)){
            if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Login", JOptionPane.OK_CANCEL_OPTION) == 0){
                System.exit(0);
            }
    }
	
		
	}

}
