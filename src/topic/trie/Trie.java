package topic.trie;

public class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (Character ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }

        current.setEndWord(true);
    }

    public boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);

            if (node == null) return false;
            current = node;
        }

        return current.isEndWord();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, Integer index) {
        if (word.length() == index) {
            if (!current.isEndWord()) {
                return false;
            }

            current.setEndWord(false);
            return current.getChildren().isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);

        if (node == null) return false;

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }

        return false;
    }

}
