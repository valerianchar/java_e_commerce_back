package com.doranco.entity;

public class ResponseModel<T> {
	
	public ResponseModel() {
	}
	public ResponseModel(T data, String error) {
		this.data = data;
		this.error = error;
	}
	private T data;
	private String error;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
