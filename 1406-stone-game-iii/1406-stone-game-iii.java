class Solution {
    HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
    int recur(int[] arr,int[] cumsum,int n,int ind){
        if(ind>=n){
            return -1001;
        }
        if(mp.containsKey(ind))return mp.get(ind);
        
        int x1=ind+1<=n?arr[ind]+cumsum[ind+1]-recur(arr,cumsum,n,ind+1):-1001;
        int x2=ind+2<=n?arr[ind]+arr[ind+1]+cumsum[ind+2]-recur(arr,cumsum,n,ind+2):-1001;
        int x3=ind+3<=n?arr[ind]+arr[ind+1]+arr[ind+2]+cumsum[ind+3]-recur(arr,cumsum,n,ind+3):-1001;
        int ans=Math.max(x1,Math.max(x2,x3));
        mp.put(ind,ans);
        return ans;
    }
    
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int [] cumsum = new int[n+3];
        cumsum[n]=-1001;
        cumsum[n+1]=-1001;
        cumsum[n+2]=-1001;
        cumsum[n-1]=stoneValue[n-1];
        for(int i=n-2;i>=0;i--){
            cumsum[i]=(cumsum[i+1]+stoneValue[i]);
        }
        
    int val=recur(stoneValue,cumsum,stoneValue.length,0);
        int total=0;
       // val=val+1001;
    //    System.out.println("ans "+val);
        for(int i=0;i<stoneValue.length;i++){
            total+=stoneValue[i];
        }
        if(val>total-val){
            return "Alice";
        }
        if(val==total-val){
            return "Tie";
        }
        return "Bob";
    }
}