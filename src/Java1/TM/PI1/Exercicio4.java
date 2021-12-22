package Java1.TM.PI1;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite n:");
        int n = sc.nextInt();
        System.out.println("Digite m:");
        int m = sc.nextInt();
        for (int i = 1; i <= m; i++) {
            if (n == 0) {
                break;
            }
            boolean primo = ehPrimo(i);
            if (primo) {
                System.out.println(i + " é primo.");
                n--;
            }
        }
    }

    public static boolean ehPrimo(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
