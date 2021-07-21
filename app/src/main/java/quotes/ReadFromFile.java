package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile {

    private String path = "app/src/main/java/quotes/gson/recentquotes.json";


    public void read() throws IOException {
        Gson gson = new Gson();

        // create a reader
        Reader reader = Files.newBufferedReader(Paths.get(path));
        BufferedReader br = new BufferedReader(
                new FileReader(path));

        //convert the json string back to object
        Quotes[] testCase = gson.fromJson(br, Quotes[].class);
        int randomQuote = (int)(Math.random()*(testCase.length-1));
        System.out.println("Name Of Author: "+testCase[randomQuote].getAuthor());
        System.out.println("The Quote : " + testCase[randomQuote].getText());
        System.out.println("Quote number : " + randomQuote);
    }

}
