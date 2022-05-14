class Solution {
    List<List<Integer>>ans=new ArrayList<List<Integer>>();
    public void recur(int n,int ind,List<Integer>list,int k){
        if(ind>9){
            if(n==0 && k==0){
                List<Integer>tmp=new ArrayList<Integer>();
                for(int i=0;i<list.size();i++){
                    tmp.add(list.get(i));
                }
                ans.add(tmp);
            }
            return ;
        }
        
        recur(n,ind+1,list,k);
        list.add(ind);
        recur(n-ind,ind+1,list,k-1);
        list.remove(new Integer(ind));
        return ;
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        recur(n,1,new ArrayList<Integer>(),k);
        return ans;
    }
}