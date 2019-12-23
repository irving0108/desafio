package com.chero.desafio.service;

import java.util.List;

public interface BaseService<T> {

	void insert(T t);
	void update(T t);
	void delete(Integer id);
	List<T> listAll();
}
