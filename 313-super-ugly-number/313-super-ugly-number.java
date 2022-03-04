class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int pn=primes.length;
        List<Integer> arr=new ArrayList<Integer>();
        arr.add(1);
        int[] indices=new int[pn];//{0};
        
        for(int i=0;i<pn;i++){
            indices[i]=0;
        }
        
        for(int i=2;i<=n;i++){
            int mini=2147483647;
            for(int j=0;j<pn;j++){
                mini=Math.min(mini,arr.get(indices[j])*primes[j]);
            }
            for(int j=0;j<pn;j++){
                if(mini==arr.get(indices[j])*primes[j]){
                    indices[j]=indices[j]+1;
                }
            }
            arr.add(mini);
        }
        return arr.get(n-1);
    }
}