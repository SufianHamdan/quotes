/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) {

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("C:/Users/peter/quotes/app/src/main/java/quotes/gson/recentquotes.json"));

            // convert JSON array to list of quotes
            List<Quotes> users = new Gson().fromJson(reader, new TypeToken<List<Quotes>>() {}.getType());

            // print all quotes
//            for(Quotes q: users){
//                System.out.println(q.getAuthor() + "\n" + q.getText());
//            }
            int random = 0 + (int)(Math.random() * ((users.size() - 0) + 1));

            // print one author and his text randomly
            System.out.println(users.get(random).getAuthor() + " \n" + users.get(random).getText());

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
