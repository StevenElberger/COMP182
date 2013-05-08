public class Test {

    public static void main(String[] args) {
        int a[] = {15, 6, 13, 17, 5, 11, 9, 4};
        int goal[] = {3, 8, 13, 15, 16, 18, 19, 20, 25, 30, 40, 50, 60, 68, 70, 72, 85, 90 };
        for (int i = 0; i < goal.length; i++) {
            System.out.println("Goal: " + goal[i]);
            if (Utilities.subsetSum(a, a.length, goal[i]))
                System.out.println("There is a solution.");
            else
                System.out.println("No solution.");
            //if (Utilities.subsetSumR(a, a.length, goal[i]))
            //    System.out.println("There is a solution -- recursive.");
            //else
            //    System.out.println("No solution -- recursive.");
        }
        int b[] = {150, 68, 132, 173, 58, 112, 93, 47, 93, 101, 87, 44, 75, 142, 143, 126, 137, 111, 134, 188, 154, 153};
        int goalb[] = {263, 290, 303, 1111, 1687, 2325, 2462, 2463, 2473, 2474, 2521, 2522};
        for (int i = 0; i < goalb.length; i++) {
            System.out.println("Goal: " + goalb[i]);
            if (Utilities.subsetSum(b, b.length, goalb[i]))
                System.out.println("There is a solution.");
            else
                System.out.println("No solution.");
            //if (Utilities.subsetSumR(b, b.length, goalb[i]))
            //    System.out.println("There is a solution -- recursive.");
            //else
            //    System.out.println("No solution -- recursive.");
        }
    }

}
/*
public class Test {
	
	public static void main(String[] args) {
		int[] array = new int[5];
		array[0] = 10;
		array[1] = 5;
		array[2] = 1;
		array[3] = 3;
		array[4] = 7;
		
		System.out.println(Utilities.subsetSum(array,5,25));
	}
}
*/