package com.github.marcosws.crs.view.mdi.chid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public abstract class ControlChild implements ActionListener, IControlChild {
	
	protected JInternalFrame frame;
	protected JPanel panel;
	
    public JInternalFrame getFrame() {
        return frame;
    }
	
	public ControlChild(String nameForm) {
		
        panel = new JPanel();
        panel.setLayout(null);
        frame = new JInternalFrame(nameForm, true, true, true, true);
        
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

}
