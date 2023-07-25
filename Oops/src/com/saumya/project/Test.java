package com.saumya.project;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("---------HELLO EVERYONE---------");
		System.out.println("******************************");
		System.out.println("HELLO EVERYONE THIS IS SAUMYA");
		System.out.println("******************************");
		System.out.println("####MENU####");
		System.out.println("-----------------");
for (;;) {
			System.out.println("1. Factorial of a number.\n" + "2. Table of a number.\n" + "3. HCF of 2 number.\n"
					+ "4. LCM of 2 number.\n" + "5. Length of a number\n" + "6. Check a number amstrong or not.\n"
					+ "7. Check amstrong number in a range.\n" + "8. Check a number strong or not.\n"
					+ "9. Check strong number in a range.\n" + "10. Check a number perfect or not.\n"
					+ "11. Check perfect number in a range.\n" + "12. Check a number palindrome or not.\n"
					+ "13. Check palindrome number in a range.\n" + "14. Check a number prime or not.\n"
					+ "15. Check prime number in a range.\n" + "16. print alternative prime numers in a range.\n"
					+ "17. Convert decimal number to binary.\n" + "18. Convert binary number to decimal.\n"
					+ "19. Swap 2 numbers.\n");		

			Scanner scn = new Scanner(System.in);
			System.out.print("Enter your choice :");
			int c = scn.nextInt();
			switch (c) {
			case 1:
				System.out.println("Factorial of a number :");
				System.out.println("Enter a number :");
				int n1 = scn.nextInt();
				if (n1 < 0)
					System.out.println("No negatives plz");
				else
					System.out.println(n1 + "! = " + Programs.factorial(n1));
				break;
			case 2:
				System.out.println("Table of a number");
				System.out.println("Enter a number");
				int n2 = scn.nextInt();
				if (n2 <= 0)
					System.out.println("No negatives plz");
				else
					Programs.table(n2);
				break;
			case 3:
				System.out.println("HCF of 2 numbers :");
				System.out.println("Enter 2 numbers :");
				int n3 = scn.nextInt();
				int n4 = scn.nextInt();
				if (n3 <= 0 || n4 <= 0)
					System.out.println("No negatives plz");
				System.out.println("HCF of " + n3 + " and " + n4 + " = " + Programs.hcf(n3, n4));
				break;
			case 4:
				System.out.println("LCM of 2 numbers :");
				System.out.println("Enter 2 numbers :");
				int n5 = scn.nextInt();
				int n6 = scn.nextInt();
				if (n5 <= 0 || n6 <= 0)
					System.out.println("No negatives plz");
				System.out.println("LCM of " + n5 + " and " + n6 + " = " + Programs.lcm(n5, n6));
				break;
			case 5:
				System.out.println("Length of a number");
				System.out.println("Enter a number");
				int n7 = scn.nextInt();
				if (n7 <= 0)
					System.out.println("No negatives plz");
				System.out.println("Length of the " + n7 + " = " + Programs.length(n7));
				break;
			case 6:
				System.out.println("Check a number amstrong or not :");
				System.out.println("Enter a number :");
				int n8 = scn.nextInt();
				if (n8 <= 0)
					System.out.println("No negatives plz");
				else {

					if (n8 == Programs.amstrong(n8, Programs.length(n8)))
						System.out.println("Amstrong number");
					else
						System.out.println("Not amstrong number");
				}
				break;
			case 7:
				System.out.println("Check amstrong number in a range :");
				System.out.println("Enter range :");
				int n9 = scn.nextInt();
				int n10 = scn.nextInt();
				if (n9 <= 0 || n10 <= 0)
					System.out.println("No negatives plzz");
				else {
					for (int i = n9; i <= n10; i++)
						if (i == Programs.amstrong(i, Programs.length(i)))
							System.out.println(i);
				}
				break;
			case 8:
				System.out.println("Check a number strong or not :");
				System.out.println("Enter a number :");
				int n11 = scn.nextInt();
				if (n11 <= 0)
					System.out.println("No negatives plzz");
				else {
					if (n11 == Programs.strong(n11))
						System.out.println("Strong number");
					else
						System.out.println("Not strong number");
				}
				break;
			case 9:
				System.out.println("Check strong number in a range :");
				System.out.println("Enter the range :");
				int n12 = scn.nextInt();
				int n13 = scn.nextInt();
				if (n12 <= 0 || n13 <= 0)
					System.out.println("No negatives plzz");
				else {
					for (int i = n12; i <= n13; i++)
						if (i == Programs.strong(i))
							System.out.println(i);
				}
				break;
			case 10:
				System.out.println("Check a number perfect or not :");
				System.out.println("Enter a number :");
				int n14 = scn.nextInt();
				if (n14 <= 0)
					System.out.println("No negatives");
				else {
					if (n14 == Programs.perfect(n14))
						System.out.println("perfect number");
					else
						System.out.println("Not perfect number");
				}
				break;
			case 11:
				System.out.println("Check perfect number in a range :");
				System.out.println("Enter range :");
				int n15 = scn.nextInt();
				int n16 = scn.nextInt();
				if (n15 <= 0 || n16 <= 0)
					System.out.println("No negatives plzz");
				else {
					for (int i = n15; i <= n16; i++)
						if (i == Programs.perfect(i))
							System.out.println(i);
				}
				break;
			case 12:
				System.out.println("Check a number palindrome or not :");
				System.out.println("Enter a number :");
				int n17 = scn.nextInt();
				if (n17 <= 0)
					System.out.println("No negatives plzz");
				else {
					if (n17 == Programs.palindrome(n17))
						System.out.println("palindrome number");
					else
						System.out.println("Not palindrome number");
				}
				break;
			case 13:
				System.out.println("Check palindrome number in a range :");
				System.out.println("Enter range :");
				int n18 = scn.nextInt();
				int n19 = scn.nextInt();
				if (n18 <= 0 || n19 <= 0)
					System.out.println("No negatives plzz");
				else {
					for (int i = n18; i <= n19; i++)
						if (i == Programs.palindrome(i))
							System.out.println(i);
				}
				break;
			case 14:
				System.out.println("Check a number prime or not :");
				System.out.println("Enter a number :");
				int n20 = scn.nextInt();
				if (n20 <= 0)
					System.out.println("No negatives plzz");
				if (n20 == 1)
					System.out.println("1 is a special number");
				else {
					if (n20 == Programs.prime(n20))
						System.out.println("prime number");
					else
						System.out.println("Not prime number");
				}
				break;
			case 15:
				System.out.println("Check prime number in a range :");
				System.out.println("Enter range :");
				int n21 = scn.nextInt();
				int n22 = scn.nextInt();
				if (n21 <= 0 || n22 <= 0)
					System.out.println("No negatives plzz");
				else {
					for (int i = n21; i <= n22; i++)
						if (i == Programs.prime(i))
							System.out.println(i);
				}
				break;
			case 16:
				System.out.println("print alternative prime number in a range :");
				System.out.println("Enter range :");
				int n23 = scn.nextInt();
				int n24 = scn.nextInt();
				int count = 0;
				if (n23 <= 0 || n24 <= 0)
					System.out.println("No negatives plzz");
				else {
					for (int i = n23; i <= n24; i++)
						if (i == Programs.prime(i)) {
							count++;
							if (count % 2 != 0)
								System.out.println(i);
						}
				}
				break;
			case 17:
				System.out.println("Convert decimal number to binary :");
				System.out.println("Enter a decimal number :");
				int n25 = scn.nextInt();
				if (n25 <= 0)
					System.out.println("No negatives plzz");
				else
					Programs.DecimalToBinary(n25);

				break;
			case 18:
				System.out.println("Convert binary number to decimal :");
				System.out.println("Enter a binary number :");
				int n26 = scn.nextInt();
				if (n26 <= 0)
					System.out.println("No negatives plzz");
				else
					Programs.BinaryToDecimal(n26);
				break;
			case 19:
				System.out.println("Swap 2 nos :");
				System.out.println("Enter 2 numbers :");
				int n27 = scn.nextInt();
				int n28 = scn.nextInt();
				if (n27 <= 0 || n28 <= 0)
					System.out.println("No negatives plzz");
				else
					Programs.swap(n27, n28);
				break;

			default:
				System.out.println("Invalid Input,plz enter a valid Input");
				break;

			}

			System.out.println("Do you want to continue :y/n");
			char ch = scn.next().charAt(0);
			if (ch == 'y')
				continue;
			else {
				System.out.println("THANK U ........!");
				System.out.println("VISIT AGAIN...........!");
				break;
			}
		}
	}
}
