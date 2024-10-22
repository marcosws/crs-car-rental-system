package com.github.marcosws.crs.view.mdi.chid.register.vehicle;


import com.github.marcosws.crs.view.mdi.chid.ControlChild;
import com.github.marcosws.crs.view.mdi.utils.CRSDimension;

public class AutomakerView extends ControlChild {
	

	public AutomakerView() {
		
		super("Montadora");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setBounds(0, 0, CRSDimension.getWidth(), CRSDimension.getHeight());
        
	}
	
	public void initialize() {
		frame.setVisible(true);
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

}
