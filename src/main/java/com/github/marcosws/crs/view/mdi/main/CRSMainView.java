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
import javax.swing.JOptionPane;

import com.github.marcosws.crs.view.mdi.chid.register.ClientView;
import com.github.marcosws.crs.view.mdi.chid.register.UserView;
import com.github.marcosws.crs.view.mdi.chid.register.vehicle.AutomakerView;
import com.github.marcosws.crs.view.mdi.chid.register.vehicle.CategoryView;
import com.github.marcosws.crs.view.mdi.chid.register.vehicle.ModelView;
import com.github.marcosws.crs.view.mdi.chid.register.vehicle.TypeView;
import com.github.marcosws.crs.view.mdi.chid.register.vehicle.VehicleView;
import com.github.marcosws.crs.view.utils.CRSDimension;
import com.github.marcosws.crs.view.utils.CRSLoggedUser;
import com.github.marcosws.crs.view.utils.CRSStatusBar;
import com.github.marcosws.crs.view.utils.CRSTitlesApplications;

public class CRSMainView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JDesktopPane jDesktopPane;
	private JMenuBar jMenuBar;
	
	private JMenu jMenuRegister;
	private JMenu jSubMenuVehicle;
	private JMenu jMenuOperation;
	private JMenu jMenuConsultation;
	private JMenu jMenuData;
	private JMenu jMenuReport;
	private JMenu jMenuSystem;
	private JMenu jMenuHelp;
	
	private JMenuItem jMenuItemAutomaker;
	private JMenuItem jMenuItemModel;
	private JMenuItem jMenuItemCategory;
	private JMenuItem jMenuItemType;
	private JMenuItem jMenuItemVehicle;
	
	private JMenuItem jMenuItemClient;
	private JMenuItem jMenuItemUser;
	private JMenuItem jMenuItemRentalData;
	
	private JMenuItem jMenuItemRental;
	private JMenuItem jMenuItemReturn;
	private JMenuItem jMenuItemLow;
	
	private JMenuItem jMenuItemRentals;
	private JMenuItem jMenuItemVehicles;
	
	private JMenuItem jMenuItemImport;
	private JMenuItem jMenuItemExport;
	
	private JMenuItem jMenuItemReportRental;
	private JMenuItem jMenuItemReportReturn;
	private JMenuItem jMenuItemReportLow;
	
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
		jMenuData = new JMenu("Dados");
		jMenuReport = new JMenu("Relatórios");
		jMenuSystem = new JMenu("Sistema");
		jMenuHelp = new JMenu("Ajuda");
		
		jMenuItemAutomaker = new JMenuItem("Montadora");
		jMenuItemModel = new JMenuItem("Modelo");
		jMenuItemCategory = new JMenuItem("Categoria");
		jMenuItemType = new JMenuItem("Tipo de Veículo");
		jMenuItemVehicle = new JMenuItem("Veículo");
		
		jMenuItemClient = new JMenuItem("Cliente");
		jMenuItemUser = new JMenuItem("Usuário");
		jMenuItemRentalData = new JMenuItem("Dados de Locação");
		
		jMenuItemRental = new JMenuItem("Locação");
		jMenuItemReturn = new JMenuItem("Devolução");
		jMenuItemLow = new JMenuItem("Baixa de Veículo");
		
		jMenuItemRentals = new JMenuItem("Locações");
		jMenuItemVehicles = new JMenuItem("Veículos");
		
		jMenuItemImport = new JMenuItem("Importação");
		jMenuItemExport = new JMenuItem("Exportação");
		
		jMenuItemReportRental = new JMenuItem("Relatório de Locações");
		jMenuItemReportReturn = new JMenuItem("Relatório de Devoluções");
		jMenuItemReportLow = new JMenuItem("Relatório de Baixa");
		
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
		jMenuRegister.add(jMenuItemRentalData);
		jMenuRegister.addSeparator();
		jMenuRegister.add(jMenuItemUser);
		
		jMenuOperation.add(jMenuItemRental);
		jMenuOperation.add(jMenuItemReturn);
		jMenuOperation.add(jMenuItemLow);
		
		jMenuConsultation.add(jMenuItemRentals);
		jMenuConsultation.add(jMenuItemVehicles);
		
		jMenuData.add(jMenuItemImport);
		jMenuData.add(jMenuItemExport);
		
		jMenuReport.add(jMenuItemReportRental);
		jMenuReport.add(jMenuItemReportReturn);
		jMenuReport.add(jMenuItemReportLow);
		
		jMenuSystem.add(jMenuItemInformation);
		jMenuSystem.add(jMenuItemRestart);
		jMenuSystem.addSeparator();
		jMenuSystem.add(jMenuItemExit);
		
		jMenuHelp.add(jMenuItemHelp);
		jMenuHelp.add(jMenuItemAbout);
		
		jMenuBar.add(jMenuRegister);
		jMenuBar.add(jMenuOperation);
		jMenuBar.add(jMenuConsultation);
		jMenuBar.add(jMenuData);
		jMenuBar.add(jMenuReport);
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
		jMenuItemModel.addActionListener(this);
		jMenuItemCategory.addActionListener(this);
		jMenuItemType.addActionListener(this);
		jMenuItemVehicle.addActionListener(this);
		
		jMenuItemClient.addActionListener(this);
		jMenuItemUser.addActionListener(this);
		
		jMenuItemRestart.addActionListener(this);
		jMenuItemExit.addActionListener(this);
		
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
		else if(event.getSource().equals(jMenuItemModel)) {
			
			ModelView modelView = new ModelView();
			modelView.initialize();
			jDesktopPane.add(modelView.getFrame());
			
		}
		else if(event.getSource().equals(jMenuItemCategory)) {
			
			CategoryView categoryView = new CategoryView();
			categoryView.initialize();
			jDesktopPane.add(categoryView.getFrame());
			
		}
		else if(event.getSource().equals(jMenuItemType)) {
			
			TypeView typeView = new TypeView();
			typeView.initialize();
			jDesktopPane.add(typeView.getFrame());
			
		}
		else if(event.getSource().equals(jMenuItemVehicle)) {
			
			VehicleView vehicleView = new VehicleView();
			vehicleView.initialize();
			jDesktopPane.add(vehicleView.getFrame());
			
		}
		else if(event.getSource().equals(jMenuItemClient)) {
			
			ClientView clientView = new ClientView();
			clientView.initialize();
			jDesktopPane.add(clientView.getFrame());
			
		}
		else if(event.getSource().equals(jMenuItemUser)) {
			
			UserView userView = new UserView();
			userView.initialize();
			jDesktopPane.add(userView.getFrame());
			
		}
		else if(event.getSource().equals(jMenuItemRestart)) {
        	CRSLoginView crsLoginView = new CRSLoginView();
        	crsLoginView.initialize();
        	CRSLoggedUser.setUserName("");
        	CRSLoggedUser.setUserLogin("");
        	CRSLoggedUser.setUserAdministrator(false);
        	this.dispose();
		}
		else if(event.getSource().equals(jMenuItemExit)) {
            if(JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", CRSTitlesApplications.TITLE_SHORT_APPLICATION, JOptionPane.OK_CANCEL_OPTION) == 0){
                System.exit(0);
            }
		}
		
	}

}
