package com.github.marcosws.crs.view.mdi.chid;

public interface IControlChild {
	
	void create();
	void update();
	void delete();
	void read();
	void confirm();
	void cancel();
	void exit();
	void enableDisableFields(boolean enable);

}
