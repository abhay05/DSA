class Solution {
    int[] dirx=new int[]{0,0,1,-1};
    int[] diry=new int[]{1,-1,0,0};
    public int longestIncreasingPath(int[][] matrix) {
        PriorityQueue<Pair<Integer,Pair<Integer,Integer>>>pq=new PriorityQueue<Pair<Integer,Pair<Integer,Integer>>>(new Comparator<Pair<Integer,Pair<Integer,Integer>>>(){
       public int compare(Pair<Integer,Pair<Integer,Integer>> a,Pair<Integer,Pair<Integer,Integer>> b){
           return Integer.compare(b.getKey(),a.getKey());
       }     
        });
        int[][] visited=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                pq.add(new Pair(1,new Pair(i,j)));
                visited[i][j]=1;
            }
        } 
        int ans=0;
        while(pq.size()>0){
            Pair<Integer,Pair<Integer,Integer>> u=pq.poll();
            int x=u.getValue().getKey();
            int y=u.getValue().getValue();
            int len=u.getKey();
            ans=Math.max(ans,len);
            if(len<visited[x][y])continue;
            visited[x][y]=len;
            for(int i=0;i<4;i++){
                int x1=x+dirx[i];
                int y1=y+diry[i];
                if(x1>=0 && y1>=0 &&  x1<matrix.length && y1<matrix[0].length && matrix[x1][y1]>matrix[x][y]){
                    pq.add(new Pair(len+1,new Pair(x1,y1)));
                }
                
            }
            }
        return ans;
    }
}