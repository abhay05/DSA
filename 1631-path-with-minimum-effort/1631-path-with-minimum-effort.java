class Solution {
    public int minimumEffortPath(int[][] heights) {
        Queue<Pair<Integer,Pair<Integer,Integer>>> q=new PriorityQueue<Pair<Integer,Pair<Integer,Integer>>>(new Comparator<Pair<Integer,Pair<Integer,Integer>>>(){
            public int compare(Pair<Integer,Pair<Integer,Integer>> a,Pair<Integer,Pair<Integer,Integer>> b){
                return a.getKey()-b.getKey();
            }
        });
        
        int[] diri=new int[]{-1,1,0,0};
        int[] dirj=new int[]{0,0,-1,1};
        
        int[][] visited=new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                visited[i][j]=0;
            }
        }
        
        q.add(new Pair(0,new Pair(0,0)));
        while(q.size()>0){
            Pair<Integer,Pair<Integer,Integer>> p=q.poll();
            int time=p.getKey();
            Pair<Integer,Integer> node=p.getValue();
            int nodei=node.getKey();
            int nodej=node.getValue();
            if(nodei==heights.length-1 && nodej==heights[0].length-1){
                return time;
            }
            if(visited[nodei][nodej]==1)continue;
            visited[nodei][nodej]=1;
            for(int i=0;i<4;i++){
                int newNodei=nodei+diri[i];
                int newNodej=nodej+dirj[i];
                if(newNodei>=0 && newNodei<heights.length && newNodej>=0 && newNodej<heights[0].length && visited[newNodei][newNodej]==0){
                    int height=Math.max(time,Math.abs(heights[nodei][nodej]-heights[newNodei][newNodej]));
                    q.add(new Pair(height,new Pair(newNodei,newNodej)));
                }
            }
        }
        return -1;
    }
}