package login.service;

public class Login {
    public static String doLogin(String username, String password) {
        if (username.equals("user") && password.equals("user")) {
            return "pass";
        }
        return "fail";
    }
}
