package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
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

//		String[] str = { "adsfdsagaewerhytiuughgh", "rhytiuu", "fdsag", "werhytiuughg", "adsfdsagaew" };
//
//		list.stream().filter(f -> f.getSex().equals("男")).forEach(System.out::println);
//		list.stream().map(f -> {
//			f.setName("wang-" + f.getName());
//			return f;
//		}).forEach(System.out::println);
//		Integer integer = list.stream().map(f -> f.getAge()).reduce((a, b) -> a + b).get();
//		System.out.println(integer);
//
//		
//		boolean bool = list.stream().allMatch(f -> f.getAge() != 16);
//		boolean boo = list.stream().anyMatch(f -> f.getAge() != 18);
//		Map<String, Integer> collect = list.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
//		
		//Arrays.stream(str).map(f -> f.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

		// System.out.println(collect);
		
		String str1 = "adsfdsagaewerhytiuughgh";
		Stream.of(str1).map(f->f.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
		
		//Stream.of(str1).map(f->f.split("")).collect(supplier, accumulator, combiner);
		
	}

	public static <T> boolean getStatus(T t) {
		try {
			Object obj = t.getClass().newInstance();

			Object o = t.getClass().getMethod("get").invoke(obj);
			System.out.println(o);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
