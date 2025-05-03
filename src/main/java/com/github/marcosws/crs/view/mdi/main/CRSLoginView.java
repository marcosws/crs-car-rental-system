package com.github.marcosws.crs.view.mdi.main;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.github.marcosws.crs.controller.login.CRSLoginController;
import com.github.marcosws.crs.view.utils.CRSTitlesApplications;

public class CRSLoginView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
    private final JTextField  editLogin;
    private final JPasswordField pwdPassword;
    private final JButton buttonAccess;
    private final JButton buttonChangePassword;
    private final JButton buttonExit;
    private final JPanel panel;
	

	public JTextField getEditLogin() {
		return editLogin;
	}

	public JPasswordField getPwdPassword() {
		return pwdPassword;
	}

	public CRSLoginView() {

		
        panel = new JPanel();
        panel.setLayout(null);
        
        editLogin = new JTextField();
        pwdPassword = new JPasswordField();
        JLabel labelTitle = new JLabel("Login");
        JLabel labelLogin = new JLabel("Login");
        JLabel labelPassword = new JLabel("Senha");
        buttonAccess = new JButton("Acessar");
        buttonChangePassword = new JButton("Alterar Senha");
        buttonExit = new JButton("Sair");
        
        ImageIcon iconAccess = new ImageIcon(getClass().getResource("/img/confirm.png"));
        buttonAccess.setIcon(iconAccess);
        buttonAccess.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonAccess.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        ImageIcon iconChangePassword = new ImageIcon(getClass().getResource("/img/update.png"));
        buttonChangePassword.setIcon(iconChangePassword);
        buttonChangePassword.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonChangePassword.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        ImageIcon iconExit = new ImageIcon(getClass().getResource("/img/exit.png"));
        buttonExit.setIcon(iconExit);
        buttonExit.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonExit.setVerticalTextPosition(SwingConstants.BOTTOM);
        
        
        labelTitle.setBounds(10, 10, 300, 30);
        labelTitle.setFont(new Font("Arial",Font.BOLD,14));
        
        labelLogin.setBounds(10, 40, 100, 20);
        editLogin.setBounds(10, 60, 200, 20);
        labelPassword.setBounds(10, 80, 100, 20);        
        pwdPassword.setBounds(10, 100, 200, 20);
        
        buttonAccess.setBounds(10, 140, 130, 44);
        buttonChangePassword.setBounds(150, 140, 130, 44);
        buttonExit.setBounds(290, 140, 130, 44);
        
        panel.add(labelTitle);
        panel.add(labelLogin);
        panel.add(editLogin);
        panel.add(labelPassword);
        panel.add(pwdPassword);
        panel.add(buttonAccess);
        panel.add(buttonChangePassword);
        panel.add(buttonExit);
        
		List<Image> icons = new ArrayList<Image>();
		icons.add(new javax.swing.ImageIcon(getClass().getResource("/img/mainicon16.png")).getImage());
		icons.add(new javax.swing.ImageIcon(getClass().getResource("/img/mainicon32.png")).getImage());
		this.setIconImages(icons);

		
	}
	
    public void initialize(){
        
        buttonAccess.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonChangePassword.addActionListener(this);
        
        this.setTitle(CRSTitlesApplications.TITLE_SHORT_APPLICATION);
        this.setBounds(0, 0, 430, 230);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);
        
    }



	@Override
	public void actionPerformed(ActionEvent event) {
		
        if(event.getSource().equals(buttonAccess)){
            
            CRSLoginController crsLoginController = new CRSLoginController();
            switch (crsLoginController.login(this)) {
                case USER_OK:{
                    CRSMainView crsMainView = new CRSMainView();
                    crsMainView.initialize();
                    this.dispose();
                    break;
                }
                case INACTIVE:{
					int option = JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION;
					JOptionPane.showMessageDialog(null, "Usuário inativo!\nContate o administrador do sistema.", "Acesso Negado", option);
					break;
				}
                case RESET_PASSWORD:{
                    CRSChangePasswordView crsChangePasswordView = new CRSChangePasswordView();
                    crsChangePasswordView.initialize();
                    this.dispose();
                    break;
                }
                default:{
                    int option = JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION;
                    JOptionPane.showMessageDialog(null, "Login ou Senha Inválido!", "Acesso Negado", option);
                    break;
                }
            }

        }
        else if(event.getSource().equals(buttonChangePassword)){
            CRSChangePasswordView crsChangePasswordView = new CRSChangePasswordView();
            crsChangePasswordView.initialize();
            this.dispose();
        }
        else if(event.getSource().equals(buttonExit)){
            if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Login", JOptionPane.OK_CANCEL_OPTION) == 0){
                System.exit(0);
            }
        }
		
		
	}

}
