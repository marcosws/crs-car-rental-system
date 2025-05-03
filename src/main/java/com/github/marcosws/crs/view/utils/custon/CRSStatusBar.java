package com.github.marcosws.crs.view.utils.custon;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.github.marcosws.crs.view.utils.CRSDimension;
import com.github.marcosws.crs.view.utils.CRSLoggedUser;
import com.github.marcosws.crs.view.utils.CRSTitlesApplications;

public class CRSStatusBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;
	
	public CRSStatusBar(){
		
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.setPreferredSize(new Dimension(CRSDimension.getWidth(), 24));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		String label = CRSTitlesApplications.TITLE_APPLICATION.concat(" | ")
				.concat("[")
				.concat(CRSLoggedUser.getDatabaseName())
				.concat("] | ")
				.concat(" Usuário: ")
				.concat(CRSLoggedUser.getUserLogin());
		
		statusLabel = new JLabel(label);
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusLabel.setForeground(Color.GRAY);
		this.add(statusLabel);
		
	}

}
