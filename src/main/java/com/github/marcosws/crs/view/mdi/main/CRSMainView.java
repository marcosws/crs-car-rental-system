package com.github.marcosws.crs.view.mdi.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.github.marcosws.crs.view.mdi.chid.register.vehicle.AutomakerView;
import com.github.marcosws.crs.view.mdi.utils.CRSDimension;
import com.github.marcosws.crs.view.mdi.utils.CRSStatusBar;

public class CRSMainView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JDesktopPane jDesktopPane;
	private JMenuBar jMenuBar;
	
	private JMenu jMenuRegister;
	private JMenu jSubMenuVehicle;
	private JMenu jMenuOperation;
	private JMenu jMenuConsultation;
	private JMenu jMenuSystem;
	private JMenu jMenuHelp;
	
	private JMenuItem jMenuItemAutomaker;
	private JMenuItem jMenuItemModel;
	private JMenuItem jMenuItemCategory;
	private JMenuItem jMenuItemType;
	private JMenuItem jMenuItemVehicle;
	
	private JMenuItem jMenuItemClient;
	private JMenuItem jMenuItemUser;
	
	private JMenuItem jMenuItemRental;
	private JMenuItem jMenuItemReturn;
	private JMenuItem jMenuItemLow;
	
	private JMenuItem jMenuItemRentals;
	private JMenuItem jMenuItemVehicles;
	
	private JMenuItem jMenuItemInformation;
	private JMenuItem jMenuItemRestart;
	private JMenuItem jMenuItemExit;
	
	private JMenuItem jMenuItemHelp;
	private JMenuItem jMenuItemAbout;
	
	
	public CRSMainView() {
		
		jDesktopPane = new JDesktopPane();
		jMenuBar = new JMenuBar();
		
		jMenuRegister = new JMenu("Cadastro");
		jSubMenuVehicle = new JMenu("Veículo");
		jMenuOperation = new JMenu("Operação");
		jMenuConsultation = new JMenu("Consulta");
		jMenuSystem = new JMenu("Sistema");
		jMenuHelp = new JMenu("Ajuda");
		
		jMenuItemAutomaker = new JMenuItem("Montadora");
		jMenuItemModel = new JMenuItem("Modelo");
		jMenuItemCategory = new JMenuItem("Categoria");
		jMenuItemType = new JMenuItem("Tipo de Veículo");
		jMenuItemVehicle = new JMenuItem("Veículo");
		
		jMenuItemClient = new JMenuItem("Cliente");
		jMenuItemUser = new JMenuItem("Usuário");
		
		jMenuItemRental = new JMenuItem("Locação");
		jMenuItemReturn = new JMenuItem("Devolução");
		jMenuItemLow = new JMenuItem("Baixa de Veículo");
		
		jMenuItemRentals = new JMenuItem("Locações");
		jMenuItemVehicles = new JMenuItem("Veículos");
		
		jMenuItemInformation = new JMenuItem("Informações do Sistema");
		jMenuItemRestart = new JMenuItem("Reiniciar");
		jMenuItemExit = new JMenuItem("Sair");
		
		jMenuItemHelp = new JMenuItem("Ajuda");
		jMenuItemAbout = new JMenuItem("Sobre");
		
		
		jSubMenuVehicle.add(jMenuItemAutomaker);
		jSubMenuVehicle.add(jMenuItemModel);
		jSubMenuVehicle.add(jMenuItemCategory);
		jSubMenuVehicle.add(jMenuItemType);
		jSubMenuVehicle.addSeparator();
		jSubMenuVehicle.add(jMenuItemVehicle);
		
		jMenuRegister.add(jSubMenuVehicle);
		jMenuRegister.add(jMenuItemClient);
		jMenuRegister.addSeparator();
		jMenuRegister.add(jMenuItemUser);
		
		jMenuOperation.add(jMenuItemRental);
		jMenuOperation.add(jMenuItemReturn);
		jMenuOperation.add(jMenuItemLow);
		
		jMenuConsultation.add(jMenuItemRentals);
		jMenuConsultation.add(jMenuItemVehicles);
		
		jMenuSystem.add(jMenuItemInformation);
		jMenuSystem.add(jMenuItemRestart);
		jMenuSystem.addSeparator();
		jMenuSystem.add(jMenuItemExit);
		
		jMenuHelp.add(jMenuItemHelp);
		jMenuHelp.add(jMenuItemAbout);
		
		jMenuBar.add(jMenuRegister);
		jMenuBar.add(jMenuOperation);
		jMenuBar.add(jMenuConsultation);
		jMenuBar.add(jMenuSystem);
		jMenuBar.add(jMenuHelp);
		
		this.setMaximumSize(new Dimension(900, 600));
		this.jDesktopPane.setBackground(Color.DARK_GRAY);
		this.setTitle("CRS - Car Rental System (Sistema de Locadora de Veículos)");
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jDesktopPane, BorderLayout.CENTER);
		this.add(new CRSStatusBar(), BorderLayout.SOUTH);
		this.setJMenuBar(jMenuBar);
		this.pack();
		

		
	}
	
	public void initialize() {
		
		this.setVisible(true);
		jMenuItemAutomaker.addActionListener(this);
		
        GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds  = gEnvironment.getMaximumWindowBounds();
        Dimension dimension = bounds.getSize();
        CRSDimension.setHeight((int) dimension.getHeight());
        CRSDimension.setWidth((int) dimension.getWidth());
        
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource().equals(jMenuItemAutomaker)) {
			
			AutomakerView automakerView = new AutomakerView();
			automakerView.initialize();
			jDesktopPane.add(automakerView.getFrame());
			
		}
	}

}
