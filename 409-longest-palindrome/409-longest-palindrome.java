class Solution {
    public int longestPalindrome(String s) {
        int ans=0;
        int odd=0;
        Map<Character,Integer>mp=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                int val=mp.get(s.charAt(i));
                mp.put(s.charAt(i),val+1);
            }else{
                mp.put(s.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer>entry:mp.entrySet()){
            int val=entry.getValue();
            if(val%2==1){
                odd=1;   
            }
            ans+=val-val%2;
        }
        ans+=odd%2;
        return ans;
    }
}