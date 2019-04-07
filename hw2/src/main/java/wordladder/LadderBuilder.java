package wordladder;
import java.util.*;

public class LadderBuilder {
    public Stack<String> build(String sword, String eword, Index wordIndex){
        Stack<String> stack = new Stack<String>();
        Map<String,String> toolMap=new HashMap<String, String>();
        Queue<String> queue = new LinkedList<String>();
        Set<String> usedWord = new HashSet<String>();
        queue.offer(sword);
        String head;
        usedWord.add(sword);
        boolean isFound = false;
        while(!queue.isEmpty()){
            head = queue.remove();
            if(head.equals(eword)){
                isFound = true;
                break;
            }
            Set<String> nextWords = wordIndex.search(head);
            for(String elements:nextWords){
                if(usedWord.contains(elements)) continue;
                usedWord.add(elements);
                queue.offer(elements);
                toolMap.put(elements,head);
            }
        }
        if(isFound){
            stack.push(eword);
            String tmp = eword;
            while(!tmp.equals(sword)){
                tmp = toolMap.get(tmp);
                stack.push(tmp);
            }
        }
        return stack;
    }
}
