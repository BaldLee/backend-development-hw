package wordladder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Controller
@Configuration
@SpringBootApplication
public class WordLadderApplication {
    public static void main(String[] args){
        SpringApplication.run(WordLadderApplication.class, args);
    }
}
