import java.io.*;    // for BufferedReader
import java.util.*;  // for StringTokenizer

public class Test {
    private static int max = 100;

    public static void main(String[] args) throws IOException  {
    	Utilities.main(args);
        InputStream input_data = new FileInputStream("C:/Users/Steve/workspace/COMP182/Program3/Data.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(input_data));
        int[] numbers = new int[max];
        int size, result;
        System.out.println("This program written by: " + Utilities.myName());
        size = input(numbers, max, in);
        while (size > 0) {
           result = Utilities.maxBlock(numbers, size);
           System.out.print(result + " ");
           size = input(numbers, max, in);
        }
        System.out.println();
        System.out.println("Test run complete.");
        
     }
    
    public static int input(int[] a, int max, BufferedReader in) throws IOException {
        int num, size;
        size = 0;
        String inputLine = in.readLine();    // All input must be on a single line
        StringTokenizer input = new StringTokenizer(inputLine);
        while (input.hasMoreTokens() && (size <= max)) {  // extract the integers
           num = Integer.parseInt(input.nextToken());     // from the input line
           a[size] = num;
           size ++;
        }
        if (input.hasMoreTokens()) {
           System.out.print("Too much data.  Program terminates.");
           System.exit(0);
        }
        return size;
     }

}