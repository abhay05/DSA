class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]>q=new LinkedList<int[]>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        while(q.size()>0){
            int[] arr=q.poll();
            for(int j=0;j<matrix[0].length;j++){
                matrix[arr[0]][j]=0;
            }
            for(int i=0;i<matrix.length;i++){
                matrix[i][arr[1]]=0;
            }
        }
    }
}