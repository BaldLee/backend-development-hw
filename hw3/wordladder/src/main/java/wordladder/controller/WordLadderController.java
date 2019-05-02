package wordladder.controller;

import wordladder.service.WordLadder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Stack;

@RestController
@RequestMapping("/wordladder")
public class WordLadderController {
    @RequestMapping("/")
    public String index() {
        String output = "Welcome to wordladder";
        return JSON.toJSONString(output);
    }

    @RequestMapping("/build")
    public String wladder(@RequestParam(value = "startword", defaultValue = "cat") String startword,
                          @RequestParam(value = "endword", defaultValue = "dog") String endword){
        WordLadder wl = new WordLadder(startword,endword);
        Stack<String> result = wl.getLadder();
        String output = new String();
        ArrayList<String> strList = new ArrayList<String>();
        while(!result.isEmpty()){
            strList.add(result.pop());
        }
        output = JSON.toJSONString(strList);
        return output;
    }

//    @RequestMapping("/admin")
//    public String admin() {
//        String output = "You are admin.";
//        output = JSON.toJSONString(output);
//        return output;
//    }
}
