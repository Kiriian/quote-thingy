/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import exception.quoteNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Jeanette
 */
public class Facade
{

    static Random random = new Random();

    private static Map<Integer, String> quotes = new HashMap()
    {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }
    };

    public static String getQuote(int id)
    {
        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(id));
        String jsonResponse = new Gson().toJson(quote);
        return jsonResponse;
    }

    public static String qetRandomQuote()
    {
        int randomNumber = random.nextInt(quotes.size() + 1);
        while (!quotes.containsKey(randomNumber))
        {
            randomNumber = random.nextInt(quotes.size() + 1);
        }
        JsonObject quote = new JsonObject();
        quote.addProperty("quote", quotes.get(randomNumber));
        String jsonResponse = new Gson().toJson(quote);
        return jsonResponse;
    }

    public static String createQuote(String quote)
    {
        JsonObject newQuote = new JsonParser().parse(quote).getAsJsonObject();
        quote = newQuote.get("quote").getAsString();
        int id = quotes.size() + 1;
        quotes.put(id, quote);

        JsonObject json = new JsonObject();
        json.addProperty("id", id);
        json.addProperty("quote", quotes.get(id));
        String jsonResponse = new Gson().toJson(json);
        return jsonResponse;
    }

    public static String updateQuote(int id, String quote)
    {
        if (quotes.containsKey(id))
        {
            JsonObject newQuote = new JsonParser().parse(quote).getAsJsonObject();
            String quote1 = newQuote.get("quote").getAsString();
            quotes.put(id, quote1);
        }
        JsonObject json = new JsonObject();
        json.addProperty("id", id);
        json.addProperty("quote", quotes.get(id));
        String jsonResponse = new Gson().toJson(json);
        return jsonResponse;
    }

    public static String deleteQuote(int id)
    {
        JsonObject json = new JsonObject();
        json.addProperty("quote", quotes.get(id));
        String jsonResponse = new Gson().toJson(json);
        quotes.remove(id);
        return jsonResponse;
    }
}
