package com.github.marcosws.crs.view.mdi.chid.register.vehicle;

import javax.swing.JInternalFrame;

import com.github.marcosws.crs.view.mdi.chid.ControlChild;
import com.github.marcosws.crs.view.utils.CRSDimension;

public class VehicleView extends ControlChild  {

	public VehicleView() {
		super("Veículo","name");
		
		
		
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setBounds(0, 0, CRSDimension.getWidth(), CRSDimension.getHeight());
		frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
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
	public void enableDisableFields() {
		// TODO Auto-generated method stub
		
	}

}
