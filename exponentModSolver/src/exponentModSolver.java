/*
 Made by: Illya Markov
 I made this in grade 11 to help out students taking Cryptography in third year university.
 Feel free to use this when solving the tedious homework you may be assigned.
 */

import java.util.Scanner;

public class exponentModSolver {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("a^e (mod n)\n");
		System.out.print("n:");
		int a = input.nextInt();
		System.out.print("a:");
		int e = input.nextInt();
		System.out.print("n:");
		int n = input.nextInt();
		
		System.out.println("");
		
		System.out.println(a + "^" + e + " (mod " + n + ")");
		int[] vals = {a, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] powerArr = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
		vals[0] = a;
		int set = 1;
		int power = 2;
		System.out.println(vals[0] + "^1, " + vals[0]);
		while (power <= e) {
			vals[set] = (int) ((Math.pow(vals[set-1], 2))%n);
			System.out.println(a + "^" + power + "," + vals[set] + "(mod " + n + ")");
			power = power*2;
			set++;
		}
		
		int cul = 0; 
		int res = 1;
		
		System.out.println("");
		
		for (int i = set; i >= 0; i--) {
			if (powerArr[i] <= e-cul) {
				cul+=powerArr[i];
				System.out.println(cul + ", " + powerArr[i] + ", " + vals[i] + "(mod " + n + ")");
				res = (res * (vals[i])%n);
			}
		}
		System.out.println("\nANSWER: " + res%n + "(mod " + n + ")");
		System.out.println("_______________________________________");
	}	
}
