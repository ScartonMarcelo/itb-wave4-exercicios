package Java1.TM.PI2;

import java.text.DecimalFormat;

public class Exercicio2 {
    public static void main(String[] args) {
        int ano = 2021;
        Empresa x = new Empresa(1.13, 1.48);
        Empresa y = new Empresa(18.4, 0.32);
        while(x.getValor() < y.getValor()) {
            System.out.println("Ano: " + ano +" | Valor de X: " + x.getFormattedValor() + " | Valor de Y: " + y.getFormattedValor());
            x.cresce();
            y.cresce();
            ano++;
        }
        System.out.println("Ano: " + ano +" | Valor de X: " + x.getFormattedValor() + " | Valor de Y: " + y.getFormattedValor());
    }
}

class Empresa {
    private double  valor;
    private double crescimento;
    private DecimalFormat df = new DecimalFormat("R$0.00M");

    public Empresa(double valor, double crescimento) {
        this.valor = valor;
        this.crescimento = crescimento;
    }

    public double getValor() {
        return valor;
    }

    public void cresce() {
        this.valor += this.valor * this.crescimento;
    }

    public String getFormattedValor() {
        return df.format(this.valor);
    }
}
