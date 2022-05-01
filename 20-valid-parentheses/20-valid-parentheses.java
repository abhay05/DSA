class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(st.size()>0 && s.charAt(i)==')'){
                char p=st.peek();
                if(p=='('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(st.size()>0 && s.charAt(i)=='}'){
                char p=st.peek();
                if(p=='{'){
                    st.pop();
                }else{
                    return false;
                }
            }else if(st.size()>0 && s.charAt(i)==']'){
                char p=st.peek();
                if(p=='['){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.add(s.charAt(i));
            }
        }
        if(st.size()>0)return false;
        return true;
    }
}