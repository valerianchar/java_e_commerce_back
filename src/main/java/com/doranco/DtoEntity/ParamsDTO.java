package com.doranco.DtoEntity;

public class ParamsDTO {

	
	public ParamsDTO() {
	}

	public ParamsDTO(Byte cle_cryptage_pwd, Byte cle_cryptage_cp) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
		this.cle_cryptage_cp = cle_cryptage_cp;
	}

	private int id;
	
	private Byte cle_cryptage_pwd;
	
	private Byte cle_cryptage_cp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Byte getCle_cryptage_pwd() {
		return cle_cryptage_pwd;
	}

	public void setCle_cryptage_pwd(Byte cle_cryptage_pwd) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
	}

	public Byte getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}

	public void setCle_cryptage_cp(Byte cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	
	
}
