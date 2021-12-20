package Java2.TM.PI1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Escola {
    public static void main(String[] args) {
        Estudante marcelo = new Estudante("Marcelo", LocalDate.of(1999, 11, 26), 1, 9);
        Estudante eduardo = new Estudante("Eduardo", LocalDate.of(1999, 11, 26), 2, 9);
        Estudante monica = new Estudante("Monica", LocalDate.of(1999, 11, 26), 3, 9);
        Estudante maria = new Estudante("Maria", LocalDate.of(1999, 11, 26), 4, 8);
        Estudante janaina = new Estudante("Janaina", LocalDate.of(1999, 11, 26), 5, 8);
        Estudante ingrid = new Estudante("Ingrid", LocalDate.of(1999, 11, 26), 6, 8);
        Disciplina matematica = new Disciplina("Matematica", 180);
        Disciplina portugues = new Disciplina("Portuuês", 180);
        Turma nonoAnoA = new Turma(9, 'A');
        Turma oitavoAnoB = new Turma(8, 'B');
        nonoAnoA.inserirAluno(marcelo);
        nonoAnoA.inserirAluno(eduardo);
        nonoAnoA.inserirAluno(monica);
        nonoAnoA.inserirDisciplina(matematica);
        nonoAnoA.inserirDisciplina(portugues);
        oitavoAnoB.inserirAluno(maria);
        oitavoAnoB.inserirAluno(janaina);
        oitavoAnoB.inserirAluno(ingrid);
        oitavoAnoB.inserirDisciplina(matematica);
        oitavoAnoB.inserirDisciplina(portugues);
        System.out.println(nonoAnoA);
        System.out.println(oitavoAnoB);
    }
}

class Turma {
    private int serie;
    private char codigo;
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Estudante> estudantes = new ArrayList<>();

    public Turma(int serie, char codigo) {
        this.serie = serie;
        this.codigo = codigo;
    }

    public void inserirAluno(Estudante aluno) {
        this.estudantes.add(aluno);
    }

    public void inserirDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "serie=" + serie +
                ", codigo=" + codigo +
                ", disciplinas=" + disciplinas +
                ", estudantes=" + estudantes +
                '}';
    }
}

class Disciplina {
    private String nome;
    private int cargaHoraria;

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}

class Estudante {
    private String nome;
    private LocalDate dataNascimento;
    private int matricula;
    private int serie;

    public Estudante(String nome, LocalDate dataNascimento, int matricula, int serie) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", matricula=" + matricula +
                ", serie=" + serie +
                '}';
    }
}

