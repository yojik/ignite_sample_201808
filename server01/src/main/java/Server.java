import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.cache.Cache;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Server {

    public void startIt() {
        Ignite ignite =Ignition.start();
        Cache<String,String> c = ignite.getOrCreateCache("sample");
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
        Server app = new Server();
        app.startIt();
    }
}
