/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) throws IOException {


//        String filePath = "app/src/main/java/quotes/gson/recentquotes.json";
//        Api link
//        http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en
        ApiConnectionReadSave data = new ApiConnectionReadSave();
        ReadFromFile obj = new ReadFromFile();

        try{
            data.setUpApiConn();
        }catch (IOException e){
            obj.read();
        }


    }
}
