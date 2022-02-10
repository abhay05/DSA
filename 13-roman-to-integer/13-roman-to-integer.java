class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int ans=0;
        for(int i =s.length()-1;i>=0;i--){
            if(i<s.length()-1){
                if(mp.get(s.charAt(i+1))>mp.get(s.charAt(i))){
                    ans-=mp.get(s.charAt(i));
                }else{
                    ans+=mp.get(s.charAt(i));
                }
            }else{
            ans+=mp.get(s.charAt(i));
            }
        }
        return ans;
    }
}