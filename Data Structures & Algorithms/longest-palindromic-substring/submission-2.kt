class Solution {
    fun longestPalindrome(s: String): String {
        var longest = 0
        var result = ""

        for (i in s.indices) {
            var l = i
            var r = i

            while(l >= 0 && r < s.length && s[l] == s[r]) {
                if(longest < (r - l + 1)) {
                    longest = (r - l + 1)
                    result = s.substring(l, r + 1)
                }
                l -= 1
                r += 1
            }

            l = i
            r = i + 1
            while(l >= 0 && r < s.length && s[l] == s[r]) {
                if(longest < (r - l + 1)) {
                    longest = (r - l + 1)
                    result = s.substring(l, r + 1)
                }
                l -= 1
                r += 1
            }
        }

        return result
    }
}