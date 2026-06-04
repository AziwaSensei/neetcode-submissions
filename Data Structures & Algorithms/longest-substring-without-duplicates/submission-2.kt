class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = mutableMapOf<Char, Int>() // seen char to position
        var longest = 0

        var start = 0
        var end = 0

        while(end < s.length) { // abcab 4
            val ch = s[end]

            if(seen.containsKey(ch)) { //a->0, b->1
                start = Math.max(seen.get(ch)!! + 1, start)  //3
            } 

            seen.put(ch, end) //a -> 3, b -> 1, c -> 2
            longest = Math.max(longest, end - start + 1)  //3
            println("longest: $longest +++ end: $end +++ start: $start")
            end += 1
        }
        return longest
    }
}
