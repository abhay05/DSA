class Solution {
    
    List<List<Integer>> recur(int[] nums,List<Integer> list,int check,int upp){
        if(check==upp){
            List<List<Integer>>li=new ArrayList<List<Integer>>();
            List<Integer>temp=new ArrayList<Integer>();
            for(int e:list){
                temp.add(e);
            }
            li.add(temp);
            return li;
        }
        List<List<Integer>> v=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            if((check&(1<<i))>0){
                continue;
            }
            list.add(nums[i]);
            check=(check^(1<<i));
            List<List<Integer>> v1=recur(nums,list,check,upp);
            for(List<Integer>e:v1){
                v.add(e);
            }
            list.remove(list.size()-1);
            check=(check^(1<<i));
        }
        return v;
    }
    
    
    public List<List<Integer>> permute(int[] nums) {
        int upp=(int)Math.pow(2,nums.length)-1;
        return recur(nums,new ArrayList<Integer>(),0,upp);
    }
}