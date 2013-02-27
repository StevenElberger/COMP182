import java.io.*;    // for BufferedReader

public class test {

   public static void main(String[] args) throws IOException {
      BigInt num1, num2;
      BigInt nineninenine = new BigInt(999);
	  BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in) );
      num1 = new BigInt(987654321);
      num2 = new BigInt("56789123456789123456789");
      while (num1.compareTo(nineninenine) != 0) {
	         if (num1.compareTo(num2) == 1) {
	            System.out.println(num1 + " is bigger.");
	         }
	         else if (num1.compareTo(num2) == -1) {
	            System.out.println(num2 + " is bigger.");
	         }
	         else {
	            System.out.println(" They are both " + num1);
	         }
	         num2 = num1.plus(num2);
	         System.out.println("The sum is:  " + num2);
	         num2 = num2.times(num1);
	         System.out.println("The product is: " + num2);
	         System.out.print("A big integer (999 to stop): ");
	         num1 = new BigInt(stdin.readLine());
	         if (nineninenine.compareTo(num1)!= 0) {
		         System.out.println(num1);
		         System.out.print("Another big integer: ");
		         num2 = new BigInt(stdin.readLine());
		         System.out.println(num2);
         }
      }
   }
}