import org.junit.jupiter.api.*;

import java.io.*;


class wordladderTest {
    private InputStream consoleIn = null;                       // 输入流 (字符设备) consoleIn, 用于还原输出入流
    private PrintStream consoleOut = null;                      // 输出流 (字符设备) consoleOut, 用于还原输出流
    private ByteArrayOutputStream bytes = new ByteArrayOutputStream();                 // 用于缓存 console 重定向过来的字符流

    @BeforeEach
    public void setUp() {
        this.consoleIn = System.in;                     // 获取 System.in 输出流的句柄
        this.consoleOut = System.out;                   // 获取 System.out 输出流的句柄

        this.bytes = new ByteArrayOutputStream();       // 实例化
        System.setOut(new PrintStream(bytes));          // 将原本输出到控制台 console 的字符流重定向到 bytes

    }

    @Test
    public void testInput() {
        String data1 = "cat log\n" +
                "pie sad\n" +
                "sun dad\n" +
                "soft ware\n" +
                "boat word\n" +
                "sound apple\n" +
                "local event\n" +
                "learn study\n" +
                "index prime\n" +
                "q";
        String expected = "cat->cot->lot->log\n" +
                "pie->die->did->dad->sad\n" +
                "sun->dun->dud->dad\n" +
                "soft->sort->wort->wart->ware\n" +
                "boat->bort->wort->word\n" +
                "sound->pound->poind->point->print->prink->prick->price->prise->arise->anise->anile->anole->amole->ample->apple\n" +
                "local->loral->boral->boras->buras->auras->arras->arias->amias->amins->amens->avens->evens->event\n" +
                "learn->lears->sears->stars->stabs->stubs->studs->study\n" +
                "Not found!\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        wordladder.main(null);
        //assertEquals(expected,this.bytes.toString());
    }

    @AfterEach
    public void tearDown() {
        System.setIn(consoleIn);                        // 还原输入流
        System.setOut(consoleOut);                      // 还原输出流
    }

}