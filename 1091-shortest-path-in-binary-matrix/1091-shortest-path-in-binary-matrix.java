class Solution {
    int[] dirx=new int[]{-1,1,-1,1,1,0,-1,0};
    int[] diry=new int[]{-1,1,1,-1,0,-1,0,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[][] vis=new int[n][n];
        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>>pq=new PriorityQueue<Pair<Integer,Pair<Integer,Integer>>>(new Comparator<Pair<Integer,Pair<Integer,Integer>>>(){
            public int compare(Pair<Integer,Pair<Integer,Integer>> a, Pair<Integer,Pair<Integer,Integer>> b){
                return Integer.compare(a.getKey(),b.getKey());
            }
        });
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0)return -1;
        pq.add(new Pair(1,new Pair(0,0)));
        
        while(pq.size()>0){
            Pair<Integer,Pair<Integer,Integer>> curr=pq.poll();
            int currDist=curr.getKey();
            int currx=curr.getValue().getKey();
            int curry=curr.getValue().getValue();
            if(vis[currx][curry]==1)continue;
            vis[currx][curry]=1;
            if(currx==n-1 && curry==n-1)return currDist;
            for(int i=0;i<8;i++){
                int ncurrx=currx+dirx[i];
                int ncurry=curry+diry[i];
                if(ncurrx>=0 && ncurrx<n && ncurry>=0 && ncurry<n){
                    if(grid[ncurrx][ncurry]==0 && vis[ncurrx][ncurry]==0){
                        pq.add(new Pair(currDist+1,new Pair(ncurrx,ncurry)));
                    }
                }
            }
            
        }
        return -1;
    }
}