class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp=new HashMap<Character,Integer>();
        int n=s.length();
        int ans=0;
        int lo=0;
        int up=0;
        for(int i=0;i<n;i++){
            up++;
            if(mp.get(s.charAt(i))!=null && mp.get(s.charAt(i))>=lo && mp.get(s.charAt(i))<=up){
                lo=mp.get(s.charAt(i))+1;
            }else{
               // up++;
                ans=Math.max(ans,up-lo);
            }
            
            mp.put(s.charAt(i),i);
        }
        return ans;
    }
}