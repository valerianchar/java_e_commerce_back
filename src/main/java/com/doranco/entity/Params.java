package com.doranco.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "params")
@NamedQueries({
@NamedQuery(name = "Params:FindById", query = "FROM Params p WHERE p.id = :id"),
@NamedQuery(name = "Params:findAll", query = "FROM Params p")
})
public class Params {

	
	public Params() {
	}

	public Params(byte[] cle_cryptage_pwd, byte[] cle_cryptage_cp) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
		this.cle_cryptage_cp = cle_cryptage_cp;
	}

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "cle_cryptage_pwd", nullable = false, columnDefinition = "TINYBLOB")
	@Lob
	private byte[] cle_cryptage_pwd;
	
	@Column(name = "cle_cryptage_cp", nullable = false, columnDefinition = "TINYBLOB")
	@Lob
	private byte[] cle_cryptage_cp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getCle_cryptage_pwd() {
		return cle_cryptage_pwd;
	}

	public void setCle_cryptage_pwd(byte[] cle_cryptage_pwd) {
		this.cle_cryptage_pwd = cle_cryptage_pwd;
	}

	public byte[] getCle_cryptage_cp() {
		return cle_cryptage_cp;
	}

	public void setCle_cryptage_cp(byte[] cle_cryptage_cp) {
		this.cle_cryptage_cp = cle_cryptage_cp;
	}
	
	
}
