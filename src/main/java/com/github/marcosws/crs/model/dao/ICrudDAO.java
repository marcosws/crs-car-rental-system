package com.github.marcosws.crs.model.dao;

import java.util.List;

public interface ICrudDAO<T> {

	void create(T entity);
	T read(Long id);
	List<T> readAll();
	void update(T entity);
	void delete(T entity);

}
