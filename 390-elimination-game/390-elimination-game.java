class Solution {
    public int lastRemaining(int n) {
        int ans=1;
        int dir=1;
        int jump=1;
        while(n>1){
            if(dir==1 || n%2==1){
                ans=ans+jump;
            }
            jump*=2;
            dir=1-dir;
            n/=2;
        }
        return ans;
    }
}