class Solution {
    public boolean isValidSudoku(char[][] board) {        
        for(int i=0;i<9;i++){
            HashMap<Character,Integer> temp1=new HashMap<Character,Integer>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                if(temp1.get(board[i][j]) !=null){
                    return false;
                }
                temp1.put(board[i][j],1);
            }
        }
        
        for(int i=0;i<9;i++){
            HashMap<Character,Integer> temp1=new HashMap<Character,Integer>();
            for(int j=0;j<9;j++){
                if(board[j][i]=='.')continue;
                if( temp1.get(board[j][i]) !=null){
                    return false;
                }
                temp1.put(board[j][i],1);
            }
        }      
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                 HashMap<Character,Integer> temp1=new HashMap<Character,Integer>();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        if(board[k+i*3][l+j*3]=='.')continue;
                        if(temp1.get(board[k+i*3][l+j*3]) !=null){
                            return false;
                        }
                        temp1.put(board[k+i*3][l+j*3],1);
                    }
                }
            }
        }
        
        return true;
    }
}