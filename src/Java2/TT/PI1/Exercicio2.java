package Java2.TT.PI1;


import java.text.DecimalFormat;

public class Exercicio2 {

    public static void main(String[] args) {
        FiguraGeometrica circulo = new Circulo(3);
        FiguraGeometrica triangulo = new Triangulo(5.3, 2);
        FiguraGeometrica retangulo = new Retangulo(2.4, 3);
        FiguraGeometrica[] arr = {circulo, triangulo, retangulo};
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(areaMedia(arr)));
    }

    static double areaMedia(FiguraGeometrica[] arr) {
        double areamedia = 0;
        for (FiguraGeometrica figura : arr) {
            areamedia += figura.area();
        }
        return areamedia / arr.length;
    }
}

abstract class FiguraGeometrica {

    public abstract double area();

    @Override
    public String toString() {
        return "Área: " + area();
    }
}

class Circulo extends FiguraGeometrica {

    double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(raio, 2);
    }
}

class Triangulo extends FiguraGeometrica {

    double base;
    double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }
}

class Retangulo extends FiguraGeometrica {

    double compimento;
    double largura;

    public Retangulo(double compimento, double largura) {
        this.compimento = compimento;
        this.largura = largura;
    }

    @Override
    public double area() {
        return compimento * largura;
    }
}