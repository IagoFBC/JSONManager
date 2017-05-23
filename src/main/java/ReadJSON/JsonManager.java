package main.java.ReadJSON;

import main.java.Descricao.Conjunto;
import main.java.Descricao.Descricao;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonManager {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;

        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);

            return json;
        } finally {
            is.close();
        }
    }

    public static String jsonToArray(JSONArray jsonArray){
        StringBuilder string = new StringBuilder("[[\"Data\", \"Valor\"],");
        String array;
        JSONObject json;

        for(int i = 0; i < jsonArray.length(); i++){
            string.append("[");

            json = jsonArray.getJSONObject(i);

            string.append("\"" + json.get("data") + "\",");
            string.append(json.get("valor") + "],");
        }

        array = string.substring(0, string.length() - 1) + "]";

        return array;
    }



    public static void main(String[] args) throws IOException, JSONException ,ParseException{
        Descricao dados = new Descricao();

        for(Conjunto conjunto : dados.getConjuntos()) {

            JSONArray jsonArray = readJsonFromUrl("http://api.bcb.gov.br/dados/serie/bcdata.sgs." + conjunto.getCod() +"/dados?formato=json");

            String orgao = "Banco Central";
            String sigla = "BCB";
            String descricao = "O Banco Central do Brasil - BCB tem como missão institucional a estabilidade do poder de compra da moeda e a solidez do sistema financeiro. As infraestruturas do mercado financeiro desempenham um papel fundamental para o sistema financeiro e a economia de uma forma geral. Seu funcionamento adequado é essencial para a estabilidade financeira e condição necessária para salvaguardar os canais de transmissão da política monetária. Assim, cumpre ao BCB atuar no sentido de promover sua solidez, normal funcionamento e contínuo aperfeiçoamento.";
            String tag = "Econômico";

            String nome = conjunto.getNome();
            String arrayJS = jsonToArray(jsonArray);
            Date dataModificacao = new Date();


            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicial = formato.parse(jsonArray.getJSONObject(0).get("data").toString());
            Date dataFinal = formato.parse(jsonArray.getJSONObject(jsonArray.length() - 1).get("data").toString());
            String descricaoDado = conjunto.getDescricao();

            System.out.println(dataInicial + " " + dataFinal);
            System.out.println(jsonArray);
            System.out.println(jsonToArray(jsonArray));
            //System.out.println(firstDate(jsonArray));
            //System.out.println(lastDate(jsonArray));
        }
    }
}
