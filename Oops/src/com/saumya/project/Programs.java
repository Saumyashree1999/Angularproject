package com.saumya.project;

public class Programs {

	public static int factorial(int n) {
		if (n == 0 || n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static void table(int n) {
		for (int i = 1; i <= 10; i++)
			System.out.println(n + " X " + i + " = " + (n * i));

	}

	public static int hcf(int n1, int n2) {
		int hcf = 0;
		int a = (n1 < n2) ? n1 : n2;
		for (int i = 1; i <= a; i++) {
			if (n1 % i == 0 && n2 % i == 0)
				hcf = i;
		}
		return hcf;
	}

	public static int lcm(int n1, int n2) {
		int lcm = 0;
		int m = (n1 > n2) ? n1 : n2;
		for (int i = m; i >= m; i++) {
			if (i % n1 == 0 && i % n2 == 0) {
				lcm = i;
				break;
			}
		}
		return lcm;
	}

	public static int length(int num) {
		int count = 0;
		while (num > 0) {
			count++;
			num /= 10;
		}
		return count;
	}

	public static int strong(int n) {
		if (n == 0)
			return 0;
		return factorial(n % 10) + strong(n / 10);
	}

	public static int amstrong(int n, int pow) {
		if (n == 0)
			return 0;
		return (int) Math.pow(n % 10, pow) + amstrong(n / 10, pow);
	}

	public static int perfect(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0)
				sum += i;
		}
		return sum;
	}

	public static int palindrome(int n) {
		int store = n;
		int rev = 0;
		while (n > 0) {
			rev = (rev * 10) + (n % 10);
			n /= 10;
		}
		return rev;
	}

	public static int prime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return 0;
		}
		return n;
	}

	public static void BinaryToDecimal(int n) {
		int dec = 0, i = 1;
		int s = n;
		while (n > 0) {
			dec += i * (n % 10);
			n /= 10;
			i *= 2;
		}
		System.out.println("Decimal of " + s + " = " + dec);
	}

	public static void DecimalToBinary(int n) {
		int bin = 0, i = 1;
		int s = n;
		while (n > 0) {
			bin += i * (n % 2);
			n /= 2;
			i *= 10;
		}
		System.out.println("Binary of " + s + " = " + bin);
	}

	public static void swap(int i, int j) {
		System.out.println("no before swapping = " + i + " & " + j);
		int k = i + j;
		i = k - i;
		j = k - i;
		System.out.println("no after swapping = " + i + " & " + j);
	}
}
