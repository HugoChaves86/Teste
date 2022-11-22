package engsoftware;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

/**
 *
 * @author Hugo_Chaves
 */
public abstract class Biblioteca {
    public static List<Livro> livros = inicializarLivros();

    private static List<Livro> inicializarLivros() {
        livros = new ArrayList<>();

        try {
            Gson gson = new Gson();
            JSONParser parser = new JSONParser();
            JSONArray data = (JSONArray) parser.parse(
                    new FileReader("src/main/resources/livros.json"));

            for (Object jsonLivro: data) {
                Livro livro = gson.fromJson(jsonLivro.toString(), Livro.class);

                livros.add(livro);
            }

            return livros;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return livros;
    }
}
