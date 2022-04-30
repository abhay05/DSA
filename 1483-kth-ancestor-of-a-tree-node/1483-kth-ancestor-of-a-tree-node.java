class TreeAncestor {
    
    int n;
    int[] anc;
    int[][] parent;

    public TreeAncestor(int n, int[] parent) {
        this.n=n;
        this.anc=parent;
        this.parent=new int[n+1][17];
        for(int j=0;j<17;j++){
        for(int i=0;i<n;i++){
            
                if(j==0){
                    this.parent[i][j]=this.anc[i];
                }else{
                    if(this.parent[i][j-1]==-1){
                      this.parent[i][j]=-1;  
                    }else{
                    this.parent[i][j]=this.parent[this.parent[i][j-1]][j-1];}
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int ans=node;
        for(int j=16;j>=0;j--){
            if(ans==-1)return ans;
            if(((k>>j)&1)==1){
                ans=this.parent[ans][j];
            }
        }
        return ans;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */