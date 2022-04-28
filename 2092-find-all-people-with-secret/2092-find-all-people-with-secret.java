class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<Pair<Integer,Integer>>>graph=new ArrayList<List<Pair<Integer,Integer>>>(n+1);
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Pair<Integer,Integer>>());
        }
        for(int i=0;i<meetings.length;i++){
            graph.get(meetings[i][0]).add(new Pair(meetings[i][1],meetings[i][2]));
            graph.get(meetings[i][1]).add(new Pair(meetings[i][0],meetings[i][2]));
        }
        
        Queue<Pair<Integer,Integer>>q=new PriorityQueue<Pair<Integer,Integer>>(new Comparator<Pair<Integer,Integer>>(){
            public int compare(Pair<Integer,Integer> a,Pair<Integer,Integer> b){
                return a.getKey()-b.getKey();
            }
        });
        
        int[] visited=new int[n+1];
        for(int i=0;i<=n;i++){
            visited[i]=0;
        }
        
        q.add(new Pair(0,0));
        q.add(new Pair(0,firstPerson));
        
        while(q.size()>0){
            Pair<Integer,Integer> p=q.poll();
            int currTime=p.getKey();
            int node=p.getValue();
            if(visited[node]==1)continue;
            visited[node]=1;
            for(int i=0;i<graph.get(node).size();i++){
                Pair<Integer,Integer> pv=graph.get(node).get(i);
                int v=pv.getKey();
                int time=pv.getValue();
                if(visited[v]==0 && time>=currTime){
                    q.add(new Pair(time,v));
                }
            }
        }
        
        List<Integer> ans= new ArrayList<Integer>();
        for(int i=0;i<=n;i++){
            if(visited[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}