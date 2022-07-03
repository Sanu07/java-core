package com.java.date.api;

import java.time.LocalDate;

public class JavaDateAPI {
	public static void main(String[] args) {
		new JavaDateAPI().checkDate(LocalDate.now(), "sales123");
	}

	public int checkDate(LocalDate localDate, String salesId) {
		return getActiveResetCountVendor(localDate, salesId);
	}

	private int getActiveResetCountVendor(LocalDate localDate, String salesId) {
		System.out.println(localDate);
		System.out.println(salesId);
		System.out.println(localDate.toString().length() + salesId.length());
		return localDate.toString().length() + salesId.length();
	}
	
	
}
