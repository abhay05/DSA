class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int l=0;
        int r=n-1;
        int low=0;
        int down=n-1;
        while(l<=r && low<=down){
            for(int i=l;i<r;i++){
                int val=r-l;
                int j=low;
                int i1=i;
                int j1=j;
                int temp=matrix[j][i];
                //matrix[i1][j1]=matrix[i][j];
                // if(l==0){
                // System.out.println(i);
                // System.out.println(j);}
                
                while(true){
                    
                    
                    if(j1==low && val>0){
                        if(i1+val>=r){
                        val=val-(r-i1);
                        i1=r;
                        }else{
                        i1+=val;
                        val=0;
                        }    
                    }
                    if(i1==r && val>0){
                        if(j1+val>=down){
                            val=val-(down-j1);
                            j1=down;
                        }else{
                            j1+=val;
                            val=0;
                        }
                    }
                    if(j1==down && val>0){
                        if(i1-val<=l){
                            val=val-(i1-l);
                            i1=l;
                        }else{
                            i1-=val;
                            val=0;
                        }
                    }
                    if(i1==l && val>0){
                        if(j1-val<=low){
                            val=val-(j1-low);
                            j1=low;
                        }else{
                            j1-=val;
                            val=0;
                        }
                    }
                //     if(l==0){
                //         System.out.println("i1");
                //     System.out.println(i1);
                //         System.out.println("j1");
                // System.out.println(j1);
                //     System.out.println("val");
                //         System.out.println(val);
                //     }
                    if(val==0){
                    int temp1=matrix[j1][i1];
                    matrix[j1][i1]=temp;
                    temp=temp1;
                        val=r-l;
                    if(i1==i && j1==j)break;}
                }
            }
            low++;
            down--;
            l++;
            r--;
        }
    }
}