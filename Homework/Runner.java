package homework2;

import java.util.Arrays;

public class Runner {

	static int num = 99;

	public static void main(String[] args) {

		int[] mass = new int[20];

		System.out.println("Unsorted array: ");
		for (int a = 0; a < mass.length; a++) {
			mass[a] = (int) (Math.random() * 100);
			System.out.print(mass[a] + " ");
		}

		System.out.println();

		Arrays.sort(mass);
		System.out.println("Sorted array: ");
		for (int a = 0; a < mass.length; a++) {
			System.out.print(mass[a] + " ");
		}

		System.out.println();

		BinarySearch myClass = new BinarySearch(mass);
		int result = myClass.finder(num);

		if (result == num) {
			System.out.println("Number " + num + " presents in the array.");
		} else {
			System.out.println("Number " + num + " is absent.");
			System.out.println("The next number after searched is: " + result
					+ ".");
		}
	}

}
