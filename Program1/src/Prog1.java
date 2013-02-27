/* Steven Elberger
 * Assignment 1
 * January 29 - January ?
 * Description: 
 */
public class Prog1 {
	
	// Reverses an integer. For example, 34 returns 43, 478 returns 874, 22 returns 22, and
	// -63 returns -36.
	static int reverse(int num) {
		int revNum = 0;
		while(num != 0) {
			revNum = revNum * 10 + num % 10;
			num = num / 10;
		}
		return revNum;
	}
	
	// Returns the sum of all of the divisors. For example, 7 returns 8 and 28 returns 56.
	static int divisorSum(int num) {
		int sum = 1;
		for (int i = 2; i < num*num; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	// Decide if the integer is some power of some other integer. For example, 8, 49, and 81
	// return true while 10, 28, and 2 return false. (What should 0 and 1 return?)
	static boolean isPower(int num) {
		int temp = num;
		boolean isPower = false;
		for (int i = 2; i < temp; i++) {
			num = temp;
			while (num % i == 0) {
				num = num / i;
				if (num == 1) {
					isPower = true;
				}
			}
		}
		//if ((temp == 1) || (temp == 2)) {
		//	isPower = false;
		//}
		return isPower;
	}
	
	// Calculate the integer log base of. Do this by repeatedly dividing by 2 and counting.
	// For example, 2 and 3 return 1. 4, 5, 6, and 7 return 2. 80 and 100 return 6.
	static int intLog(int num) {
		int base = -1;
		while (num > 0) {
			num = num / 2;
			base += 1;
		}
		return base;
	}
}
