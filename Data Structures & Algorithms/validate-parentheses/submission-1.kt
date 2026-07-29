class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for(ch in s) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.addFirst(ch)
            } else {
                if(ch == ')' && (stack.firstOrNull() != '(')) return false
                if(ch == ']' && (stack.firstOrNull() != '[')) return false 
                if(ch == '}' && (stack.firstOrNull() != '{')) return false 
                stack.removeFirst()
            }
        }

        return stack.isEmpty()
    }
}
