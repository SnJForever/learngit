package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {
	public static void main(String[] args) {
		Person person1 = new Person("lili", 15, "男");
		Person person2 = new Person("cali", 18, "男");
		Person person3 = new Person("jili", 13, "男");
		Person person4 = new Person("cece", 18, "男");
		Person person5 = new Person("sese", 16, "男");
		Person person6 = new Person("nene", 19, "女");

		List<Person> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		list.add(person5);
		list.add(person6);
		
		List<List<Person>> list2 = new ArrayList<>();
		
		list2.add(list);
		
		List<String> collect = list.stream().map(f->f.getName()).collect(Collectors.toList());
		
		List<String> collect2 = list2.stream().flatMap(f->f.stream().map(fu->fu.getName())).collect(Collectors.toList());
		
		
	}
}
