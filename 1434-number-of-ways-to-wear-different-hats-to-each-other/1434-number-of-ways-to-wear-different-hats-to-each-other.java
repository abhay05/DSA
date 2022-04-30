class Solution {
    int[][] dp=new int[41][1025];
    public int recur(List<List<Integer>>graph,int bit,int tot,int ind){

        if(tot==bit){
            return 1;}
        if(ind>40)return 0;
        int ans=0;
        if(dp[ind][bit]!=-1)return dp[ind][bit];
            ans+=recur(graph,bit,tot,ind+1);
       
        for(int i=0;i<graph.get(ind).size();i++){
            int person=graph.get(ind).get(i);
            if((bit&(1<<person))==0){
                ans+=recur(graph,(bit|(1<<person)),tot,ind+1);
                ans%=1000000007;
            }
        }
        
        dp[ind][bit]=ans;
        
        return ans;
    }
    
    public int numberWays(List<List<Integer>> hats) {
        for(int i=0;i<41;i++){
            for(int j=0;j<1025;j++){
                dp[i][j]=-1;
            }
        }
        List<List<Integer>>graph=new ArrayList<List<Integer>>();
        for(int i=0;i<=40;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<hats.size();i++){
            for(int j=0;j<hats.get(i).size();j++){
                graph.get(hats.get(i).get(j)).add(i);
            }
        }
        int tot=(1<<(hats.size()))-1;
        return recur(graph,0,tot,0);
    }
}