package Java1.TT.PI1;

import java.util.*;

public class RadixSort {

    public static void radixSort(int[] iArr) {
        String[] stringsArray = geraStringsArray(iArr);
        Map<Integer, List<String>> listas = geraListas();
        List<String> iteracoes = new ArrayList<>();
        Collections.addAll(iteracoes, stringsArray);
        for (int i=stringsArray[0].toCharArray().length-1; i>=0; i--) {
            iteraListas(listas, iteracoes, i);
        }
        for (int i=0; i<iteracoes.size(); i++) {
            iArr[i] = Integer.parseInt(iteracoes.get(i));
        }
    }

    private static void iteraListas(Map<Integer, List<String>> listas, List<String> iteracoes, int digito) {
        atualizaMap(listas, digito, iteracoes);
        iteracoes.clear();
        for (Map.Entry<Integer, List<String>> entrada: listas.entrySet()) {
            iteracoes.addAll(entrada.getValue());
        }
    }

    private static void atualizaMap(Map<Integer, List<String>> listas, int digito, List<String> iteracoes) {
        for (Map.Entry<Integer, List<String>> entrada: listas.entrySet()) {
            listas.get(entrada.getKey()).clear();
        }
        for (String valorString: iteracoes) {
            int index = Integer.parseInt(Character.toString(valorString.toCharArray()[digito]));
            listas.get(index).add(valorString);
        }
    }

    private static Map<Integer, List<String>> geraListas() {
        Map<Integer, List<String>> listas = new HashMap<>();
        for (int i=0; i<10; i++) {
            listas.put(i, new ArrayList<String>());
        }
        return listas;
    }

    private static String[] geraStringsArray(int[] iArr) {
        String[] stringsArray = new String[iArr.length];
        for (int i=0; i< iArr.length; i++) {
            String valorString = Integer.toString(iArr[i]);
            stringsArray[i] = valorString;
        }
        int maior = 0;
        for (String valorString: stringsArray) {
            if (valorString.length() > maior) {
                maior = valorString.length();
            }
        }
        String format = "%0" + maior + "d";
        for (int i=0; i<stringsArray.length; i++) {
            stringsArray[i] = String.format(format, Integer.parseInt(stringsArray[i]));
        }
        return  stringsArray;
    }

    public static void main(String[] args) {
        int[] iArr = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        radixSort(iArr);
        for (int i: iArr) {
            System.out.print(i + " ");
        }
    }
}
