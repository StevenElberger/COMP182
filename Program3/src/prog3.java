/* Steven Elberger
 * Assignment 3
 * February 18 - February 26
 * Description: Displays the sum of the maximum block of consecutive integers in an array of integers including negatives.
 */
import java.util.Random;	// TESTING PURPOSES ONLY
class Utilities {
	
	public static void main(String[] args) {
		// Create a new int array with 10 elements
		// only load the array up to its size
		int max = 50;
		int size = 3;
		int[] arrayInt = new int[max];
		
		// Populate the array with random ints
		// with values -10 to 10
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			arrayInt[i] = (int) (rand.nextInt(20)-10);
			System.out.print(arrayInt[i] + " ");
		}
		
		System.out.println();
		System.out.println("Result: " + maxBlock(arrayInt,3));
	}
	
	public static int maxBlock(int[] a, int size) {
		int sum = 0;
		if (size > 0) {
			sum = maxBlock(a,0,size-1);
		}
		return sum;
	}
	
	public static String myName() {
		String name = "Steven Elberger";
		return name;
	}
	
	private static int maxBlock(int[] array, int LF, int RT) {
		int result;
		// Base cases
		if (LF == RT-1) {
			// If there are only 2 elements in the array
			if (array[LF] >= 0) {
				if (array[RT] >= 0) {
					result = (array[LF] + array[RT]);
				} else {
					result = array[LF];
				}
			} else if (array[RT] >= 0) {
				result = array[RT];
			} else if (array[LF] >= array[RT]) {
				result = array[LF];
			} else {
				result = array[RT];
			}
		} else if (LF == RT) {
			// If there is only 1 element in the array
			result = array[LF];
		} else {
			int midMax, sum, mid, lfMax, rtMax;
			// Find middle of block
			mid = ((LF + RT) / 2);
			
			lfMax = maxBlock(array, LF, mid-1);
			rtMax = maxBlock(array, mid+1, RT);
			
			Integer lfSum = null;
			sum = 0;
			// Sum from left to mid
			for (int i = mid; i >= LF; i--) {
				sum += array[i];
				if (lfSum == null || (lfSum != null && sum > lfSum.intValue())) {
					lfSum = sum;
					if (lfSum > lfMax) {
						lfMax = lfSum;
					}
				}
			}
			Integer rtSum = null;
			sum = 0;
			// Sum from mid to right
			for (int j = mid+1; j <= RT; j++) {
				sum += array[j];
				if (rtSum == null || (rtSum != null && sum > rtSum.intValue())) {
					rtSum = sum;
					if (rtSum > rtMax) {
						rtMax = rtSum;
					}
				}
			}
			// Largest sum spanning whole array
			midMax = lfSum + rtSum;	// midMax = leftMid + midRight;
			// Return the largest sum
			if (lfMax >= rtMax) {
				if (lfMax >= midMax) {
					result = lfMax;
				} else {
					result = midMax;
				}
			} else if (rtMax >= midMax) {
				result = rtMax;
			} else {
				result = midMax;
			}
		}
		return result;
	}
}