package com.github.marcosws.crs.view.mdi.chid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import com.github.marcosws.crs.view.mdi.utils.CRSDimension;

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
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setBounds(0, 0, CRSDimension.getWidth(), CRSDimension.getHeight());
		frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		//frame.setResizable(true);
		//frame.setMaximizable(true);
		//frame.setIconifiable(true);
		//frame.setClosable(true);
		//frame.setVisible(false);
        
	}
	
	public void initialize() {
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

}
