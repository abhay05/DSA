class Solution {
    HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
    int recur(int[] arr,int n,int ind,int p){
        if(ind>=n){
            return -1001;
        }
        if(mp.containsKey(ind*2+p)){
            return mp.get(ind*2+p);
        }
        int x1=ind+1<=n?recur(arr,n,ind+1,1-p):-1001;
        int x2=ind+2<=n?recur(arr,n,ind+2,1-p):-1001;
        int x3=ind+3<=n?recur(arr,n,ind+3,1-p):-1001;
       // System.out.println(x1+" "+x2+" "+x3+" "+ind);
        int val1=ind+1<=n?(p==1?arr[ind+0]:-1001):-1001;
        int val2=ind+2<=n?(p==1?arr[ind+0]+arr[ind+1]:-1001):-1001;
        int val3=ind+3<=n?(p==1?arr[ind+0]+arr[ind+1]+arr[ind+2]:-1001):-1001;
         if(p==1){
             int ans = Math.max(x1+val1,Math.max(x2+val2,x3+val3));
             mp.put(ind*2+p,ans);
             return ans;
         }
        else{
            int ans=Math.min(x1,Math.min(x2,x3));
            mp.put(ind*2+p,ans);
            return ans;
            }
    }
    
    public String stoneGameIII(int[] stoneValue) {
    int val=recur(stoneValue,stoneValue.length,0,1);
        int total=0;
        val=val+1001;
        //System.out.println("ans "+val);
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