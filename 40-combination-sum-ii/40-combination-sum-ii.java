class Solution {
    
    List<List<Integer>> recur(int[] candidates,int ind,int target,List<Integer> list){
        if(target==0){
            // System.out.println(target);
            // System.out.println(list);
            List<List<Integer>> larr=new ArrayList<List<Integer>>();
            List<Integer> temp=new ArrayList<Integer>();
            for(int e:list){
                temp.add(e);
            }
            larr.add(temp);
            return larr;
        }
        if(ind>=candidates.length || target/candidates[ind]==0){
            return new ArrayList<List<Integer>>();
        }
        int rem=target;
        int ii=ind;
        while(ii<candidates.length && candidates[ii]==candidates[ind]){
            ii++;
        }
        List<List<Integer>> v1=recur(candidates,ii,rem,list);
        if(rem/candidates[ind]>0){
                list.add(candidates[ind]);
                rem-=candidates[ind];
            // System.out.println(rem);
            // System.out.println(list);
            List<List<Integer>>v2=recur(candidates,ind+1,rem,list);
         //   System.out.println(v2);
            if(v2.size()>0){
                for(List<Integer> e:v2){
                    v1.add(e);
                }
            }
                list.remove(list.size()-1);
                rem+=candidates[ind];
            
        }
        
        return v1;
        
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return recur(candidates,0,target,new ArrayList<Integer>());
    }
}