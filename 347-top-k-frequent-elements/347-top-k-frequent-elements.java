class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            }else{
                mp.put(nums[i],1);
            }
        }
      //  Entry<Integer,Integer>mp=mp.entrySet();
        List<Pair<Integer,Integer>>list=new ArrayList<>();
        for(Map.Entry<Integer,Integer>a:mp.entrySet()){
            list.add(new Pair(a.getKey(),a.getValue()));
        }
        Collections.sort(list,new Comparator<Pair<Integer,Integer>>(){
            public int compare(Pair<Integer,Integer>a,Pair<Integer,Integer>b){
                return b.getValue()-a.getValue();
            }
        });
        int[] ans=new int[k];
        for(int i=0;i<list.size();i++){
            if(i>=k)break;
            ans[i]=(list.get(i).getKey());
        }
        return ans;
    }
}