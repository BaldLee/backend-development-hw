package wordladder.service;

import java.util.Set;
import java.util.HashSet;
import java.io.*;

public class DictionaryReader {
    public static Set<String> testRead(String fileName){
        Set<String> result = new HashSet<String>();
        File file = new File("./src/main/resources/"+fileName);
//        File file = new File("./"+fileName);
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                result.add(tempString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return result;
    }

    public Set<String> read(String fileName){
        return this.testRead(fileName);
    }

}
