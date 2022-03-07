class Solution {
    public int trailingZeroes(int n) {
        int a=2;
        int b=5;
        int mina=Integer.MAX_VALUE;
        int minb=Integer.MAX_VALUE;
        int cnta=0;
        int cntb=0;
        while(a<=n){
            cnta+=n/a;
            a*=2;
        }
        
        while(b<=n){
            cntb+=n/b;
            b*=5;
        }
        
        return Math.min(cnta,cntb);
    }
}