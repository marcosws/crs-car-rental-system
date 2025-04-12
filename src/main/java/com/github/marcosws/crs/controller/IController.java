package com.github.marcosws.crs.controller;

public interface IController<T> {
	
	void create(T view);
	void update(T view);
	void delete(T view);
	void read(T view);
	
}
