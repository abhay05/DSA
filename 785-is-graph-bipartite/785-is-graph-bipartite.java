class Solution {
    
    boolean dfs(int[][] graph,int[] visited,int node,int par,int mark){
        visited[node]=mark;
        boolean flag=true;
        for(int i=0;i<graph[node].length;i++){
            int v=graph[node][i];
            if(visited[v]==-1){
            flag=(flag&dfs(graph,visited,v,node,1-mark));
            }
            if(visited[v]==mark)return false;
        }
        return flag;
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] visited=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            visited[i]=-1;
        }
        boolean flag= dfs(graph,visited,0,-1,0);
        for(int i=1;i<graph.length;i++){
            if(visited[i]==-1){
            flag=(flag&dfs(graph,visited,i,-1,0));}
        }
        return flag;
    }
}