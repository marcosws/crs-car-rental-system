package com.github.marcosws.crs;

import com.github.marcosws.crs.view.mdi.main.CRSLoginView;

public class CRSMainExec {

	public static void main(String[] args) {
		
        java.awt.EventQueue.invokeLater(() -> {
        	CRSLoginView crsLoginView = new CRSLoginView();
        	crsLoginView.initialize();
        });

	}

}
