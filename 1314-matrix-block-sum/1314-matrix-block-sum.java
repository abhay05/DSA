class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int ans[][] = new int[mat.length][mat[0].length];
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sum=0;
                for(int i1=Math.max(i-k,0);i1<Math.min(n,i+k+1);i1++){
                    for(int j1=Math.max(j-k,0);j1<Math.min(m,j+k+1);j1++){
                        sum+=mat[i1][j1];
                      //  System.out.println(i1+" "+j1+" "+mat[i1][j1]+" "+sum);
                    }
                }
                ans[i][j]=sum;
            }
        }
        return ans;
    }
}