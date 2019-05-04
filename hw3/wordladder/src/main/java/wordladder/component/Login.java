package wordladder.component;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class Login {
    public static String login(String username, String password) {
        String urlString = "";
        String current;
        try {
            URL url = new URL("http://localhost:8083/login/dologin?username=" + username + "&password=" + password);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlString;
    }
}
