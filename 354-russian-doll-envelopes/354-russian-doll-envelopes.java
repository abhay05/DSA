class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return b[1]-a[1];
                }
                return a[0]-b[0];
            }
        });
        int n=envelopes.length;
        int[] dp= new int[n+1];
        int ans=0;
        for(int[] e:envelopes){
            int ind=Arrays.binarySearch(dp,0,ans,e[1]);
          //  System.out.println("ele "+e[1]+" Ind "+ind);
            if(ind<0)ind=-(ind+1);
            dp[ind]=e[1];
            if(ind==ans){
                ans++;
            }
        }
        return ans;
        
    }
}