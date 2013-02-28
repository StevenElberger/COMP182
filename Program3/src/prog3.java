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
		return maxBlock(a,0,size-1);
	}
	
	public static String myName() {
		String name = "Steven Elberger";
		return name;
	}
	
	public static int maxBlock(int[] b, int LF, int RT) {
		int mid, lfMax, rtMax, result;
		// Base cases
		if (LF == RT-1) {
			// If there are only 2 elements in the array
			if (b[LF] >= 0) {
				if (b[RT] >= 0) {
					return (b[LF] + b[RT]);
				} else {
					return b[LF];
				}
			} else if (b[RT] >= 0) {
				return b[RT];
			} else if (b[LF] >= b[RT]) {
				return b[LF];
			} else {
				return b[RT];
			}
		} else if (LF == RT) {
			// If there is only 1 element in the array
			return b[LF];
		}
		/* What do you do when an array is null? Throw exception instead?
		else if (b == null) {
			// Empty array returns 0
			return 0;
		}
		*/
		
		// Find middle of block
		mid = ((LF + RT) / 2);
		
		//-- Debugging only-- System.out.println("Section A - LF: " + LF + " | RT: " + RT + " | mid: " + mid);
		lfMax = maxBlock(b, LF, mid-1);
		//-- Debugging only-- System.out.println("Section B - LF: " + LF + " | RT: " + RT + " | mid: " + mid + " | lfMax: " + lfMax);
		rtMax = maxBlock(b, mid+1, RT);
		//-- Debugging only-- System.out.println("Section C - LF: " + LF + " | RT: " + RT + " | mid: " + mid + " | lfMax: " + lfMax + " | rtMax: " + rtMax);
		
		int leftMid, midRight, midMax, sum;
		leftMid = Integer.MIN_VALUE;	// Use MIN_VALUE so that program can handle the smallest int possible
		sum = 0;
		// Sum from left to mid
		for (int i = mid; i >= LF; i--) {
			sum += b[i];
			if (sum > leftMid) {
				leftMid = sum;
				if (leftMid > lfMax) {
					lfMax = leftMid;
				}
			}
		}
		midRight = Integer.MIN_VALUE;
		sum = 0;
		// Sum from mid to right
		for (int j = mid+1; j <= RT; j++) {
			sum += b[j];
			if (sum > midRight) {
				midRight = sum;
				if (midRight > rtMax) {
					rtMax = midRight;
				}
			}
		}
		// Largest sum spanning whole array
		midMax = leftMid + midRight;
		//-- Debugging only-- System.out.println("Section D - lfMax: " + lfMax + " | rtMax: " + rtMax + " | midMax: " + midMax);
		result = 0; // compiler needs to be happy
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
		return result;	// return Math.max(lfMax, Math.max(rtMax,midMax))
	}
}