package main.java.Descricao;

/**
 * Created by Iago on 22/05/2017.
 */
public class Conjunto {
    String cod;
    String nome;
    String descricao;

    public Conjunto(String cod, String nome, String descricao) {
        this.cod = cod;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
