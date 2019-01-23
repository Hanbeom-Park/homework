package com.ssafy.hw;

public class Member {
	private String id;  //  PK
	private String name;
	private String gender;
	private String tel;
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", gender=" + gender + ", tel=" + tel + "]\n";
	}
	public Member(String name, String gender, String tel) {
		super();
		//this.id = id;
		this.name = name;
		this.gender = gender;
		this.tel = tel;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
