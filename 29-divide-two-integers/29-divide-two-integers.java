class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend<0 && divisor<0){
            dividend+=1;
            int ans=(int)Double.sum((double)dividend/(double)divisor,(double)-1.0/(double)divisor);
            return ans;
        }
        return dividend/divisor;
    }
}