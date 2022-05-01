class Solution {
    public String longestCommonPrefix(String[] strs) {
        int ans=0;
        String ansS="";
        for(int i=0;i<strs[0].length();i++){
            String s=strs[0].substring(0,i+1);
           // System.out.println("string "+s);
            for(int j=0;j<strs.length;j++){
                if(strs[j].length()<s.length())return ansS;
                if(s.equals(strs[j].substring(0,i+1))){
                    
                }else{
                    return ansS;
                }
            }
            ans=i+1;
            ansS=s;
        }
        return ansS;
    }
}