class Utilities {
	
	public static boolean subsetSum(int[] a, int n, int goal) {
		// IntStack s = new IntStack();
		// int index;
		// s.push(0);
		// goal -= a[0];
		/*
		while (goal != 0 && !s.empty()) {
			index = s.top();
			if (goal < 0) {
				s.pop();
				goal += a[index];
				if (index < n-1) {
					s.push(index + 1);
					goal -= a[index + 1];
				} else {
					if (!s.empty()) {
						// advance the element that is currently on top of the stack
					}
				}
			} else {
				if (index < n - 1) {
					s.push(index + 1);
					goal -= a[index + 1];
				} else {
					s.pop();
					goal += a[index];
					if (!s.empty()) {
						// advance the element that is currently on top of the stack
					}
				}
			}
		}
		*/
		return goal == 0;
	}
}

class IntStack {
	int[] s;
	int size = 50;
	int topIndex;
	
	IntStack() {
		topIndex = -1;
		s = new int[size];
	}
}