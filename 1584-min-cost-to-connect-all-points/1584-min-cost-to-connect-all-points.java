class Solution {
    
    int getParent(int node , int parent[]){
        if(node==parent[node])return node;
        
        return parent[node]=getParent(parent[node],parent);
    }
    
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>>pq=new PriorityQueue<Pair<Integer,Pair<Integer,Integer>>>((a,b)->a.getKey()-b.getKey());
        int [] parent=new int[points.length];
        int [] size=new int[points.length];
        
        for(int i=0;i<points.length;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int x1=points[j][0];
                int y1=points[j][1];
                int x2=points[i][0];
                int y2=points[i][1];
                int dist=Math.abs(y2-y1)+Math.abs(x2-x1);
                pq.add(new Pair(dist, new Pair(i,j)));
            }
        }
        
        int ans=0;
        while(pq.size()>0){
            Pair<Integer,Pair<Integer,Integer>> p = pq.poll();
            int node1=p.getValue().getKey();
            int node2=p.getValue().getValue();
            int parnode1=getParent(node1,parent);
            int parnode2=getParent(node2,parent);
          //  System.out.println(node1+" "+parnode1+" "+node2+" "+parnode2+" "+p.getKey());
            if(parnode1==parnode2)continue;
            ans+=p.getKey();
            int size1=size[parnode1];
            int size2=size[parnode2];
            if(size1>size2){
                parent[parnode2]=parnode1;
                size[parnode1]=size[parnode1]+size[parnode2];
            }else{
                parent[parnode1]=parnode2;
                size[parnode2]=size[parnode1]+size[parnode2];
            }
        }
        return ans;
    }
}