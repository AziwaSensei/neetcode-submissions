/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if(node == null) return node
        
        val mapCloned = mutableMapOf<Node?, Node?>()
        val visited = mutableSetOf<Node?>()

        fun dfs(node: Node?) {
            visited.add(node)
            mapCloned.put(node, Node(node?.`val`!!))

            for(nei in node?.neighbors!!) {
                if(!visited.contains(nei)) {
                    dfs(nei)
                }
                mapCloned.get(node)?.neighbors?.add(mapCloned.get(nei))
            }
        }

        dfs(node)

        return mapCloned[node]

    }
}
