class Solution {
    
    void calculateThreat(int[][] threatCount,int ind,int j,int n,int val){
        for(int iind=ind,jind=j;iind<n && jind<n;iind++,jind++){
            threatCount[iind][jind]+=val;
        }
        
        for(int iind=ind,jind=j;iind>=0 && jind>=0;iind--,jind--){
            threatCount[iind][jind]+=val;
        }
        
        for(int iind=ind,jind=j;iind>=0 && jind<n;iind--,jind++){
            threatCount[iind][jind]+=val;
        }
        
        for(int iind=ind,jind=j;iind<n && jind>=0;iind++,jind--){
            threatCount[iind][jind]+=val;
        }
        
        for(int iind=0;iind<n;iind++){
            threatCount[iind][j]+=val;
        }
        for(int jind=0;jind<n;jind++){
            threatCount[ind][jind]+=val;
        }
    }
    
    List<List<String>>solve(char[][] chessBoard,int[][] threatCount,int ind,int n){
        if(ind==n){
            List<List<String>>temp=new ArrayList<List<String>>();
            List<String>tempAns=new ArrayList<String>();
            for(int i=0;i<n;i++){
                String s=new String(chessBoard[i]);
                tempAns.add(s);
            }
            temp.add(tempAns);
            return temp;
        }
        List<List<String>>ans=new ArrayList<List<String>>();
        for(int j=0;j<n;j++){
            if(threatCount[ind][j]==0){
                chessBoard[ind][j]='Q';
                calculateThreat(threatCount,ind,j,n,1);
                List<List<String>>temp=solve(chessBoard,threatCount,ind+1,n);
                for(int i=0;i<temp.size();i++){
                    ans.add(temp.get(i));
                }
                chessBoard[ind][j]='.';
                calculateThreat(threatCount,ind,j,n,-1); 
            }
        }
        return ans;
    }
    
    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessBoard[i][j]='.';
            }
        }
        int[][] threatCount=new int[n+1][n+1];
        List<List<String>>ans=solve(chessBoard,threatCount,0,n);
        return ans;
    }
}