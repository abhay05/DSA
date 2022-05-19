class Solution {
    int time=0;
    int[] low=new int[100006];
    int[] disc=new int[100006];
    Stack<Integer>st=new Stack<Integer>();
    int[] insideStack=new int[100006];
    int[] visited=new int[100006];
    List<List<Integer>>graph=new ArrayList<List<Integer>>();
    List<List<Integer>>ans=new ArrayList<List<Integer>>();
    void dfs(int node,int par){
        visited[node]=1;
        int u=node;
        low[node]=disc[node]=time++;
        insideStack[node]=1;
        st.add(node);
        for(int i=0;i<graph.get(node).size();i++){
            
            int v=graph.get(node).get(i);
            
            if(v!=par){
            //    System.out.println(u+" "+v);
            if(visited[node]==1 && insideStack[v]==1){
            low[u]=Math.min(low[u],disc[v]);
            }else{
                dfs(v,node);
                low[u]=Math.min(low[u],low[v]);
            }
            }
        }
        if(low[u]==disc[u]){
          //  ans++;
           // System.out.println(u);
            if(par!=-1){
                List<Integer>temp=new ArrayList<Integer>();
                temp.add(u);
                temp.add(par);
                ans.add(temp);
            }
            while(st.peek()!=u){
               int noden= st.pop();
                insideStack[noden]=0;
            }
            st.pop();
            insideStack[u]=0;
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       // int time=0;
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<connections.size();i++){
            graph.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            graph.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        for(int i=0;i<n;i++){
            visited[i]=0;
        }
        dfs(0,-1);
        return ans;
    }
}