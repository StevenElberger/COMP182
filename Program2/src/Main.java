
public class Main {
	public static void main(String[] args) {
		BigInt x = new BigInt("99999999999999999999999999999999999999999999999999");		// 23462457 / 257474
		System.out.println("x is: " + x);
		BigInt y = new BigInt("99999999999999999999999999999999999999999999999999");
		System.out.println("y is: " + y);
		//BigInt z = new BigInt(x);
		//System.out.println("z is: " + z);
		System.out.println(x.compareTo(y));
		System.out.println(x.plus(y));
		System.out.println(x.times(y));
	}
}