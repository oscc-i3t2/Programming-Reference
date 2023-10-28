class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(isClosingBrace(ch)){
                if(stack.isEmpty()){
                    return false;
                }
                //closing brace
                char opening = findOpeningBrace(ch);
                if(stack.peek() != opening){
                    return false;
                }else{
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    char findOpeningBrace(char ch){
        switch(ch){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }

    boolean isClosingBrace(char ch){
        return ch == ')' || ch == '}' || ch == ']' ;
    }
}
