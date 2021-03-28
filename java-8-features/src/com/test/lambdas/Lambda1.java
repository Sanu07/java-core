package com.test.lambdas;

import java.util.Arrays;

@FunctionalInterface
interface I1 {
	void i1();
}

class C1 {
	public void c1() {
		System.out.println("C1-c1");
	}
}

class C2 {
	public void c2() {
		System.out.println("C2-c2");
	}
}

public class Lambda1 {
	public static void main(String[] args) {
		I1 i11 = () -> System.out.println("Hello");
		I1 i1 = new C2()::c2;
		i1.i1();
		
		int arr[] = new int[3];
		arr[0] = 2;
		arr[1] = 3;
		arr[2] = 1;
		int x = 5;
		sortArr(arr, x);
		System.out.println(Arrays.toString(arr));
		System.out.println(x);
	}

	private static void sortArr(int[] arr, int x) {
		Arrays.sort(arr);
		x = 10;
	}
}
