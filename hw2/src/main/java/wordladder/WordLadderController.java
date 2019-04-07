package wordladder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;

@RestController
public class WordLadderController {
    @RequestMapping("/wladder")
    public String wladder(@RequestParam(value = "startword", defaultValue = "cat") String startword,@RequestParam(value = "endword", defaultValue = "dog") String endword){
        WordLadder wl = new WordLadder(startword,endword);
        Stack<String> result = wl.getLadder();
        String output = startword;
        while(!result.isEmpty()){
            String tmp = result.pop();
            output += " -> "+tmp;
        }
        return output;
    }
}
