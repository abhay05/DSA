class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer,List<int[]>>graph=new HashMap();
        long[] cnt=new long[n];
        long[] dist=new long[n];
        int mod=1000000007;
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<int[]>());
            dist[i]=-1;
            cnt[i]=0;
        }
        for(int i=0;i<roads.length;i++){
            graph.get(roads[i][0]).add(new int[]{roads[i][1],roads[i][2]});
            graph.get(roads[i][1]).add(new int[]{roads[i][0],roads[i][2]});
        }
        
        dist[0]=0;
        cnt[0]=1;
        Queue<long[]>qu=new PriorityQueue<long[]>(n,(a,b)-> Long.compare(a[0],b[0]));
        qu.add(new long[]{0,0});
        while(!qu.isEmpty()){
            long[] p=qu.poll();
            if(p[1]==n-1){return (int)cnt[(int)p[1]];}
            List<int[]>temp=graph.get((int)p[1]);
            for(int i=0;i<temp.size();i++){
                if(dist[temp.get(i)[0]]>p[0]+(long)temp.get(i)[1] || dist[temp.get(i)[0]]==-1){
                    cnt[temp.get(i)[0]]=cnt[(int)p[1]];
                    dist[temp.get(i)[0]]=p[0]+(long)temp.get(i)[1];
                    qu.add(new long[]{dist[(int)temp.get(i)[0]],temp.get(i)[0]});
                }else if(dist[temp.get(i)[0]]==(long)(p[0]+temp.get(i)[1])){
                    cnt[temp.get(i)[0]]=(cnt[temp.get(i)[0]]+cnt[(int)p[1]])%mod;
                  //  qu.add(new int[]{dist[temp.get(i)[0]],temp.get(i)[0]});
                    
                }
            }
        }
        return (int)cnt[n-1];
    }
}