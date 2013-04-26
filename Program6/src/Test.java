public class Test {
	
	public static void main(String[] args) {
		int[] array = new int[5];
		array[0] = 10;
		array[1] = 5;
		array[2] = 1;
		array[3] = 3;
		array[4] = 7;
		
		System.out.println(Utilities.subsetSum(array,5,12));
	}
}