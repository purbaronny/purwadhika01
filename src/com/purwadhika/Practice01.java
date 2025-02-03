package com.purwadhika;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Practice01 {

	private static String DATE_FORMAT = "yyyy-MM-dd";
	private int radius;
	
	public long areaOfRectangle(int length, int width) {
		return length * width;
	}
	
	public double findDiameter(int radius) {
		this.radius = radius;
		return 2 * radius;
	}
	
	public double areaOfCircle() {
		return Math.PI * (Math.pow(radius, 2));
	}
	
	public float findAnglesOfTriangle(float value1, float value2) throws Exception {
		float value3 = 180 - value1 - value2;
		if(value3 < 0) {
			throw new Exception("This is not triangle");
		}
		return value3;
	}
	
	public long dateDateInDays(String value1, String value2)  throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		
		Date date1 = null;
		
		try {
			date1 = simpleDateFormat.parse(value1);
		} catch(ParseException pe) {
			throw new Exception("Cannot parse value1 to format[" + DATE_FORMAT +"]: " + value1);
		}
		
		LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();	
		
		
		Date date2 = simpleDateFormat.parse(value2);
		
		try {
			date2 = simpleDateFormat.parse(value2);
		} catch(ParseException pe) {
			throw new Exception("Cannot parse value1 to format[" + DATE_FORMAT +"]: " + value1);
		}
		
		LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		long result = ChronoUnit.DAYS.between(localDate2, localDate1);
		
		if(result < 0) {
			result *= -1;
		}
		return result;		
	}
	
	
	public String printInitialNameUppercase(String name) {
		if(name == null) {
			return null;
		}
		
		String[] initials = name.split(" ");
		
		String result = "";
		for(String initial : initials) {
			result += String.valueOf(initial.charAt(0)).toUpperCase();			
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Write a code to find area of rectangle");
		
		System.out.print("Input: ");
		System.out.print("length= ");
		
		int length = 0;
		boolean pass = true;
		try {
			length = scanner.nextInt();
		} catch(Exception e) {
			System.err.print("length should be integer");
			pass = false;
		}
		
		int width = 0;
		if(pass) {
			System.out.println(", width= ");
			try {
				width = scanner.nextInt();
			} catch(Exception e) {
				System.err.print("width should be integer");
				pass = false;
			}
		}
		
		Practice01 practice01 = new Practice01();
		if(pass) {
			System.out.println("Output: " + practice01.areaOfRectangle(length, width));
		}
		
		System.out.println("Write a code to find diameter, circumference\r\n"
				+ "and area of a circle");
		
		int radius = 0;
		pass = true;		
		try {
			System.out.print("Input: radius= ");
			radius = scanner.nextInt();
		} catch(Exception e) {
			System.err.print("radius should be integer");
			pass = false;
		}
		
		if(pass) {
			System.out.println("Output : diameter= " + practice01.findDiameter(radius) + ", circumference= " + Math.PI + ", area= " + practice01.areaOfCircle());
		}
		
		System.out.println("Write a code to find angles of triangle if two\r\n"
				+ "angles are given");
		
		
		float angle1 = 0;
		pass = true;		
		try {
			System.out.print("Input: a= ");
			angle1 = scanner.nextInt();
		} catch(Exception e) {
			System.err.print("angle1 should be integer");
			pass = false;
		}
		
		float angle2 = 0;
		if(pass) {
			try {
				System.out.print("b= ");
				angle2 = scanner.nextInt();
			} catch(Exception e) {
				System.err.print("angle2 should be integer");
				pass = false;
			}
		}
		
		if(pass) {
			try {
				System.out.println("Output: " + practice01.findAnglesOfTriangle(angle1, angle2));
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}			
		}
		
		System.out.println("Write a code to get difference between dates\r\n"
				+ "in days. (u can use java.time OR localDate\r\n"
				+ "package 😉)");
		
		
		Scanner	scanner2 = new Scanner(System.in);
		String date1 = "";
		pass = true;		
		try {
			System.out.print("Input: date1= ");
			date1 = scanner2.nextLine();
		} catch(Exception e) {
			System.err.print("date1 should be String");
			pass = false;
		}
		
		String date2 = "";
		if(pass) {
			try {
				System.out.print(", date2= ");
				date2= scanner2.nextLine();
				
			} catch(Exception e) {
				System.err.print("date2 should be String");
				pass = false;
			}
		}
		
		if(pass) {
			try {
				System.out.println("Output: " + practice01.dateDateInDays(date1, date2));
			} catch(Exception e) {
				System.err.print(e.getMessage());
			}			
		}		
		
		System.out.println("Write a code to print your name initial in\r\n"
				+ "uppercase");
		
		try {
			System.out.print("Input: ");
			String fullName = scanner2.nextLine();
			System.out.print("Output: " + practice01.printInitialNameUppercase(fullName));
		} catch(Exception e) {
			System.err.println("fullName should be String");
		}	
		
		scanner2.close();
		scanner2 = null;
		scanner.close();
		scanner = null;
		
	}
}
