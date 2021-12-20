package Java1.TM.PI1;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite n:");
        int n = sc.nextInt();
        System.out.println("Digite m:");
        int m = sc.nextInt();
        System.out.println("Digite d:");
        int d = sc.nextInt();
        String dString = Integer.toString(d);
        int i = 0;
        int count;
        while (n!=0) {
            count = 0;
            String numString = Integer.toString(i);
            for (char c: numString.toCharArray()) {
                if (Character.toString(c).equals(dString)) {
                    count++;
                }
            }
            if (count>=m) {
                System.out.println(i);
                n--;
            }
            i++;
        }
    }
}
