package login.controller;

import login.service.Login;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/dologin")
    public String doLogin(@RequestParam(value = "username", defaultValue = "") String username,
                          @RequestParam(value = "password", defaultValue = "") String password) {
        return Login.doLogin(username, password);
    }
}
