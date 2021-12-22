package Java1.TM.PI1;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite n:");
        int n = sc.nextInt();
        System.out.println("Digite m:");
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(i * m + " é múltiplo de m.");
        }
    }
}
