class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] map=new int[n+1];
        for(int i=0;i<n+1;i++){
            map[i]=0;
        }
        for(int i=0;i<trust.length;i++){
            map[trust[i][1]]++;
            map[trust[i][0]]--;
        }
        for(int i=1;i<=n;i++){
           if(map[i]==n-1)return i;
        }
        return -1;
    }
}