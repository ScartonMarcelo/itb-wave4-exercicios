package Java3.TM.PI1;

public class Exercicio1 {
    public static void main(String[] args) {
        Pessoa[] pessoas = {
                new Pessoa("Marcelo", 1),
                new Pessoa("Amauri", 2),
                new Pessoa("Junior", 3)
        };
        Sortutil.sort(pessoas);
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
        Celular[] celulares = {
                new Celular("999999999", "Marcelo"),
                new Celular("888888888", "Amauri"),
                new Celular("777777777", "Junior")
        };
        Sortutil.sort(celulares);
        for (Celular celular : celulares) {
            System.out.println(celular);
        }
    }
}

interface Precedente<T> {
    public int precedeA(T t);
}

class Pessoa implements Precedente<Pessoa> {
    private String nome;
    private long Cpf;

    public Pessoa(String nome, long cpf) {
        this.nome = nome;
        Cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return Cpf;
    }

    @Override
    public int precedeA(Pessoa pessoa) {
        return this.nome.compareTo(pessoa.nome);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }
}

class Celular implements Precedente<Celular> {
    String numero;
    String dono;

    public Celular(String numero, String dono) {
        this.numero = numero;
        this.dono = dono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    @Override
    public int precedeA(Celular celular) {
        return 0;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "numero='" + numero + '\'' +
                ", dono='" + dono + '\'' +
                '}';
    }
}

class Sortutil {
    public static <T> void sort(Precedente<T>[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].precedeA((T) arr[j + 1]) > 0) {
                    Precedente<T> temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}