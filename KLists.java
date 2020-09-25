// Jacelle Sarangelo
// CS245-02
import java.util.*;

public class KLists {
	public double[] mergeKLists(double[][] outerArray) {
		// stores the final array
		double[] list = {};

		// loop thru outer array, then call merge function
		for(int i = 0; i < outerArray.length; i++) {
			list = merge(list, outerArray[i]);
		}
		return list;
	}

	public double[] merge(double[] l, double[] r) {
		int j = 0, left = 0, right = 0;
		// stores sorted array
		double[] list = new double[l.length + r.length];

		// while the left side of the array is less than the left length
		// and vice versa for the right side
		// check if the left value is less than or equal to the right value
		while(left < l.length && right < r.length) {
			if (l[left] <= r[right]) {
				// if it is, then add that value into the array at that index
				list[j] = l[left];
				left++;
			}
			// else if the right value is less than or equal to the left value
			// then add that value into the array at that index
			else {
				list[j] = r[right];
				right++;
			}
			j++;
		}

		// while the left index is less than the length of the left
		// set the value of j in the list to the left value
		// keep incrementing to go thru entire list
		while(left < l.length) {
			list[j] = l[left];
			j++;
			left++;
		}
		// while the right index is less than the length of the right
		// set the value of j in the list to the right value
		// keep incrementing to go thru entire list
		while (right < r.length) {
			list[j] = r[right];
			j++;
			right++;
		}
		// return that list
		return list;
	}

	public static void main(String[] args) {
		KLists l = new KLists();

		double[][] a1 = { {1.1, 4,4, 5,5}, {1.1, 3.3, 4.4}, {2.2, 6.6} };
		System.out.println(Arrays.toString(l.mergeKLists(a1)));
		System.out.println();

		double[][] a2 = {};
		System.out.println(Arrays.toString(l.mergeKLists(a2)));
		System.out.println();

		double[][] a3 = { {} };
		System.out.println(Arrays.toString(l.mergeKLists(a3)));
		System.out.println();

		double[][] a4 = { {9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27} };
		System.out.println(Arrays.toString(l.mergeKLists(a4)));
		System.out.println();
	}
}