class Solution {
    int dp[]=new int[50001];
    public int dfs(List<List<Integer>> graph,int[] visited,int[] time,int src,int dest){
        visited[src]=1;
        int ans=time[src-1];
        for(int i=0;i<graph.get(src).size();i++){
            int v=graph.get(src).get(i);
            if(visited[v]==0){
                ans=Math.max(ans,dfs(graph,visited,time,v,dest)+time[src-1]);
            }
            else{
                ans=Math.max(ans,dp[v]+time[src-1]);
            }
        }
        //System.out.println(src+" "+time[src-1]+" "+ans);
        dp[src]=ans;
        return ans;
    }
    
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indeg=new int[n+1];
        int[] outdeg=new int[n+1];
        for(int i=0;i<=n;i++){
         //   System.out.println(i);
            indeg[i]=0;
            outdeg[i]=0;
            dp[i]=0;
        }
        List<List<Integer>>graph=new ArrayList<List<Integer>>();
        for(int i=0;i<=n;i++){
         //   System.out.println(i);
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<relations.length;i++){
                    outdeg[relations[i][0]]++;
                    indeg[relations[i][1]]++;
                graph.get(relations[i][0]).add(relations[i][1]);
            }
        
        int src=-1;
        int dest=-1;
        for(int i=1;i<=n;i++){
            if(outdeg[i]==0 && dest==-1){
                dest=i;
            }
            if(indeg[i]==0 && src==-1){
                src=i;
            }
            
        }
        int[] visited=new int[n+1];
        for(int i=0;i<=n;i++){
            visited[i]=0;
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(indeg[i]==0 && visited[i]==0){
                int temp=dfs(graph,visited,time,i,dest);
               ans=Math.max(ans, temp);
                //System.out.println(i+" "+temp);
            }
        }
        return ans;
    }
}