class Solution {
    PriorityQueue<int[]>pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
        public int compare(int[] a,int[]  b){
            return Integer.compare(a[1],b[1]);
        }
    });
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph=new ArrayList<List<int[]>>(n+1);
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<int[]>());
        }
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int t=times[i][2];
            
            graph.get(u).add(new int[]{v,t});
        }
        int ans=0;
        pq.add(new int[]{k,0});
        int cnt=0;
        Set<Integer>st=new HashSet<Integer>();
        int time=-1;
        while(pq.size()>0){
            int[] node=pq.poll();
            int u=node[0];
            int timex=node[1];
            if(u==-1)continue;
          //  System.out.println(node[0]+" "+node[1]);
            if(st.contains(u)){
                
            }
            else{
                st.add(u);
             //   System.out.println(node[0]+" "+node[1]);
                if(timex>0){
                time=Math.max(time,timex);}
            for(int i=0;i<graph.get(u).size();i++){
                
                int v=graph.get(u).get(i)[0];
                int t=graph.get(u).get(i)[1];
               // System.out.println(u+" "+v);
                pq.add(new int[]{v,timex+t});
            }
            }
        }
        if(st.size()<n)return -1;
        return time;
    }
}