package com.doranco.Dao.Interface;

public interface ICrud<T> {

	void add(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(int id) throws Exception;
	T getById(int id) throws Exception;
	
}
