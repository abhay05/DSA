class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sa=new StringBuilder();
        StringBuilder ta=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(sa.length()>0){
                sa.deleteCharAt(sa.length() - 1);
                }
            }else{
                sa.append(s.charAt(i));
            }
        }
        
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(ta.length()>0){
                ta.deleteCharAt(ta.length() - 1);
                }
            }else{
                ta.append(t.charAt(i));
            }
        }
        
        if(sa.toString().equals(ta.toString())){
            return true;
        }
        return false;
        
    }
}