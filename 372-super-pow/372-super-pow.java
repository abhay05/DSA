class Solution {
    int MOD = 1337;
    
    int powmod(int a,int b){
        if(b==0)return 1;
        int val=powmod(a,b/2);
        return (b%2==1)?((val*val)%MOD*a%MOD)%MOD:(val*val)%MOD;
    }
    
    int get(int a,int p,int ten,int pow10){
        int val=powmod(a,p);
        while(pow10>0){
        val=powmod(val,10);
            pow10--;
        }
        return val;
    }
    
    public int superPow(int a, int[] b) {
        int last=1;
        a=a%MOD;
        int n=b.length;
        for(int i=0;i<n;i++){
            int p=b[i];
            int pow10=n-i-1;
            int curr=get(a,p,10,pow10);
            last=(last%MOD*curr%MOD)%MOD;
        }
        return last;
    }
}