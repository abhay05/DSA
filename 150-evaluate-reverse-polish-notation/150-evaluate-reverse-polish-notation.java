class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stSt= new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int val1=stSt.pop();
                int val2=stSt.pop();
                stSt.push((val1+val2));
            }
            else if(tokens[i].equals("-")){
                int val1=stSt.pop();
                int val2=stSt.pop();
                stSt.push((val2-val1));
            }
            else if(tokens[i].equals("*")){
                int val1=stSt.pop();
                int val2=stSt.pop();
                stSt.push((val1*val2));
            }
            else if(tokens[i].equals("/")){
                int val1=stSt.pop();
                int val2=stSt.pop();
                stSt.push((val2/val1));
            }
            else{
                stSt.push(Integer.valueOf(tokens[i]));
            }
            
        }
        return stSt.pop();
    }
}