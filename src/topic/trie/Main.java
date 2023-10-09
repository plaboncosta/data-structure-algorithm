package topic.trie;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("Plabon");
//        trie.insert("Prince");
//        trie.insert("Placid");
//        trie.insert("Rihem");

        System.out.println(trie.delete("ab"));
        System.out.println(trie.root.getChildren().isEmpty());
    }
}