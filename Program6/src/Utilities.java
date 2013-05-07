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
			index = s.top();
			if (goal < 0) {		// The sum is too much!
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
					// We need to advance the element on s.top()
					if (!s.empty()) {
						// advance the element that is currently on top of the stack
						int top = s.top();
						s.pop();
						goal += a[top];
						s.push(top + 1);
						goal -= a[top + 1];
					}
				}
			} else {	// We're still good... Keep adding!
				if (index < n - 1) {	// Haven't reached the last index yet!
					// Try the next index!
					s.push(index + 1);
					goal -= a[index + 1];
				} else {	// We've reached the last index!
					// Pop it off!
					s.pop();
					goal += a[index];
					if (!s.empty()) {
						// advance the element that is currently on top of the stack
						int top = s.top();
						s.pop();
						goal += a[top];
						s.push(top + 1);
						goal -= a[top + 1];
					}
				}
			}
		}
		if (!s.empty()) {
			while (!s.empty()) {
				System.out.print(a[s.top()] + " ");
				s.pop();
			}
		}
		System.out.println();
		return goal == 0;
	}
	
	public boolean subsetSumR(int[] a, int goal) {
		return subsetSumR(a,a.length,goal);
	}
	
	private static boolean subsetSumR(int[] a, int n, int goal) {
		boolean result;
		if (goal == 0) {
			result = true;
		} else if (goal < 0) {
			result = false;
		} else {
			result = false;
		}
		return result;
	}
	
	public static void outputStack(IntStack stackA, int g, int ind) {
		IntStack b = new IntStack();
		if (!stackA.empty()) {
			while (!stackA.empty()) {
				System.out.print(stackA.top() + " ");
				b.push(stackA.top());
				stackA.pop();
			}
			System.out.print("--- GOAL: " + g + " --- INDEX: " + ind + " --- ");
			while (!b.empty()) {
				stackA.push(b.top());
				b.pop();
			}
		}
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