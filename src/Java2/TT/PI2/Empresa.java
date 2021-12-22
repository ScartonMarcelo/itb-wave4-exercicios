package Java2.TT.PI2;


import java.math.BigDecimal;

public class Empresa {
    public static void main(String[] args) {
        Funcionario marcelo = new FuncionarioCLT("Marcelo", Cargo.ANALISTA);
        Funcionario andre = new FuncionarioCLT("Andre", Cargo.GERENTE);
        Funcionario marisa = new FuncionarioCLT("Marisa", Cargo.TECNICO);
        Funcionario julia = new FuncionarioCLT("Julia", Cargo.DIRETOR);
        Funcionario amauri = new FuncionarioPJ("Amauri", new BigDecimal("50"));
        System.out.println("Salario Marcelo: R$" + marcelo.pagarSalario(new BigDecimal("3")));
        System.out.println("Salario Andre: R$" + andre.pagarSalario(new BigDecimal("2")));
        System.out.println("Salario Marisa: R$" + marisa.pagarSalario(new BigDecimal("1")));
        System.out.println("Salario Julia: R$" + julia.pagarSalario(new BigDecimal("0")));
        System.out.println("Salario Amauri: R$" + amauri.pagarSalario(new BigDecimal("160")));
    }
}

interface ISalario {
    BigDecimal pagarSalario(BigDecimal variavelSalarial);
}

abstract class Funcionario implements ISalario {
    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class FuncionarioPJ extends Funcionario {
    private BigDecimal valorHora;

    public FuncionarioPJ(String nome, BigDecimal valorHora) {
        super(nome);
        this.valorHora = valorHora;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }


    public BigDecimal pagarSalario(BigDecimal variavelSalarial) {
        return valorHora.multiply(variavelSalarial);
    }

}

class FuncionarioCLT extends Funcionario {
    private BigDecimal salarioBase;
    private BigDecimal bonificacao;
    private double jornada;
    private double descansoRemunerado;

    public FuncionarioCLT(String nome, Cargo cargo) {
        super(nome);
        switch (cargo) {
            case TECNICO:
                this.salarioBase = new BigDecimal("3200");
                this.bonificacao = new BigDecimal("0.05");
                this.jornada = 40.0;
                this.descansoRemunerado = 0.0;
                break;
            case ANALISTA:
                this.salarioBase = new BigDecimal("4000");
                this.bonificacao = new BigDecimal("0.08");
                this.jornada = 40.0;
                this.descansoRemunerado = 4.0;
                break;
            case GERENTE:
                this.salarioBase = new BigDecimal("6000");
                this.bonificacao = new BigDecimal("0.125");
                this.jornada = 36.0;
                this.descansoRemunerado = 4.0;
                break;
            case DIRETOR:
                this.salarioBase = new BigDecimal("15000");
                this.bonificacao = new BigDecimal("0");
                this.jornada = 0.0;
                this.descansoRemunerado = 0.0;
                break;
        }
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public BigDecimal getBonificacao() {
        return bonificacao;
    }

    public double getJornada() {
        return jornada;
    }

    public double getDescansoRemunerado() {
        return descansoRemunerado;
    }

    public BigDecimal pagarSalario(BigDecimal variavelSalarial) {
        BigDecimal salarioMetas = (salarioBase.multiply(bonificacao)).multiply(variavelSalarial);
        return salarioBase.add(salarioMetas);
    }

}

enum Cargo {
    TECNICO,
    ANALISTA,
    GERENTE,
    DIRETOR
}