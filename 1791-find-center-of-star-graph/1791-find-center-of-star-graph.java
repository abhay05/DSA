class Solution {
    public int findCenter(int[][] edges) {
        int[] arr=new int[100001];
        int maxnode=0;
        for(int i=0;i<edges.length;i++){
            maxnode=Math.max(maxnode,Math.max(edges[i][0],edges[i][1]));
            arr[edges[i][0]]++;
            arr[edges[i][1]]++;
        }
        for(int i=1;i<=maxnode;i++){
            if(arr[i]==maxnode-1){
                return i;
            }
        }
        return -1;
    }
}