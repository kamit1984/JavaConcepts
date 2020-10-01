package hackerrank;

import java.util.Scanner;

/**
 * Create by Amit on 10/1/20
 */
public class Loops {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        if((2 <= N) && (N <= 20)){
            System.out.println("Valid Input");
        }else{
            System.out.println("Invalid Input");
            return;
        }
        for (int i = 1; i <=10 ; i++) {
            System.out.printf("%d x %d = %d%n", N, i, N * i);

        }
    }
}
