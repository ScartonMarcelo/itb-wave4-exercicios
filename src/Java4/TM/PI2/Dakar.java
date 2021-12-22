package Java4.TM.PI2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dakar {
    public static void main(String[] args) {
        Corrida meli = new Corrida(100, new BigDecimal(1000000), "meli", 10);
        meli.registrarVeiculo(new Carro(50, 10, 5, "exe"));
        meli.registrarVeiculo(new Moto(40, 5, 10, "aua"));
        meli.registrarVeiculo(new Carro(30, 2, 7, "olo"));
        meli.registrarVeiculo(new Moto(60, 7, 8, "fgf"));
        Veiculo vencedor = meli.definirVencedor();
        System.out.println(vencedor);
        meli.socorrerVeiculo(vencedor);
        meli.removerVeiculo(vencedor);
        System.out.println(meli.getListaVeiculos());
    }
}

abstract class Veiculo {
    private int velocidade;
    private double aceleracao;
    private double anguloDeGiro;
    private String placa;
    private double peso;
    private int rodas;

    public Veiculo(int velocidade, double aceleracao, double anguloDeGiro, String placa, double peso, int rodas) {
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.anguloDeGiro = anguloDeGiro;
        this.placa = placa;
        this.peso = peso;
        this.rodas = rodas;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public double getAceleracao() {
        return aceleracao;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public String getPlaca() {
        return placa;
    }

    public double getPeso() {
        return peso;
    }

    public int getRodas() {
        return rodas;
    }

    public double getDesempenho() {
        return ((velocidade * aceleracao) / (anguloDeGiro * (peso - rodas * 100)));
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "velocidade=" + velocidade +
                ", aceleracao=" + aceleracao +
                ", anguloDeGiro=" + anguloDeGiro +
                ", placa='" + placa + '\'' +
                ", peso=" + peso +
                ", rodas=" + rodas +
                '}';
    }
}

interface ICorrida<Veiculo> {

    void registrarVeiculo(Veiculo v);

    void removerVeiculo(Veiculo v);

    void removerVeiculoPorPlaca(String placa);

    Veiculo definirVencedor();
}

class Corrida implements ICorrida<Veiculo> {
    private double distancia;
    private BigDecimal premioEmDolares;
    private String nome;
    private int quantidadeVeiculosPermitidos;
    private List<Veiculo> listaVeiculos;
    private Socorrista socorrista;

    public Corrida(double distancia, BigDecimal premioEmDolares, String nome, int quantidadeVeiculosPermitidos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
        this.listaVeiculos = new ArrayList<>();
        this.socorrista = new Socorrista();
    }

    public double getDistancia() {
        return distancia;
    }

    public BigDecimal getPremioEmDolares() {
        return premioEmDolares;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeVeiculosPermitidos() {
        return quantidadeVeiculosPermitidos;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    @Override
    public void registrarVeiculo(Veiculo v) {
        if (this.listaVeiculos.size() < quantidadeVeiculosPermitidos && !this.listaVeiculos.contains(v)) {
            this.listaVeiculos.add(v);
        }
    }

    @Override
    public void removerVeiculo(Veiculo v) {
        this.listaVeiculos.remove(v);
    }

    @Override
    public void removerVeiculoPorPlaca(String placa) {
        for (Veiculo v : this.listaVeiculos) {
            if (v.getPlaca() == placa) {
                this.listaVeiculos.remove(v);
            }
        }
    }

    @Override
    public Veiculo definirVencedor() {
        Veiculo vencedor = null;
        double desempenhoVencedor = 0.0;
        double desempenhoVeiculo = 0.0;
        for (Veiculo v : this.listaVeiculos) {
            desempenhoVeiculo = v.getDesempenho();
            if (desempenhoVeiculo > desempenhoVencedor) {
                vencedor = v;
                desempenhoVencedor = desempenhoVeiculo;
            }
        }
        return vencedor;
    }

    public void socorrerVeiculo(Veiculo v) {
        socorrista.socorrer(v);
    }
}

class Carro extends Veiculo {
    private static final double PESO = 1000.0;
    private static final int RODAS = 4;

    public Carro(int velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, PESO, RODAS);
    }
}

class Moto extends Veiculo {
    private static final double PESO = 300.0;
    private static final int RODAS = 2;

    public Moto(int velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, 300, 2);
    }
}

class Socorrista {
    public void socorrer(Veiculo v) {
        if (v instanceof Carro) {
            System.out.println("Socorrendo Carro!");
        } else {
            System.out.println("Socorrendo Moto!");
        }
    }
}