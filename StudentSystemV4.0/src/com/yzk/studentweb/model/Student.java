package com.yzk.studentweb.model;

public class Student {
	private String name;
	private int age;
	private String gender;
	private String grade;
	private String url;
	private int id;
	public Student(String name, int age, String gender, String grade, String url, int id) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.grade = grade;
		this.url = url;
		this.id = id;
	}
	public Student(String name, int age, String gender, String grade, String url) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.grade = grade;
		this.url = url;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender + ", grade=" + grade + ", url=" + url
				+ ", id=" + id + "]";
	}
	
}