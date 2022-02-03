class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix[0].length;
        int m=matrix.length;
        List<Integer> ans=new ArrayList<Integer>();
        int l=0;
        int r=n-1;
        int low=0;
        int down=m-1;
        int i=l;
        int j=low;
        while(true){
        for(i=l,j=low;i<=r;i++){
            ans.add(matrix[j][i]);
        }
        low++;
            if(l>r || down<low){
                break;
            }
        for(j=low,i=r;j<=down;j++){
            ans.add(matrix[j][i]);
        }
        r--;
            if(l>r || down<low){
                break;
            }
        for(i=r,j=down;i>=l;i--){
            ans.add(matrix[j][i]);
        }
        down--;
            if(l>r || down<low){
                break;
            }
        for(j=down,i=l;j>=low;j--){
            ans.add(matrix[j][i]);
        }
        l++;
            if(l>r || down<low){
                break;
            }
        }
        return ans;
    }
}