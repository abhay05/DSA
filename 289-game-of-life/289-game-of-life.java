class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1},{-1,-1},{1,1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int cnt=0;
                for(int dir=0;dir<8;dir++){
                    int ni=i+dirs[dir][0];
                    int nj=j+dirs[dir][1];
                    if(ni>=0 && ni<board.length && nj>=0 && nj<board[0].length && (board[ni][nj]==1 || board[ni][nj]==3)){
                        cnt+=1;
                    }
                }
                if(board[i][j]==1){
                if(cnt>3 || cnt<2){
                    board[i][j]=3;
                }
                }else{
                    if(cnt==3){
                        board[i][j]=4;
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==3){
                    board[i][j]=0;
                }
                else if(board[i][j]==4){
                    board[i][j]=1;
                }
            }
        }
    }
}