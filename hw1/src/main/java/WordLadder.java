import java.util.HashSet;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        DictionaryReader dReader = new DictionaryReader();
        System.out.println("Reading dictionary...");
        Set<String> dictionary = dReader.read("EnglishWords.txt");
        System.out.println("Done");
        System.out.println("Building the index...");
        Index wordIndex = new Index(dictionary);
        System.out.println("Done");

    }
}
