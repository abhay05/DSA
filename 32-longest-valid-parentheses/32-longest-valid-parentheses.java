class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>st=new Stack<Integer>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!st.empty()){
                int indp=st.peek();
                if(s.charAt(indp)=='(' && c==')'){
                    st.pop();
                    ans=Math.max(ans,i-indp+1);
                }else{
                    ans=Math.max(ans,i-indp-1);
                    st.push(i);
                }
            }else{
                if(i>0){
                ans=Math.max(ans,i);}
                st.push(i);
            }
        }
        int len=s.length();
      //  System.out.println(ans);
        if(!st.empty()){
            ans=Math.max(ans,len-st.peek()-1);
        }else{
            ans=Math.max(ans,len);
        }
        return ans;
    }
}