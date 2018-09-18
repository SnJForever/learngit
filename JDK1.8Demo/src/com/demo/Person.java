package com.demo;

public class Person {
	private String name;
	private Integer age;
	private String sex;

	public Person(){
		
	}
	public Person(String name,Integer age,String sex){
		this.setName(name);
		this.setAge(age);
		this.setSex(sex);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
}
