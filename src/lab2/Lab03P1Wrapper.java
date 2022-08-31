package lab2;

import java.util.Scanner;

public class Lab03P1Wrapper {
	
	public static int[] getRowPascalTriangle(int rowIndex) {
		/*ADD YOUR CODE HERE */
		//Hint: Use this formula curr=(prev∗(n–i+1))/i, where n=rowIndex,i=currElmIdx
		int[] output = new int[rowIndex+1];

		for(int i = 0; i <= rowIndex; i++) {
			try {
			output[i] = (output[i-1] * (rowIndex-i+1))/i; 
			}
			catch(IndexOutOfBoundsException e) {
				output[i] = 1;
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("ENTER DESIRED PASCAL TRIANGLE ROW");
		int input = scan.nextInt();
		scan.close();
		System.out.println("YOUR INPUT: " + input);
		
		int[] output = Lab03P1Wrapper.getRowPascalTriangle(input);
		
		System.out.println("ANSWER:");
		for(int i = 0; i <= input; i++) {
			System.out.print(output[i] + " ");
		}
	}

}
