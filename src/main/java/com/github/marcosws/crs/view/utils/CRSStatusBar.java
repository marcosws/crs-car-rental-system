package com.github.marcosws.crs.view.utils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class CRSStatusBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;
	
	public CRSStatusBar(){
		
		this.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.setPreferredSize(new Dimension(CRSDimension.getWidth(), 24));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		statusLabel = new JLabel(CRSTitlesApplications.TITLE_APPLICATION);
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusLabel.setForeground(Color.GRAY);
		this.add(statusLabel);
		
	}

}
