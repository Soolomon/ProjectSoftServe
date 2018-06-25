package com.softserve.lookingRegex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		String name;
		int age;
		boolean sex;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter you name");
		name = reader.readLine();
		System.out.println("How old are you");
		age = Integer.parseInt(reader.readLine());
		System.out.println("Choise your gender [0] Man [1] Woman");
		sex = Boolean.parseBoolean(reader.readLine());
		User user = new User(name, age, sex);
		user.choise();
		Movie.pickUpFilms(user);
		for (int i = 0; i < Source.getSource().size(); i++)
			System.out.println(Source.getSource().get(i));
	}
}
