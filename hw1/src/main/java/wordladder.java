import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class wordladder {
    public static void main(String[] args) {
        DictionaryReader dReader = new DictionaryReader();
        System.out.println("Reading dictionary...");
        Set<String> dictionary = dReader.read("EnglishWords.txt");
        System.out.println("Done");
        System.out.println("Building the index...");
        Index wordIndex = new Index(dictionary);
        System.out.println("Done");

        Scanner scan = new Scanner(System.in);
        LadderBuilder lb = new LadderBuilder();
        while(true) {
            System.out.print("Input the start word and the end word:(Input \"q\" to quit)");
            String startWord="";
            String endWord="";
            if(scan.hasNext()) startWord = scan.next();
            if(startWord.equals("q")) break;
            if(scan.hasNext()) endWord = scan.next();
            if(startWord.equals("")||endWord.equals("")){
                System.out.println("Invalid input. Please input like \"startWord endWord\"");
            }
            Stack<String> stack = lb.build(startWord,endWord,wordIndex);
            if(!stack.isEmpty()){
                System.out.print(startWord);
                while(!stack.isEmpty()){
                    String tmp = stack.pop();
                    if(tmp.equals(startWord)) continue;
                    System.out.print( "->" + tmp);
                }
                System.out.println();
            }
            else {
                System.out.println("Not found!");
            }
        }
    }
}
