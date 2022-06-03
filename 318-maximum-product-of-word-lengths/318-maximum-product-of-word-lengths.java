class Solution {
    
    public int maxProduct(String[] words) {
        int n=words.length;
        int[] bit=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                bit[i]|=(1<<words[i].charAt(j));
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((bit[i]&bit[j])==0){
                    ans=Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
}