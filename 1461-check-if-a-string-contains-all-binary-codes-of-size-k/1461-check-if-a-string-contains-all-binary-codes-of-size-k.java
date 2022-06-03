class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String>st=new HashSet<String>();
        for(int i=0;i<s.length()-k+1;i++){
            st.add(s.substring(i,i+k));
        }
        if(st.size()==(1<<k))return true;
        return false;
    }
}