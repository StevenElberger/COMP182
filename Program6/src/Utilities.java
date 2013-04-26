class Utilities {
	// n = # elements in a
	public static boolean subsetSum(int[] a, int n, int goal) {
		IntStack s = new IntStack();
		int index;	// Index of which number in the array is on the bottom of the stack
		s.push(0);	// Stack only holds array indices, NOT values!
		goal -= a[0];
		// If goal == 0, we've found the subset sum
		// If stack is empty, ...
		while (goal != 0 && !s.empty()) {
			// The index is the last item to be put on the stack
			System.out.println(s.top() + " New Loop");
			index = s.top();
			if (goal < 0) {		// The sum is too much!
				System.out.println(s.top() + " B - GOAL: " + goal);
				// Remove whatever was last on the stack because
				// it sent us over the goal
				s.pop();
				// Restore goal back to what it was before we pushed that index on
				goal += a[index];
				// If we're not at the last element in the array
				if (index < n-1) {
					// Let's try the next element in the array!
					s.push(index + 1);
					goal -= a[index + 1];
				} else {
					// If stack is empty, we're boned
					// Otherwise, we need to advance the element on s.top()
					if (!s.empty()) {
						// advance the element that is currently on top of the stack
						System.out.println(s.top() + " - " + goal + " - " + index);
						s.pop();
						goal += a[index-1];
						System.out.println(s.top() + " - " + goal);
						s.push(index - 2);
						goal -= a[index - 2];
						System.out.println(s.top() + " - " + goal);
					}
				}
			} else {	// We're still good... Keep adding!
				System.out.println(s.top() + " C - GOAL: " + goal);
				if (index < n - 1) {	// Haven't reached the last index yet!
					// Try the next index!
					s.push(index + 1);
					goal -= a[index + 1];
				} else {	// We've reached the last index!
					System.out.println(s.top() + " D - GOAL: " + goal);
					// Pop it off!
					s.pop();
					goal += a[index];
					if (!s.empty()) {
						// advance the element that is currently on top of the stack
						s.pop();
						goal += a[index-1];
						s.push(index);
					}
				}
			}
		}
		return goal == 0;
	}
}

class IntStack {
	int[] sArray;
	int topIndex;
	
	public IntStack() {
		sArray = new int[50];
		topIndex = -1;
	}
	
	public int top() {
		return sArray[topIndex];
	}
	
	public void pop() {
		if (topIndex > -1) {
			topIndex--;
		}
	}
	
	public boolean empty() {
		return topIndex == -1;
	}
	
	public void push(int x) {
		if (topIndex < 50) {
			topIndex++;
			sArray[topIndex] = x;
		}
	}
}