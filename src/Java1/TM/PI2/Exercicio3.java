package Java1.TM.PI2;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        int identificador = 1;
        Produto [] produtos = new Produto[3];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<3; i++) {
            System.out.println("Digite o nome do produto " + identificador);
            String produto = sc.next();
            System.out.println("Digite o valor do produto " + identificador);
            double valor = sc.nextDouble();
            System.out.println("Digite a quantidade do produto " + identificador);
            int quantidade = sc.nextInt();
            produtos[i] = new Produto(produto, valor, quantidade);
            identificador++;
        }
        identificador = 1;
        System.out.println();
        for(Produto produto: produtos) {
            System.out.println("Produto " + identificador);
            System.out.println(produto.getNome());
            System.out.println("R$" + produto.getValor());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println();
            identificador++;
        }
    }
}

class Produto {

    private String nome;
    private double valor;
    private int quantidade;

    public Produto(String nome, double valor, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
