package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ApiConnectionReadSave {
    private String path = "app/src/main/java/quotes/gson/recentquotes.json";

    public void setUpApiConn() throws IOException {

        //Set up new connection to read fro API link
        String url = "http://[error]api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestMethod("GET");
        System.out.println(connection);

        //To read data from API we use stream reader then add it to buffered reader
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String data = bufferedReader.readLine();
        System.out.println(data);
        bufferedReader.close();


        // To convert string to json
        Gson gson2 = new Gson();
        QuotesApi quote = gson2.fromJson(data, QuotesApi.class);
        Gson gson = new Gson();


        // create a reader to read from file
        BufferedReader br = new BufferedReader(
                new FileReader(path));

        ArrayList<Quotes> testCase = gson.fromJson(br, new TypeToken<ArrayList<Quotes>>() {}.getType());

        int randomQuote = (int)(Math.random()*(testCase.size()-1));
        System.out.println("Name Of Author: "+quote.getQuoteAuthor());
        System.out.println("The Quote : " + quote.getQuotesText());
        System.out.println("Quote number : " + randomQuote);

        // To save coming data from API in our file
        Quotes NewQuote = new Quotes(quote.getQuoteAuthor(),quote.getQuotesText());
        testCase.add(NewQuote);
        String json = gson.toJson(testCase);
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(json);
        bw.close();
        System.out.println("the quote is >>> " + quote.getQuoteAuthor());
        System.out.println("the text is >>> " + quote.getQuotesText());
    }

}
