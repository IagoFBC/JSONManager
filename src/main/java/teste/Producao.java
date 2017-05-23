package main.java.teste;

import main.java.conjunto.Conjunto;
import main.java.conjunto.ConjuntoArray;

import static main.java.json.JsonManager.jsonToArray;
import static main.java.json.JsonManager.readJsonFromUrl;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Producao {

    public static void main(String[] args) throws IOException, JSONException,ParseException {
        ConjuntoArray dados = new ConjuntoArray();

        for(Conjunto conjunto : dados.getConjuntos()) {

            JSONArray jsonArray = readJsonFromUrl("http://api.bcb.gov.br/dados/serie/bcdata.sgs." + conjunto.getCod() +"/dados?formato=json");

            //ORGÃO
            String orgao = "Banco Central";
            String sigla = "BCB";
            String descricao = "O Banco Central do Brasil - BCB tem como missão institucional a estabilidade do poder de compra da moeda e a solidez do sistema financeiro. As infraestruturas do mercado financeiro desempenham um papel fundamental para o sistema financeiro e a economia de uma forma geral. Seu funcionamento adequado é essencial para a estabilidade financeira e condição necessária para salvaguardar os canais de transmissão da política monetária. Assim, cumpre ao BCB atuar no sentido de promover sua solidez, normal funcionamento e contínuo aperfeiçoamento.";
            String tag = "Econômico";

            //CONJUNTO DE DADOS
            String nome = conjunto.getNome();
            String arrayJS = jsonToArray(jsonArray);
            Date dataModificacao = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicial = formato.parse(jsonArray.getJSONObject(0).get("data").toString());
            Date dataFinal = formato.parse(jsonArray.getJSONObject(jsonArray.length() - 1).get("data").toString());

        }
    }
}
