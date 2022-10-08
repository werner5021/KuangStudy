package com.werner.pojo;

//實體類，一般都是和資料庫中的table結構一一對應
public class People {
	private int id;
    private String name;
    private int age;
    private String address;
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(int id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}  
}


