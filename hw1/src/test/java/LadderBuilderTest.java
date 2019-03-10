import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class LadderBuilderTest {
    static Set<String> dictionary = null;
    static Index wordIndex = null;
    static LadderBuilder lb = null;
    static Stack<String> expected=null;

    @BeforeAll
    public static void setup() throws Exception{
        dictionary = DictionaryReader.testRead("D:\\学习\\backend\\hw1\\src\\main\\resources\\EnglishWords.txt");
        wordIndex = new Index(dictionary);
        expected=new Stack<String>();
        lb = new LadderBuilder();

    }

    @Test
    public void test1(){

        expected.clear();
        expected.push("log");
        expected.push("lot");
        expected.push("cot");
        expected.push("cat");
        assertEquals(expected,lb.build("cat","log",wordIndex));

    }

    @Test
    public void test2(){

        expected.clear();
        expected.push("sad");
        expected.push("dad");
        expected.push("did");
        expected.push("die");
        expected.push("pie");
        assertEquals(expected,lb.build("pie","sad",wordIndex));

    }

}