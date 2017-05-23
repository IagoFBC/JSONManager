package main.java.json;

import main.java.conjunto.Conjunto;
import main.java.conjunto.ConjuntoArray;
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

}
