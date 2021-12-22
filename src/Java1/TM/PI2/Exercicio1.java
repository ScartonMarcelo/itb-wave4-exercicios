package Java1.TM.PI2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercicio1 {
    public static void main(String[] args) {
        Integer[] values = {52, 10, 85, 1324, 1, 13, 62, 30, 12, 127};
        List<Integer> array = new ArrayList<>(Arrays.asList(values));
        imprimeCrescente(array);
        imprimeDescrescente(array);
    }

    private static void imprimeCrescente(List<Integer> array) {
        Collections.sort(array);
        System.out.println(array);
    }

    private static void imprimeDescrescente(List<Integer> array) {
        Collections.sort(array, Collections.reverseOrder());
        System.out.println(array);
    }
}
