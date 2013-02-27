/* Steven Elberger
 * Assignment 2
 * February 7 - February 7
 * Description: Creates objects via ints or strings in constructor, loads ints into an array - one digit per index in the array.
 * Also capable of adding, multiplying, and comparing two objects' values.
 * 4 Constructors: Default, String, int, and BigInt (copy constructor)
 */
class BigInt {
	
	private int digit[]; // represent the integer as an array of digits
	private int size; // number of digits in the integer
	private final int max = 50; // maximum number of digits in the integer
	
	public BigInt() { // default constructor
	}
	
	public BigInt(String num) { // constructor with initial String value
		// Load digit[] by parsing through the string
		size = num.length();
		digit = new int[max];
		for (int ct = size - 1; ct >= 0; ct --) {
			digit[ct] = Integer.parseInt(num.substring(size - ct - 1, size - ct));
		}
	}
	
	public BigInt(int num) { // constructor with initial integer value
		// Log base 10 - divide by 10 until you reach 0
		// Parse through digit[] by 'modding' num by 10
		// Then divide by 10 to take off the right-most digit
		int numLength = 0;
		int temp = num;
		while (temp > 0) {
			numLength = numLength + 1;
			temp = temp / 10;
		}
		size = numLength;
		digit = new int[max];
		for (int ct = 0; ct <= size - 1; ct++) {
			digit[ct] = num % 10;
			num = num / 10;
		}
	}
	
	public BigInt(BigInt num) { // copy constructor
		// Set this BigInt's int array equal to num's
		size = num.size;
		digit = new int[max];
		for (int ct = 0; ct <= size - 1; ct++) {
			this.digit[ct] = num.digit[ct];
		}
	}
	
	public String toString() { // override Object’s version
		// Call String's valueOf method, load digit[ct]'s value into intString
		String intString = "";
		for (int ct = size - 1; ct >= 0; ct --) {
			intString = intString + String.valueOf(digit[ct]);
		}
		return intString;
	}
	
	public int compareTo(BigInt other) {
		// return 1 if this greater than other
		// return -1 if this less than other
		// return 0 if both equal
		int comparison = 2;		// initialized for compiler
		int ct = this.size - 1;
		if (this.size > other.size) {
			comparison = 1;
		} else if (this.size < other.size) {
			comparison = -1;
		} else {
			// if arrays have the same size and the arrays still have another digit left
			while ((comparison > 1) && (ct >= 0)) {
				if (this.digit[ct] > other.digit[ct]) {
					comparison = 1;
				} else if (this.digit[ct] < other.digit[ct]) {
					comparison = -1;
				// if the last digits are equal to each other, both arrays are the same
				} else if ((ct == 0) && (this.digit[ct] == other.digit[ct])) {
					comparison = 0;
				}
				ct = ct - 1;
			}
		}
		return comparison;
	}
	
	public BigInt plus(BigInt arg) { // add two BigInts
		BigInt sum = new BigInt(0);
		// Use an int variable to hold the added values
		// Before storing them in sum.digit[]
		int sumInt, biggerArray;
		boolean needCarry = false;
		// Find which array has a larger size
		// Use that size to loop through
		if (this.compareTo(arg) <= 0) {
			biggerArray = arg.size;
		} else {
			biggerArray = this.size;
		}
		for (int ct = 0; ct < biggerArray; ct++) {
			sumInt = this.digit[ct] + arg.digit[ct];
			// If the last added values were bigger than 10
			// Add one to the value of sumInt
			if (needCarry == true) {
				sumInt += 1;
				needCarry = false;
			}
			// If sumInt is bigger than 10, take rightmost digit
			// and store it into sum.digit[ct]
			// we will need a carry for next time
			sum.size += 1;
			if (sumInt >= 10) {
				sum.digit[ct] = sumInt % 10;
				needCarry = true;
				if (sum.size == biggerArray) {
					// If the size is 50, call times10 to increase digit's size
					// add the carry to the final space in digit
					sum.times10();
					sum.size += 1;
					sum.digit[ct+1] = 1;
				}
			} else {
				sum.digit[ct] = sumInt;
			}
		}
		return sum;
	}
	
	public BigInt times(BigInt other) { // multiply two BigInts
		// Find which array has a larger size
		// Use this information to set up loops
		BigInt bigger, smaller;
		if (this.compareTo(other) <= 0) {
			bigger = other;
			smaller = this;
		} else {
			bigger = this;
			smaller = other;			
		}
		// Use answer array to temporarily hold values
		// Before storing them into digit
		int[] answer = new int[bigger.size];
		int productInt = 0;
		int carry = 0;
		// Call default constructor because we
		// initialize product's digit array explicitly
		// product's size will be trimmed towards the end
		BigInt product = new BigInt();
		product.size = bigger.size*2;
		product.digit = new int[product.size];
		// Multiply the digit in the smaller number
		// By every digit in the bigger number
		// Add the answer one digit at a time to digit array
		// Then move to the next digit in the smaller number and repeat
		for (int i = 0; i < smaller.size; i++) {
			for (int j = 0; j < bigger.size; j++) {
				// Multiply the two numbers and add the carry
				// Store rightmost digit in answer array
				productInt = smaller.digit[i] * bigger.digit[j] + carry;
				answer[j] = productInt % 10;
				// If the answer was bigger than 10,
				// set the carry's value to the left digit
				if (productInt >= 10) {
					carry = productInt / 10;
				} else {
					carry = 0;
				}
				// If this is the rightmost digit in the smaller number
				// store answer's value in the same index for digit
				if (i == 0) {
					product.digit[j] = answer[j];
					// If this is the last digit in the bigger number
					// and there is a carry remaining
					// store it in the next index of digit array
					if ((j == bigger.size - 1) && (carry != 0)) {
						product.digit[j+1] = carry;
						carry = 0;
					}
				// Otherwise, always add answer's value
				} else {
					// need to add i to j for placeholders
					product.digit[j+i] += answer[j];
					// if you add the value and it's bigger than 10
					// carry the 1 over to the next index
					if (product.digit[j+i] >= 10) {
						product.digit[j+i+1] += 1;
						product.digit[j+i] = product.digit[j+i] % 10;
					}
					// if this is the last digit in the bigger number
					// and there is a carry remaining
					// store it in the next index of digit
					if ((j == bigger.size - 1) && (carry != 0)) {
						product.digit[j+i+1] += carry;
						carry = 0;
					}
				}
			}
		}
		// If product.digit has leading 0s
		// Remove them by shrinking product's size
		// Once we find a non-zero int, stop
		boolean arrivedAtInt = false;
		int k = product.size - 1;
		while ((!arrivedAtInt) && (product.digit[k] == 0)) {
			if (k > 0) {
				product.size -= 1;
				k -= 1;
			} else {
				arrivedAtInt = true;
			}
		}
		return product;
	}
	
	private void times10() {
		// Create a temp int array with size max + 1
		// Copy values from digit array to temp array
		// Set digit array equal to a new array with size max + 1
		// Copy values back into digit array
		int[] newdigit = new int[this.max + 1];
		for (int ct = this.size - 1; ct >= 0; ct--) {
			newdigit[ct] = this.digit[ct];
		}
		this.digit = new int[this.max + 1];
		for (int ct = newdigit.length - 1; ct >= 0; ct--) {
			this.digit[ct] = newdigit[ct];
		}
	}
}