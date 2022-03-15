class Solution {
    HashMap<Integer,Long>mp=new HashMap<Integer,Long>();
    long recur(int a,int b){
        if(b==0 && a==0){
            return 1;
        }
        if(a<0 || b<0){
            return 0;
        }
        if(a>b){
            return 0;
        }
        if(mp.containsKey(a*500+b))return mp.get(a*500+b);
        long ans=0;
        ans=(ans+(a*recur(a-1,b)))%1000000007;
        ans=(ans+((b-a)*(recur(a,b-1))))%1000000007;
        mp.put(a*500+b,ans%1000000007L);
        return ans%1000000007;
    }
    
    public int countOrders(int n) {
        int[] arr = new int[n];
        return (int)recur(n,n);
    }
}