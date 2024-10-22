package com.github.marcosws.crs.view;

import com.github.marcosws.crs.view.mdi.main.CRSMainView;

public class CRSMainExec {

	public static void main(String[] args) {
		
        java.awt.EventQueue.invokeLater(() -> {
        	CRSMainView mainView = new CRSMainView();
        	mainView.initialize();
        });

	}

}
