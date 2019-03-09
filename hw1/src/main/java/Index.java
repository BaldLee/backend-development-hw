import java.util.*;

public class Index {
    private Map<String,Set<String>> wordIndex;
    public Index(Set<String> dictionary){
        wordIndex = new HashMap<String, Set<String>>();
        Iterator<String> it = dictionary.iterator();
        while(it.hasNext()){
            String curWord = it.next();
            Set<String> curWordIndex = new HashSet<String>();
            for(int i=0;i<curWord.length();i++){
                String tmp = curWord;
                for(char c = 'a';c<='z';c++){
                    StringBuilder sb = new StringBuilder(tmp);
                    sb.setCharAt(i,c);
                    tmp = sb.toString();
                    if(dictionary.contains(tmp)&&tmp.equals(curWord)){
                        curWordIndex.add(tmp);
                    }
                }
            }
            wordIndex.put(curWord,curWordIndex);
        }
    }

    public Set<String> seach(String input){
        Set<String> result=new HashSet<String>();
        if(wordIndex.containsKey(input)){
            result = wordIndex.get(input);
        }
        return result;
    }


}
