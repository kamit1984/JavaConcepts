package loops;

import java.io.BufferedReader;
import java.util.Arrays;

public class ForEnhanced {

    public static void main(String[] args) {

/*
        for (int i = 0,j = 0; i < 10; i++,j--) {
            System.out.println(j);
        }
*/


/*
    int[] ints = {1,2,3,4,5,6};

    for(int a : ints){
            System.out.println(a);
        }
*/

/*
        // For loop with labels
        outer:
        for (int j = 0; j < 2; j++) {
            Inner:
            for (int k = 0; k < 10; k++) {
                System.out.print(j + "" + k);
                if (k == 5) {
                    System.out.println("Breaking Inner loop");
                    break Inner;//Takes out of loop using j
                }
            }
        }
*/

        int[] matrix1 =  { 1, 2, 3 };
        int[] matrix2 =  { 3, 2, 1 };

        Arrays.sort(matrix1);
        Arrays.sort(matrix2);
        System.out.println(Arrays.equals(matrix1,matrix2));


    }
}
