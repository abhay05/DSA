class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        int temp=0;
        int nint=x;
        while(nint!=0){
            int rem=nint%10;
            temp=temp*10+rem;
            nint/=10;
        }
        if(temp==x)return true;
        return false;
    }
}