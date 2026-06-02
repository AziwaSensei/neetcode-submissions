class PrefixTree {
    data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isLastWord: Boolean = false
    )
    var root: TrieNode = TrieNode()

    fun insert(word: String) {
        var cur = root
        for (w in word) {
            if (!cur.children.containsKey(w)) {
                cur.children[w] = TrieNode()
            }
            cur = cur.children[w]!!
        }
        cur.isLastWord = true
    }

    fun search(word: String): Boolean {
        var cur = root
        for (w in word) {
            if(!cur.children.containsKey(w)) return false
            cur = cur.children[w]!!
        }
        return cur.isLastWord
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        for (w in prefix) {
            if(!cur.children.containsKey(w)) return false
            cur = cur.children[w]!!
        }
        return true
    }
}
