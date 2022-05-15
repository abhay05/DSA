class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int[] count=new int[26];
        for(int i=0;i<26;i++){
            count[i]=0;
        }
        int maxFreq=0;
        int ans=0;
        int ind=0;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'A']++;
            maxFreq=Math.max(maxFreq,count[s.charAt(i)-'A']);
            while(i-ind+1-maxFreq>k){
                count[s.charAt(ind)-'A']--;
                ind++;
                maxFreq=count[0];
                for(int j=1;j<26;j++){
                    maxFreq=Math.max(maxFreq,count[j]);
                }
            }
            ans=Math.max(ans,i-ind+1);
        }
        return ans;
    }
}