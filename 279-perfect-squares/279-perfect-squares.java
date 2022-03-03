//Lagrange’s four-square theorem

class Solution {
    
    public int numSquares(int n) {
        int srt=(int)Math.sqrt(n);
        if(n==srt*srt){
            return 1;
        }
        
        for(int i=1;i*i<=n;i++){
             srt=(int)Math.sqrt(n-i*i);
            if(n-i*i==srt*srt){
                return 2;
            }
        }
        
        // 4^k*(8*m+7)
        int temp=n;
        while(temp%4==0){
            temp/=4;
        }
        if(temp%8==7){
            return 4;
        }
        
        return 3;
        
    }
}