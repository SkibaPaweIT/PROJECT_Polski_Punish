package pl.skiba.tekkenrankings.polskipunish.services;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.exceptions.TournamentNotFoundException;

@Service
public class JsonReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url , String name) throws IOException, JSONException {
        InputStream is;
        try{
            is = new URL(url).openStream();
        }
        catch(FileNotFoundException exception){
            throw new TournamentNotFoundException(name);
        }

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }

    }

}