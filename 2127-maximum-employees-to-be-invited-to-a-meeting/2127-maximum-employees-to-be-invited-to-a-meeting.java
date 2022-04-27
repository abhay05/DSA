class Solution {
    
    int t=0;
    Stack<Integer> st=new Stack<Integer>();
    int[] size=new int[100001];
    
    public void zero(int[] visited, int n){
        for(int i=0;i<n;i++){
            visited[i]=0;
        }
    }
    
    public int dfs(List<List<Integer>>rgraph,int[] visited,int n,int src){
        visited[src]=1;
        int l=0;
        for(int i=0;i<rgraph.get(src).size();i++){
            int v=rgraph.get(src).get(i);
            if(visited[v]==0){
               l=Math.max(l,dfs(rgraph,visited,n,v));
            }
        }
      //  System.out.println(src+" "+l);
        return l+1;
    }
    
    public void dfs1(int[] favorite,int[] visited,int src){
        visited[src]=1;
        if(visited[favorite[src]]==0){
        dfs1(favorite,visited,favorite[src]);
        }
        st.add(src);
    }
    
    public void dfs2(List<List<Integer>>rgraph,int[] visited,int src){
        visited[src]=1;
        size[t]++;
        for(int i=0;i<rgraph.get(src).size();i++){
            int v=rgraph.get(src).get(i);
            if(visited[v]==0){
                dfs2(rgraph,visited,v);
            }
        }
        
    }
    
    public int maximumInvitations(int[] favorite) {
        Queue<Pair<Integer,Integer>> q=new LinkedList<Pair<Integer,Integer>>();
        List<List<Integer>> rgraph=new ArrayList<List<Integer>>();
        int n=favorite.length;
        int[] visited=new int[n];
        zero(visited,n);
        for(int i=0;i<n;i++){
            if(i==favorite[favorite[i]] && visited[i]==0 && visited[favorite[i]]==0){
                visited[i]=1;
                visited[favorite[i]]=1;
                q.add(new Pair(i,favorite[i]));
            }
        }
        for(int i=0;i<n;i++){
            rgraph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            rgraph.get(favorite[i]).add(i);
        }
        
        
        int val=0;
        while(q.size()>0){
            Pair<Integer,Integer> p=q.poll();
            int src=p.getKey();
            int src1=p.getValue();
            t=0;
            zero(visited,n);
            rgraph.get(src).remove(new Integer(src1));
            rgraph.get(src1).remove(new Integer(src));
            int ans=dfs(rgraph,visited,n,src);
            t=0;
            zero(visited,n);
            int ans1=dfs(rgraph,visited,n,src1);
            val+=ans+ans1;
            rgraph.get(src).add(new Integer(src1));
            rgraph.get(src).add(new Integer(src));
            //System.out.println(src+" "+src1+" "+ans+" "+ans1);
        }
        
        //System.out.println(val);
        zero(visited,n);
        for(int i=0;i<n;i++){
            if(visited[i]==0){
        dfs1(favorite,visited,i);
                
            }
        }
        for(int i=0;i<n;i++){
            size[i]=0;
        }
        zero(visited,n);
        while(st.size()>0){
            int node=st.pop();
            if(visited[node]==0){
                t++;
                dfs2(rgraph,visited,node);
            }
        }
        int val2=0;
        for(int i=0;i<n;i++){
            val2=Math.max(val2,size[i]);
            
        }
        //System.out.println(val+" "+val2);
        return Math.max(val,val2);
        
    }
}