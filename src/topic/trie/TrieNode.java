package topic.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean isEndWord;

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndWord() {
        return isEndWord;
    }

    public void setEndWord(boolean value) {
        isEndWord = value;
    }
}
