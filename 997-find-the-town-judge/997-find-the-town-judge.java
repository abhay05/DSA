class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] map=new int[n+1][n+1];
        for(int i=0;i<trust.length;i++){
            map[trust[i][1]][trust[i][0]]=1;
        }
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=1;j<=n;j++){
                if(map[i][j]==1){
                    cnt++;
                }
            }
            if(cnt==n-1){
                int ind=i;
                int cnt1=0;
                for(int k=1;k<=n;k++){
                    if(map[k][ind]==1){
                    cnt1++;
                }
                }
                if(cnt1==0){
                return i;}
            }
        }
        return -1;
    }
}