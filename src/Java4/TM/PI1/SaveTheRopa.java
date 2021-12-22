package Java4.TM.PI1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveTheRopa {
    public static void main(String[] args) {
        Vesturario tenisNike = new Vesturario("nike", "air");
        Vesturario camisaNike = new Vesturario("nike", "fit");
        Vesturario tenisAdidas = new Vesturario("adidas", "predator");
        Vesturario camisaAdidas = new Vesturario("adidas", "club");
        List<Vesturario> roupasNike = new ArrayList<>();
        List<Vesturario> roupasAdidas = new ArrayList<>();
        roupasNike.add(tenisNike);
        roupasNike.add(camisaNike);
        roupasAdidas.add(tenisAdidas);
        roupasAdidas.add(camisaAdidas);
        GuardaRoupa guardaRoupa = new GuardaRoupa();
        int nikeId = guardaRoupa.guardarVestuarios(roupasNike);
        int adidasId = guardaRoupa.guardarVestuarios(roupasAdidas);
        guardaRoupa.mostrarVestuarios();
        guardaRoupa.devolverVestuarios(nikeId);
        guardaRoupa.devolverVestuarios(adidasId);
        guardaRoupa.mostrarVestuarios();
    }
}

class Vesturario {
    private String marca;
    private String modelo;

    public Vesturario(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Vesturario{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}

class GuardaRoupa {
    private Map<Integer, List<Vesturario>> vestuarios = new HashMap<>();
    private static int contador = 0;

    public Integer guardarVestuarios(List<Vesturario> listaDeVestuario) {
        vestuarios.put(contador, listaDeVestuario);
        int temp = contador;
        contador++;
        return temp;
    }

    public void mostrarVestuarios() {
        vestuarios.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public List<Vesturario> devolverVestuarios(Integer id) {
        List<Vesturario> vesturario = vestuarios.get(id);
        this.vestuarios.remove(id);
        return vesturario;
    }
}
