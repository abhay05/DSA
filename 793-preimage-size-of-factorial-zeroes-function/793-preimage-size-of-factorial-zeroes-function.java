class Solution {
    
    long check(long val){
        long cnt5=0;
        while(val>0){
            cnt5+=val/5;
            val/=5;
        }
        return cnt5;
    }
    
    public int preimageSizeFZF(int k) {
        long l=0;
        long u=5L*k;
        long ans=-1;
        while(l<=u){
            long mid=(l+u)/2;
            long cnt5=check(mid);
            if(cnt5<k){
                l=mid+1;
            }else{
                u=mid-1;
                if(cnt5==k){
                ans=mid;}
            }
        }
        if(ans==-1){
            return 0;
        }
        long cnt2=0;
        long temp=ans;
        while(temp!=0){
            cnt2+=temp/2;
            temp/=2;
        }
        if(cnt2<k){
            return 0;
        }
        if(ans==-1){
            return 0;
        }
    //    System.out.println(ans);
        return (int)(5-ans%5);
    }
}