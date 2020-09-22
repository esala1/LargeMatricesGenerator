package largeMatricesGenerator;

import java.util.Scanner;
import java.util.Random;
//This program is for generating large matrices and performing multiplication
	public class matrix {
		public static void main(String[] args) {	
				String userChoice; //continue or not
				Scanner sc = new Scanner(System.in);
				
				do{
				System.out.println("What is the matrix dimension? ");
				int n = sc.nextInt();
				while (n < 50) {
					System.out.println("You entered unacceptable matrix dimension. It should be greater than or equal to 50");
					System.out.println("What is the matrix dimension? ");
					n = sc.nextInt();
				}
				//apply multidimensional arrays' concepts to create matrices where: rows=columns=Userinput
				int matrix1[][] = new int[n][n];
				int matrix2[][] = new int[n][n];
				int dotp[][] = new int[n][n];
				Random rand = new Random();
				//nested-for-loops to create each matrix randomly(0-50 numbers range)
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						matrix1[i][j] = rand.nextInt(50);
						matrix2[i][j] = rand.nextInt(50);
					}
				}
				System.out.println("Matrix 1 is as follows:");
				squareBracket(matrix1);
				System.out.println();
				System.out.println();
				System.out.println("Matrix 2 is as follows:");
				squareBracket(matrix2);
				//use system class to calculate execution time in milli seconds
				long begin_time = System.currentTimeMillis();  //set initial time 
				int sum = 0;
				//triple nested-for-loops to apply matrix multiplication logic
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++) {  
							sum = sum + matrix1[i][k] * matrix2[k][j];      //matrix multiplication logic
						}
						dotp[i][j] = sum; //result
						sum = 0;
					}				
				}
				long stop_time = System.currentTimeMillis(); // set final time
				System.out.println();
				System.out.println();
				System.out.println("Result matrix is as follows: ");
				squareBracket(dotp);
				System.out.println();
				System.out.println();
				System.out.println(" Total execution time is....: "+(stop_time-begin_time)+" ms");
				System.out.println("Would you like to continue?");
				userChoice = sc.next();      
				}while(userChoice.equalsIgnoreCase("yes")); // as long as user says yes(ignores case sensitivity)
	}      //print out in matrix form with brackets
		public static void squareBracket(int matrix[][]) {
			int n = matrix.length;
			System.out.print("[");   //most outer
			for (int i = 0; i < n; i++) {
				System.out.print("[");
				for (int j = 0; j < n; j++) {
					System.out.print(matrix[i][j]);
					if (j != n - 1)
						System.out.print(", "); //within each array
				}
				System.out.print("]");
				if (i != n - 1)
					System.out.println(","); //separate each array in a matrix
			}
			System.out.print("]"); //most outer
		}
}



