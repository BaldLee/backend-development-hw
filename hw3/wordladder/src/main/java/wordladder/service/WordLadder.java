package wordladder.service;

import java.util.Stack;

public class WordLadder {
    private final Stack<String> ladder;
    public WordLadder(String sword,String eword)
    {
        Index wordIndex = new Index();
        LadderBuilder lb = new LadderBuilder();
        this.ladder = lb.build(sword,eword,wordIndex);
    }

    public Stack<String> getLadder()
    {
        return this.ladder;
    }
}