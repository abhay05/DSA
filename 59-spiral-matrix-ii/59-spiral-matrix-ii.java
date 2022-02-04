class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int m=n;
        int l=0;
        int r=n-1;
        int low=0;
        int down=m-1;
        int i=l;
        int j=low;
        int num=1;
        
        while(true){
        for(i=l,j=low;i<=r;i++){
            ans[j][i]=num;
            num++;
        }
        low++;
            if(l>r || down<low){
                break;
            }
        for(j=low,i=r;j<=down;j++){
            ans[j][i]=num;
            num++;
        }
        r--;
            if(l>r || down<low){
                break;
            }
        for(i=r,j=down;i>=l;i--){
            ans[j][i]=num;
            num++;
        }
        down--;
            if(l>r || down<low){
                break;
            }
        for(j=down,i=l;j>=low;j--){
            ans[j][i]=num;
            num++;
        }
        l++;
            if(l>r || down<low){
                break;
            }
        }
        return ans;
    }
}