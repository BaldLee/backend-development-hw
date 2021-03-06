package wordladder.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wordladder.service.DictionaryReader;
import wordladder.service.Index;

import java.util.Set;

@Component
public class DictionarySetup implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        DictionaryReader dReader = new DictionaryReader();
        Set<String> dictionary = dReader.read("EnglishWords.txt");
        Index wordIndex = new Index(dictionary);
    }
}
