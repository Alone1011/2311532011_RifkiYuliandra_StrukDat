package pekan_1;

import java.util.ArrayList;

public class arrayList1 {

	public static void main(String[] args) {
		// Size of the ArrayList
		int n = 5;
		// Declaring the ArrayList with initial size n
		ArrayList<Integer> arrli = new ArrayList<Integer> (n);
		// Appending new elements at the and of the list
		for (int i = 1; i <= n; i++) {
			arrli.add(i);
		}
		// Printing element
		System.out.println(arrli);
		// Remove element at index 3
		arrli.remove(3);
		// Displaying the ArrayList
		// after delection
		System.out.println(arrli);
		for (int i = 0; i < arrli.size(); i++) {
			System.out.print(arrli.get(i) + " ");
		}
	}

}
