class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for(str in strs) {
            val newString = str.toCharArray().sorted().joinToString("")

            map[newString]?.let {
                it.add(str)
            } ?: run {
                map[newString] = mutableListOf<String>()
                map[newString]?.add(str)
            }
        }

        val result = mutableListOf<List<String>>()

        map.forEach { (elem, value) -> 
            result.add(value)
        }

        return result
    }
}
