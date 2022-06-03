public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans=0;
        int temp=n;
       // System.out.println(n);
        while(n!=0){
           n=(n&(n-1));
            ans++;
        }
        return ans;
    }
}