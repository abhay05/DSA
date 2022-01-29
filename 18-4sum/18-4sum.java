class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                if(target-(nums[i]+nums[j])>nums[n-1]+nums[n-2])continue;
                //if(j+2<n){
                if(j+2<n && target-(nums[i]+nums[j])<nums[j+1]+nums[j+2])continue;
                // adding above two conditions of removing unncessary cases has
                // decreased run time from 20 ms 60 percentile to 5ms 97 percentile
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    int sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum<target){
                        k++;
                    }else if(sum>target){
                        l--;
                    }else{
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        while(nums[k]==nums[k-1] && k<l){
                            k++;
                        }
                        l--;
                        while(nums[l]==nums[l+1] && l>k){
                            l--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}