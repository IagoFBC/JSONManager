package main.java.Descricao;

import java.util.ArrayList;

/**
 * Created by Iago on 22/05/2017.
 */
public class Descricao {

    ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();

    public Descricao(){
        conjuntos.add(new Conjunto("1373", "Produção total de autoveículos", "Valor da produção de veículos automotores no País."));
    }

    public ArrayList<Conjunto> getConjuntos() {
        return conjuntos;
    }
}
