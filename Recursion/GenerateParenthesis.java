/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

class Solution {

    List<String> result ;//= new ArayList<>();

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        solve(new Stack<Character>(), 0, 0, n);
        return result;
    }

    void solve(Stack<Character> str, int open, int closed, int n){
        //our case : closed <= open always
        if(open == n && closed == n){
            result.add(getStringFromStack(str));
            return ;
        }
        if(open - closed > 0){
            str.push(')');
            solve(str, open, closed+1, n);
            str.pop();
        }
        if(open < n){
            str.push('(');
            solve(str, open + 1, closed, n);
            str.pop();
        }
    }


    String getStringFromStack(Stack<Character> str){
        StringBuffer sb = new StringBuffer();
        for(Object obj: str.toArray()){
            sb.append((Character)obj);
        }
        return sb.toString();
    }
}

/* === ==== ===
s_s_ _s_ _ _
*/
