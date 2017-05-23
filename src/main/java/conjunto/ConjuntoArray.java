package main.java.conjunto;

import java.util.ArrayList;

public class ConjuntoArray {

    private ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();

    public ConjuntoArray(){
        conjuntos.add(new Conjunto("1373", "Produção total de autoveículos"));
    }

    public ArrayList<Conjunto> getConjuntos() {
        return conjuntos;
    }
}
