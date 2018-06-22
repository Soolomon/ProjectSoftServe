package com.softserve.looking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInterface {
public static void createUser() throws IOException {
	String name;
	int age;
	boolean sex=true;
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Hello. Welcome!\nPlease enter your name:");
	name=reader.readLine();
	System.out.println("Good! "+name+"! ");
	System.out.println("How old are you?");
	age= Integer.parseInt(reader.readLine());
	System.out.println("You [1]Man or [2]Woman please choise ");
	switch(Integer.parseInt(reader.readLine())) {
	case 1:
		sex=true;
		break;
	case 2:
		sex=false;
		break;
		
	}
	User user=new User(name,age,sex);
}
}
