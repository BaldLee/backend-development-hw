package wordladder;
import org.junit.jupiter.api.*;

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
        dictionary = DictionaryReader.testRead("EnglishWords.txt");
        wordIndex = new Index(dictionary);
        expected=new Stack<String>();
        lb = new LadderBuilder();

    }

    @Test
    @DisplayName("test1")
    public void test1(){

        expected.clear();
        expected.push("log");
        expected.push("lot");
        expected.push("cot");
        expected.push("cat");
        assertEquals(expected,lb.build("cat","log",wordIndex));

    }

    @Test
    @DisplayName("test2")
    public void test2(){

        expected.clear();
        expected.push("sad");
        expected.push("dad");
        expected.push("did");
        expected.push("die");
        expected.push("pie");
        assertEquals(expected,lb.build("pie","sad",wordIndex));

    }

    @Test
    @DisplayName("test3")
    public void test3(){

        expected.clear();
        expected.push("dad");
        expected.push("dud");
        expected.push("dun");
        expected.push("sun");
        assertEquals(expected,lb.build("sun","dad",wordIndex));

    }

    @Test
    @DisplayName("test4")
    public void test4(){

        expected.clear();
        expected.push("ware");
        expected.push("wart");
        expected.push("wort");
        expected.push("sort");
        expected.push("soft");
        assertEquals(expected,lb.build("soft","ware",wordIndex));

    }

    @Test
    @DisplayName("test5")
    public void test5(){

        expected.clear();
        expected.push("word");
        expected.push("wort");
        expected.push("bort");
        expected.push("boat");
        assertEquals(expected,lb.build("boat","word",wordIndex));

    }

    @Test
    @DisplayName("test6")
    public void test6(){

        expected.clear();
        expected.push("apple");
        expected.push("ample");
        expected.push("amole");
        expected.push("anole");
        expected.push("anile");
        expected.push("anise");
        expected.push("arise");
        expected.push("prise");
        expected.push("price");
        expected.push("prick");
        expected.push("prink");
        expected.push("print");
        expected.push("point");
        expected.push("poind");
        expected.push("pound");
        expected.push("sound");
        assertEquals(expected,lb.build("sound","apple",wordIndex));

    }

    @Test
    @DisplayName("test7")
    public void test7(){

        expected.clear();
        expected.push("event");
        expected.push("evens");
        expected.push("avens");
        expected.push("amens");
        expected.push("amins");
        expected.push("amias");
        expected.push("arias");
        expected.push("arras");
        expected.push("auras");
        expected.push("buras");
        expected.push("boras");
        expected.push("boral");
        expected.push("loral");
        expected.push("local");
        assertEquals(expected,lb.build("local","event",wordIndex));

    }

    @Test
    @DisplayName("test8")
    public void test8(){

        expected.clear();
        expected.push("study");
        expected.push("studs");
        expected.push("stubs");
        expected.push("stabs");
        expected.push("stars");
        expected.push("sears");
        expected.push("lears");
        expected.push("learn");
        assertEquals(expected,lb.build("learn","study",wordIndex));

    }

    @Test
    @DisplayName("test9")
    public void test9(){

        expected.clear();
        assertEquals(expected,lb.build("index","prime",wordIndex));

    }
}