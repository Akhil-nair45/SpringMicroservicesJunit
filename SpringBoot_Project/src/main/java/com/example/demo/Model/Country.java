package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String cName;
	
	@Column(name="description")
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", cName=" + cName + ", desc=" + desc + "]";
	}

	public Country(int id, String cName, String desc) {
		super();
		this.id = id;
		this.cName = cName;
		this.desc = desc;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
