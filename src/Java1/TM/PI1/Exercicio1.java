package Java1.TM.PI1;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite n:");
        int n = sc.nextInt();
        for(int i=0; i<n*2; i+=2) {
            System.out.println(i + " é par.");
        }
    }
}
