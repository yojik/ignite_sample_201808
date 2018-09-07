import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.cache.Cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

/*
 * とりあえずデータ投入を行う
 */
public class App {

    public void startIt() {
        Ignition.setClientMode(true);
        Ignite ignite =Ignition.start();
        Cache<String,String> c = ignite.getOrCreateCache("sample");
        System.out.println(c);
        c.put("test", "TEST");
        String input = readLine("enter!");
        ignite.close();
    }

    private String readLine(String string) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(string);
            return reader.readLine();
        } catch (IOException e) {
          throw new RuntimeException(e);
        } finally {

        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.startIt();
    }
}
