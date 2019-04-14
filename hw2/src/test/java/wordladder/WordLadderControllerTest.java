package wordladder;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration()
@AutoConfigureMockMvc

public class WordLadderControllerTest {
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @BeforeEach()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @DisplayName("test1")
    public void test1() throws Exception {
        this.mockMvc.perform(
                get("/wladder")
                .contentType("application/json;charset=UTF-8")
                )
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", Matchers.contains("cat","cot","dot","dog"))));
    }

    @Test
    @DisplayName("test2")
    public void test2() throws Exception {
        this.mockMvc.perform(
                get("/wladder")
                        .contentType("application/json;charset=UTF-8")
                        .param("startword","cat")
                        .param("endword","log")
        )
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", Matchers.contains("cat","cot","lot","log"))));
    }

    @Test
    @DisplayName("test3")
    public void test3() throws Exception {
        this.mockMvc.perform(
                get("/wladder")
                        .contentType("application/json;charset=UTF-8")
                        .param("startword","pie")
                        .param("endword","sad")
        )
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", Matchers.contains("pie","die","did","dad","sad"))));
    }

    @Test
    @DisplayName("test4")
    public void test4() throws Exception {
        this.mockMvc.perform(
                get("/wladder")
                        .contentType("application/json;charset=UTF-8")
                        .param("startword","sun")
                        .param("endword","dad")
        )
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", Matchers.contains("sun","dun","dud","dad"))));
    }

    @Test
    @DisplayName("test5")
    public void test5() throws Exception {
        this.mockMvc.perform(
                get("/wladder")
                        .contentType("application/json;charset=UTF-8")
                        .param("startword","soft")
                        .param("endword","ware")
        )
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", Matchers.contains("soft","sort","wort","wart","ware"))));
    }

    @Test
    @DisplayName("test6")
    public void test6() throws Exception {
        this.mockMvc.perform(
                get("/wladder")
                        .contentType("application/json;charset=UTF-8")
                        .param("startword","boat")
                        .param("endword","word")
        )
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", Matchers.contains("boat","bort","wort","word"))));
    }

    @Test
    @DisplayName("test7")
    public void test7() throws Exception {
        this.mockMvc.perform(
                get("/wladder")
                        .contentType("application/json;charset=UTF-8")
                        .param("startword","sound")
                        .param("endword","apple")
        )
                .andExpect(status().isOk())
                .andExpect((jsonPath("$", Matchers.contains("sound","pound","poind","point","print","prink",
                                                                      "prick","price","prise","arise","anise","anile",
                                                                      "anole","amole","ample","apple"))));
    }

    @Test
    @DisplayName("test8")
    public void test8() throws Exception {
        this.mockMvc.perform(
                get("/wladder")
                        .contentType("application/json;charset=UTF-8")
                        .param("startword","as")
                        .param("endword","set")
        )
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }
}