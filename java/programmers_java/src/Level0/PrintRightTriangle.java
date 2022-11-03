package Level0;

import java.util.Scanner;

public class PrintRightTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int j=0; j<n; j++) {
            for(int i=1 ; i<=j+1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
