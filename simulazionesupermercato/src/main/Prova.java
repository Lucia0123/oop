package main;

import java.time.LocalDate;

public class Prova {

	public static void main(String[] args) {
		LocalDate a = LocalDate.EPOCH;
		a = a.plusDays(40);
		LocalDate b = LocalDate.MAX;
		LocalDate c = LocalDate.MIN;
		LocalDate d = LocalDate.now();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}
