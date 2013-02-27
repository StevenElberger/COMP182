/*
This is the output my program produces:

First BigInt: 765423122
Next BigInt: 3141592653589793238462643383279502884197169
Result 0: 76159080909572301618801306271765994056795952743
Result 1: 76159080909572301618801306271765994056795952743
Result 2: 275546143282785844218295114048973991262329549079
Result 3: 474933205655999386817788921826181988467863145415
Result 4: 674320268029212929417282729603389985673396741751
Result 5: 873707330402426472016776537380597982878930338087
Result 6: 1073094392775640014616270345157805980084463934423
Result 7: 1272481455148853557215764152935013977289997530759
Result 8: 1471868517522067099815257960712221974495531127095
Result 9: 1671255579895280642414751768489429971701064723431

*/

public class testplus {
	public static void main(String[] args) {
		int ct;
		BigInt num1, num2, sum;
		sum = new BigInt(0);  // make the compiler happy
		System.out.println("First BigInt: " + new BigInt(765423122));
		System.out.println("Next BigInt: " + new BigInt("3141592653589793238462643383279502884197169"));
		num1 = new BigInt(1);
		num2 = new BigInt(0);
		num2 = num1.plus(num2);
		num1 = new BigInt(0);
		for (int i = 0; i < 10; i++) {
			for (ct=1; ct <= 225 ; ct++) {
				sum = num1.plus(num2);
				num1 = new BigInt(num2);
				num2 = new BigInt(sum);
			}
			System.out.println("Result " + i + ": " + sum);
			num1 = new BigInt(i);
			num2 = new BigInt(2*i + 1);
		}
	}
}