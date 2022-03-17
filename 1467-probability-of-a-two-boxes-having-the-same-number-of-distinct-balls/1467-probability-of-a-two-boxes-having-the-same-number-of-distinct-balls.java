class Solution {
    
    double calcP(ArrayList<Integer> arr, int n){
        double ans=1;
        for(int ind=0,i=1;ind<n;ind++){
            for(int j=1;j<=arr.get(ind);j++,i++){
                ans*=(double)i;
                ans/=(double)j;
            }
         
        }
       
        return ans;
    }
    
    double recur(int[] balls,ArrayList<Integer> a,ArrayList<Integer> b,int x,int y,int ind,int n){
        if(ind==n){
            int sum1=0;
            int sum2=0;
            for(int i=0;i<x;i++){
                sum1+=a.get(i);
            }
            for(int j=0;j<y;j++){
                sum2+=b.get(j);
            }
            if(sum1!=sum2){
                return 0;
            }
            
            if(x!=y){
                return 0;
            }
            
            return calcP(a,x)*calcP(b,y);
            
        }
        double ans=0;
        for(int i=0;i<=balls[ind];i++){
            int xi=i;
            int yi=balls[ind]-xi;
            if(xi>0){
                a.add(xi);
                x+=1;
            }
            if(yi>0){
                b.add(yi);
                y+=1;
            }
            ans+=recur(balls,a,b,x,y,ind+1,n);
            if(xi>0){
                x-=1;
                a.remove(x); 
            }
            if(yi>0){
                y-=1;
                b.remove(y);
            }
        }
        
        return ans;
        
    }
    
    public double getProbability(int[] balls) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> ballsI = new ArrayList<Integer>();
        for(int i=0;i<balls.length;i++){
            ballsI.add(balls[i]);
        }
        int n=balls.length;
        double x=recur(balls,a,b,0,0,0,n);
        double y=calcP(ballsI,n);
        return x/y;
    }
}