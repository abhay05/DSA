class Solution {
    
    public double calPow(double x, int n){
        if(n==0){
            return 1;
        }
        if(n%2==1){
            double val= calPow(x,n/2);
            return val*val*x;
        }
        else{
            double val= calPow(x,n/2);
            return val*val;
        }
        
    }
    
    public double myPow(double x, int n) {
        if(n<0){
            x= 1/x;
            n=n+1;
            n=-n;
            return x*calPow(x,n);
        }
     
        double val=calPow(x,n);
        return val;
    }
}