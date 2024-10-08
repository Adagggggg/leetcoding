class Solution {
    TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();

        // 把短的先加入字典，这样可以一边遍历一边判断
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());

        for (String word: words) {
            // 这里需要注意，如果是concatenated单词，说明不需要加入字典树，因为它也是由别的单词组成的，别的单词已经在字典树里面了
            // 比如 abcd = ab + cd
            // 下一个单词是 abcdef = ab + cd + ef，不需要 abcd + ed
            if (dfs(word, 0)) {
                res.add(word);
            // 不是concatenated单词，加入字典，比如cat，dod
            } else {
                insert(word);
            }
        }

        return res;
    }

    public boolean dfs(String word, int index) {
        // 注意，这里如果是cat，到结尾是有序的，但这时候cat并没有被加入字典
        // 且由于单词都是distinct的，不会出现同一个单词组成的concatenated word
        if (index == word.length()) {
            return true;
        }

        TrieNode node = root;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {
                return false;
            }

            // 找到了一个完整的单词，深入下一层
            if (node.children[c - 'a'].isValid && dfs(word, i + 1)) {
                return true;
            }

            node = node.children[c - 'a'];
        }

        return false;
    }
     
    // 构建字典树
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }

            node = node.children[c - 'a'];
        }

        // 设为有效单词
        node.isValid = true;
    } 
}

class TrieNode {
    TrieNode[] children;
    boolean isValid;

    public TrieNode() {
        children = new TrieNode[26];
        isValid = false;
    }
}