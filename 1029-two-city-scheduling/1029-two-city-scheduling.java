class Solution {
    Map<Integer,Integer>mp=new HashMap<Integer,Integer>();
    int recur(int[][] costs,int i,int j,int ind){
        if(ind==costs.length){
            return 0;
        }
        if(mp.containsKey(i*costs.length+j))return mp.get(i*costs.length+j);
        int ans=0;
        if(i==costs.length/2 && j<=costs.length/2){
            ans=recur(costs,i,j+1,ind+1)+costs[ind][1];
        }else if(i<=costs.length/2 && j==costs.length/2){
            ans=recur(costs,i+1,j,ind+1)+costs[ind][0];
        }else if(i<=costs.length/2 && j<=costs.length/2){
        ans=Math.min(recur(costs,i+1,j,ind+1)+costs[ind][0],recur(costs,i,j+1,ind+1)+costs[ind][1]);
        }
        mp.put((i*costs.length+j),ans);
        return ans;
    }
    
    public int twoCitySchedCost(int[][] costs) {
      //  int ans=recur(costs,0,0,0);
        int[][] dp=new int[costs.length+1][costs.length+1];
        int n=costs.length/2;
        dp[0][0]=0;
        for(int i=1;i<n+1;i++){
        dp[i][0]=dp[i-1][0]+costs[i-1][0];
        dp[0][i]=dp[0][i-1]+costs[i-1][1];
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.min(dp[i-1][j]+costs[i+j-1][0],dp[i][j-1]+costs[i+j-1][1]);
            }
        }
        return dp[n][n];
    }
}