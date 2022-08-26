class Solution {
    public List<List<Integer>> generate(int numRows) {
        int square[][]=new int[31][31];
        for(int i=0;i<numRows;i++){
            square[i][0]=1;
            square[i][i]=1;
        }
        for(int i=2;i<numRows;i++){
            for(int j=1;j<i;j++){
                square[i][j]=square[i-1][j-1]+square[i-1][j];
            }
        }
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer>temp=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                temp.add(square[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}