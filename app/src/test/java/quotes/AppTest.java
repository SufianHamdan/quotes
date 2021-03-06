/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private String path = "C:/Users/peter/quotes/app/src/main/java/quotes/gson/recentquotes.json";


    @Test void testReadFromFile() throws IOException {

        Gson gson = new Gson();
        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get(path));
        BufferedReader br = new BufferedReader(
                new FileReader(path));

        //convert the json string back to object
        Quotes[] testCase = gson.fromJson(br, Quotes[].class);
        int randomQuote = (int)(Math.random()*(testCase.length-1));

        assertNotNull(testCase[randomQuote].getText());
        assertNotNull(testCase[randomQuote].getAuthor());
    }

    @Test public void testConnResponseWithData() throws IOException {
        String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestMethod("GET");
        int conn = connection.getResponseCode();

        assertEquals(200, conn);

        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String data = bufferedReader.readLine();
        System.out.println(data);
        bufferedReader.close();

        Gson gson2 = new Gson();
        QuotesApi quote = gson2.fromJson(data, QuotesApi.class);
        Gson gson = new Gson();

        assertNotNull(quote.getQuoteAuthor());
        assertNotNull(quote.getQuotesText());

    }
}
